package com.osprey.studio.domain.entities;

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
    @Size(min = 3, max = 20, message = "errors.busstation.busstationname.value.size")
    @Column(name = "bus_station_name", nullable = false, length = 20, unique = true)
    private String busStationName;

    @Size(min = 3, max = 100, message = "errors.busstation.streetname.value.size")
    @Column(name = "street_name", nullable = true, length = 100, unique = false)
    private String streetName;

    @Size(min = 3, max = 100, message = "errors.busstation.latitude.value.size")
    @Column(name = "latitude", nullable = true, length = 100, unique = false)
    private String latitude;

    @Size(min = 3, max = 100, message = "errors.busstation.longitude.value.size")
    @Column(name = "longitude", nullable = true, length = 100, unique = false)
    private String longitude;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

}