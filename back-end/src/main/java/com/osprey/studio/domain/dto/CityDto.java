package com.osprey.studio.domain.dto;


import com.osprey.studio.domain.entities.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Builder
public class CityDto {

    private String cityName;

    public static CityDto from(City city) {
        return CityDto.builder()
                .cityName(city.getCityName())
                .build();
    }

    public static List<CityDto> from(List<City> cities) {
        return cities.stream().map(CityDto::from).collect(Collectors.toList());
    }
}
