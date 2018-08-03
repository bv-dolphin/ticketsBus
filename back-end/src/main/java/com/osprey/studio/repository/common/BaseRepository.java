package com.osprey.studio.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;


@NoRepositoryBean   // не создавал  бины с этого класса
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

}
