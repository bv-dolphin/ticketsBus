package com.osprey.studio.repository;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.repository.common.BaseRepository;

public interface UserRepository extends BaseRepository<User, Long> {
    User findByEmail(String email);
}
