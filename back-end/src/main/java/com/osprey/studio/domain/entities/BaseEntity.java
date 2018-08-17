package com.osprey.studio.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass  //  авто авторайд в другие классы
public abstract class BaseEntity {
    public static final int LENGTH_ENUM = 20;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}