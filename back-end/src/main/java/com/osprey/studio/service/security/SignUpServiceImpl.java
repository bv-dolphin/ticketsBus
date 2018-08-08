package com.osprey.studio.service.security;

import com.google.common.collect.ImmutableSet;
import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.domain.enums.State;
import com.osprey.studio.domain.forms.UserForm;
import com.osprey.studio.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

    public SignUpServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .password(hashPassword)
                .email(userForm.getEmail())
                .roles(ImmutableSet.of(Role.USER))
                .state(State.ACTIVE)
                .build();

        usersRepository.save(user);
    }
}
