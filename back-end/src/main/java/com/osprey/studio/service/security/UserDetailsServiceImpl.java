package com.osprey.studio.service.security;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository usersRepository;

    public UserDetailsServiceImpl(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
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
