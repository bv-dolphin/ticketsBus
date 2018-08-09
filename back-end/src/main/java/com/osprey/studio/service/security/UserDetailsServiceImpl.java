package com.osprey.studio.service.security;

import com.google.common.collect.ImmutableSet;
import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.domain.enums.State;
import com.osprey.studio.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Получение информации о пользователе по логину;
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }
    /**
     *
     */
    @PostConstruct
    public void init() {
        String login = "admin@localhost";

        if (!usersRepository.findByEmail(login).isPresent()) {
            usersRepository.save(User.builder()
                    .firstName("firstName")
                    .lastName("lastName")
                    .password(passwordEncoder.encode("password"))
                    .email(login)
                    .roles(ImmutableSet.of(Role.ADMIN))
                    .state(State.ACTIVE)
                    .build());
        }
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new
                UserDetailsImpl(usersRepository.findByEmail(email)
                .orElseThrow(IllegalArgumentException::new));
    }

/*    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                Optional<User> userCandidate = usersRepository.findByEmail(email);
        if (userCandidate.isPresent()) {
            return new UserDetailsImpl(userCandidate.get());
        } else throw new IllegalArgumentException("User not found");
    }*/


}
