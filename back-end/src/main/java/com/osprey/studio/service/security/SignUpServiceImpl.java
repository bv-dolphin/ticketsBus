package com.osprey.studio.service.security;

import com.google.common.collect.ImmutableSet;
import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.domain.enums.State;
import com.osprey.studio.domain.forms.UserRegistrationForm;
import com.osprey.studio.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.repository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(UserRegistrationForm userRegistrationForm) {
        //Шифруем пароль пользователя
        String hashPassword = passwordEncoder.encode(userRegistrationForm.getPassword());
        //Конвертируем информацию с внешней формы UserRegistrationForm в полноценного пользователя User;
        User user = User.builder()
                .firstName(userRegistrationForm.getFirstName())
                .lastName(userRegistrationForm.getLastName())
                .password(hashPassword)
                .email(userRegistrationForm.getLogin())
                .roles(ImmutableSet.of(Role.USER))
                .state(State.ACTIVE)
                .build();

        repository.save(user);
    }
}
