package com.osprey.studio.repository;

import com.osprey.studio.domain.entities.City;
import com.osprey.studio.repository.common.BaseRepository;

import java.util.List;

public interface CityRepository extends BaseRepository<City, Long> {

    List<City> findByNameContaining(String s);
}
