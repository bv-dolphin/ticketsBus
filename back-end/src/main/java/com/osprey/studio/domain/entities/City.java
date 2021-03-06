package com.osprey.studio.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "city_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class City extends BaseEntity {

    @NotBlank(message = "error.city.cityname.isnull")
    @Size(min = 3, max = 50, message = "errors.city.cityName.value.size")
    @Column(name = "city", nullable = false, length = 50, unique = true)
    private String cityName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id")
    private Region region;

}