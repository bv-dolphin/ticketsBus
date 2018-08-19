package com.osprey.studio.service;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.State;
import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.repository.UserRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserService extends AbstractBaseService<User> {
    //comment
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    protected BaseRepository<User, Long> getRepository() {
        return userRepository;
    }


    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void registration(UserRegistration user) {
        User userCondidat = new User();
        userCondidat.setState(State.ACTIVE);

        if (!StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }


    }


}
