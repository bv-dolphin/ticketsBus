package com.osprey.studio.repository;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.repository.common.BaseRepository;

import java.util.Optional;


public interface UserRepository extends BaseRepository<User, Long> {
   Optional <User> findByEmail(String email);
}
