package com.osprey.studio.security.token;

import com.google.common.io.BaseEncoding;
import com.osprey.studio.domain.entities.Token;
import com.osprey.studio.repository.TokensRepository;
import com.osprey.studio.security.details.UserDetailsImpl;
import com.osprey.studio.security.details.UserDetailsServiceImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Даємо на вход обєк користувача, дає токін
 */
@Component("tokenProvider")
public class TokenProvider {

    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);
    /** Секретное слово */
    private final SecretKey secretKeyBaseEncoding;

    private final TokensRepository tokensRepository;

    private final UserDetailsServiceImpl userDetailsService;

    private static final String AUTHORITIES_KEY = "auth";

    private final String secretKey;

    @Value("${jwt.tokenValidityInMilliseconds}")
    private long tokenValidityInMilliseconds;

    @Value("${jwt.tokenValidityInMillisecondsForRememberMe}")
    private long tokenValidityInMillisecondsForRememberMe;


    public TokenProvider(TokensRepository tokensRepository, UserDetailsServiceImpl userDetailsService, @Value("${jwt.secretKey}") String secretKey) {
        this.secretKey = secretKey;
        this.tokensRepository = tokensRepository;
        this.userDetailsService = userDetailsService;

        byte[] decodedKey = BaseEncoding.base64().decode(secretKey);                        // Шифруємо секретне слово;
        secretKeyBaseEncoding = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    /**
     * Создание токина;
     * Authentication от Spring Security
     */
    public String createToken(final Authentication authentication, final Boolean rememberMe , final Boolean save) {

        String jwtToken = getToken(authentication, rememberMe);

        if (! save)
            return jwtToken;

        Token token = new Token();
        token.setTokenSession(jwtToken);
        token.setUser((com.osprey.studio.domain.entities.User) authentication.getPrincipal());

        tokensRepository.save(token);

        return jwtToken;


    }

    /**
     * Создание токина;
     * Authentication от Spring Security
     */
    private String getToken(Authentication authentication, Boolean rememberMe) {
        final String roles = authentication.getAuthorities().stream() // Получаем список ролей;
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));


        final Date validity = setLifeTimeToken(rememberMe); // Время жизни токина;

        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim(TokenProvider.AUTHORITIES_KEY, roles)
                .signWith(SignatureAlgorithm.HS512, this.secretKeyBaseEncoding)
                .setExpiration(validity)
                .compact();
    }

    /**
     * Время жизни токена;
     */
    private Date setLifeTimeToken(Boolean rememberMe) {
        Date validity;
        final long now = new Date().getTime();

        if (rememberMe) {
            validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe); // Mаксимальное;
        } else {
            validity = new Date(now + this.tokenValidityInMilliseconds);

        }
        return validity;
    }

    /**
     * Расшифровка токина без использование хранилища;
     */
    public Authentication getAuthentication(final String token) {

        final Claims claims = Jwts.parser()
                .setSigningKey(this.secretKeyBaseEncoding)
                .parseClaimsJws(token)
                .getBody();


        final Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(TokenProvider.AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        final User principal = new User(claims.getSubject(), "", authorities);    // User пользователя от Spring;

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    /**
     * Расшифровка токина используя хранилище;
     */
    public Authentication getAuthentication(final String token, Boolean fromStorage) {

        TokenAuthentication tokenAuthentication = new TokenAuthentication(token);

        Optional<Token> tokenCandidate = tokensRepository.findOneByTokenSession(token);

        if (tokenCandidate.isPresent() && fromStorage) {
            UserDetails userDetails = new UserDetailsImpl(tokenCandidate.get().getUser());
            tokenAuthentication.setUserDetails(userDetails);
            tokenAuthentication.setAuthenticated(true);
            return tokenAuthentication;
        }

        tokenAuthentication.setAuthenticated(false);

        return tokenAuthentication;
    }

    /**
     * Проверка токина на целосность;
     */
    public boolean validateToken(final String authToken) {
        try {
            Jwts.parser().setSigningKey(this.secretKeyBaseEncoding).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            this.log.info("Invalid JWT signature.");
            this.log.trace("Invalid JWT signature trace: {}", e);
        } catch (MalformedJwtException e) {
            this.log.info("Invalid JWT token.");
            this.log.trace("Invalid JWT token trace: {}", e);
        } catch (ExpiredJwtException e) {
            this.log.info("Expired JWT token.");
            this.log.trace("Expired JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {
            this.log.info("Unsupported JWT token.");
            this.log.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            this.log.info("JWT token compact of handler are invalid.");
            this.log.trace("JWT token compact of handler are invalid trace: {}", e);
        }
        return false;
    }


}
