package com.osprey.studio.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
@Table(name = "bus_station_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class BusStation extends BaseEntity {

    @NotNull
    @Size(min = 3, max = 100, message = "errors.busstation.value.max")
    @Column(name = "bus_station_name", nullable = false, length = 255,unique = true)
    private String busStationName;

    @Size(min = 3, max = 100, message = "errors.busstation.value.max")
    @Column(name = "street_name", nullable = true, length = 255,unique = false)
    private String streetName;
    @Size(min = 3, max = 100, message = "errors.busstation.value.max")
    @Column(name = "latitude", nullable = true, length = 255,unique = false)
    private String latitude;
    @Size(min = 3, max = 100, message = "errors.busstation.value.max")
    @Column(name = "longitude", nullable = true, length = 255,unique = false)
    private String longitude;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")

    private City city;

}