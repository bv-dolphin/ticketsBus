package com.osprey.studio.service.security;

import com.google.common.collect.ImmutableSet;
import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.domain.enums.State;
import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Регистрация пользователя;
 */
@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.repository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Автоматическая генерация root пользователя;
     */
    @PostConstruct
    public void init() {
        String login = "admin@localhost";

        if (!repository.findByEmail(login).isPresent()) {
            repository.save(User.builder()
                    .firstName("firstName")
                    .lastName("lastName")
                    .password(passwordEncoder.encode("password"))
                    .email(login)
                    .roles(ImmutableSet.of(Role.ADMIN))
                    .state(State.ACTIVE)
                    .build());
        }
    }

    /**
     * Сохранение пользоватебя в хранилищи;
     */
    @Override
    public boolean signUp(UserRegistration userRegistration) {
        if (repository.findByEmail(userRegistration.getEmail()).isPresent()) {
            return false;
        }


        String hashPassword = passwordEncoder.encode(userRegistration.getPassword()); //Шифруем пароль пользователя

        User user = User.builder()  //Конвертируем информацию с внешней формы UserRegistration в полноценного пользователя User;
//                .firstName(userRegistration.getFirstName())
//                .lastName(userRegistration.getLastName())
                .password(hashPassword)
                .email(userRegistration.getEmail())
                .roles(ImmutableSet.of(Role.USER))
                .state(State.ACTIVE)
                .build();

        repository.save(user);
        return true;
    }
}
