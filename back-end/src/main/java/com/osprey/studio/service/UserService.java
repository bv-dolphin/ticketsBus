package com.osprey.studio.service;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.repository.UserRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractBaseService<User> {
    //comment
    @Autowired
    public UserRepository userRepository;

    @Override
    protected BaseRepository<User, Long> getRepository() {
        return null;
    }


    }
