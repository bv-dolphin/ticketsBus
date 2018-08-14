package com.osprey.studio.security.details;

import com.osprey.studio.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Получение информации о пользователе по логину и заполняем UserDetails;
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository usersRepository;

    public UserDetailsServiceImpl(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Поиск пользователя в хранилище и загрузка в UserDetails;
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new UserDetailsImpl(usersRepository.findByEmail(email)
                .orElseThrow(IllegalArgumentException::new));
    }

}
