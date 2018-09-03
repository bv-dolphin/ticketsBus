package com.osprey.studio.service.security;

import com.google.common.collect.ImmutableSet;
import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.domain.enums.State;
import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.repository.UserRepository;
import com.osprey.studio.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * Регистрация пользователя;
 */
@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;


    public SignUpServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder, UserService userService, UserService userService1) {
        this.repository = usersRepository;
        this.passwordEncoder = passwordEncoder;

        this.userService = userService1;
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
    public boolean signUp(User userRegistration) {
        if (StringUtils.isEmpty(userRegistration.getEmail()) || repository.findByEmail(userRegistration.getEmail()).isPresent()) {
            return false;
        }
        userService.generateCode(userRegistration);

        String hashPassword = passwordEncoder.encode(userRegistration.getPassword()); //Шифруем пароль пользователя

        User user = User.builder()  //Конвертируем информацию с внешней формы UserRegistration в полноценного пользователя User;
//                .firstName(userRegistration.getFirstName())
//                .lastName(userRegistration.getLastName())
                .password(hashPassword)
                .email(userRegistration.getEmail())
                .roles(ImmutableSet.of(Role.GUEST))
                .state(State.ACTIVE)
                .activationCode(userRegistration.getActivationCode())
                .build();

      String message = String.format(
                "Привет, %s \n" + "Доббро пожаловать на наш сайт One Click Bus. " +
                        "Пожалуйста активируйте ваш аккаунт по сслыке http://localhost:8080/activate/%s",
                user.getEmail(),
                user.getActivationCode()
      );
      String titleMassage = "Activation code!";

        userService.sendMessage(user, message, titleMassage);
        repository.save(user);
        return true;
    }
}
