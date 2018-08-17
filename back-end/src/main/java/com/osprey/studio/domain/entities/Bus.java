package com.osprey.studio.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "bus_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Bus extends BaseEntity {
    @NotNull
    @Size(min = 3, max = 100, message = "errors.bus.busbrand.value.size")
    @Column(name = "bus_brand", nullable = false, length = 100, unique = true)     //unique уникальное значение
    private String busBrand;

    @NotNull
    @Column(name = "place_amount", nullable = false)
    private Integer placeAmount;
    @NotNull
    @Column(name = "bus_condition")
    private Boolean condition;
    @NotNull
    @Column(name = "wifi")
    private Boolean wifi;


}