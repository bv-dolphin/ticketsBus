package com.osprey.studio.service;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.repository.UserRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;


public class UserService extends AbstractBaseService<User> {
    //comment
    public final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<User, Long> getRepository() {
        return null;
    }
}