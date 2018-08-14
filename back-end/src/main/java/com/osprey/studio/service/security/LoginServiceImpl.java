package com.osprey.studio.service.security;

import com.osprey.studio.domain.forms.UserLogin;
import com.osprey.studio.security.token.TokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Процедура Authentication;
 */
@Service
public class LoginServiceImpl  implements LoginService{

    private final TokenProvider tokenProvider;

    private final AuthenticationManager authenticationManager;

    public LoginServiceImpl(TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Получить токен по credentials;
     */
    @Override
    public String createToken(UserLogin userLogin) {
        final UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(userLogin.getLogin(), userLogin.getPassword());

        final Authentication authentication = this.authenticationManager.authenticate(authToken);   // получаем пользователя (проверка логина и пароля)- магия;

        SecurityContextHolder.getContext().setAuthentication(authentication);   // помещаем в контекст Spring Security;

        final boolean rememberMe = userLogin.getRememberMe() == null ? false : userLogin.getRememberMe();

        return this.tokenProvider.createToken(authentication, rememberMe, false);
    }

}
