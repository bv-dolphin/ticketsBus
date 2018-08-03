package com.osprey.studio.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "bus_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Bus extends BaseEntity {
    @NotBlank
    @Size(min = 3, max = 100, message = "errors.bus.busbrand.value.size")
    @Column(name = "bus_brand", nullable = false, length = 255, unique = true)     //unique уникальное значение
    private String busBrand;

    @NotNull
    @Size(min = 3, max = 100, message = "errors.bus.placeamount.value.size")
    @Column(name = "place_amount", nullable = false, length = 255, unique = true)
    private Integer placeAmount;

    @Column(name = "condition")
    private Boolean condition;

    @Column(name = "wifi")
    private Boolean wifi;


}