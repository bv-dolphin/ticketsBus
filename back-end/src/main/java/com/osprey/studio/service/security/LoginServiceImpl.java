package com.osprey.studio.service.security;

import com.osprey.studio.domain.entities.Token;
import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.forms.LoginForm;
import com.osprey.studio.domain.transfer.TokenDto;
import com.osprey.studio.repository.TokensRepository;
import com.osprey.studio.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.osprey.studio.domain.transfer.TokenDto.from;

@Service
public class LoginServiceImpl  implements LoginService{

    private final TokensRepository tokensRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository usersRepository;

    public LoginServiceImpl(TokensRepository tokensRepository, PasswordEncoder passwordEncoder, UserRepository usersRepository) {
        this.tokensRepository = tokensRepository;
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public TokenDto login(LoginForm loginForm) {
//        Поиск пользователя по электронной почте;
        Optional<User> userCandidate = usersRepository.findByEmail(loginForm.getLogin());

        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
//            Сравнение паролей (в базе и что было введено в форму) у пользователя;
            if (passwordEncoder.matches(loginForm.getPassword(), user.getPassword())) {
//                Генерация уникального токина;
                Token token = Token.builder()
                        .user(user)
                        //TODO Create token;
                        .tokenSession("token:alksdj;aksjd;skjdskdj;s")
                        .build();

                tokensRepository.save(token);
//                Конвертация Token -> TokenDto;
                return from(token);
            }
        } throw new IllegalArgumentException("User not found");
    }
}
