package com.osprey.studio.repository;

import com.osprey.studio.domain.entities.Token;
import com.osprey.studio.domain.entities.User;
import com.osprey.studio.repository.common.BaseRepository;

import java.util.Optional;

public interface TokensRepository extends BaseRepository<Token, Long> {

    Optional<Token> findOneByTokenSession(String token);
}
