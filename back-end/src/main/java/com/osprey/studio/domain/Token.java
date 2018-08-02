package com.osprey.studio.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Table(name = "token_tbl")
@AllArgsConstructor
@NoArgsConstructor
public class Token extends BaseEntity {

    @NotNull
    @Column(name = "session", nullable = false, length = 255, unique = true)
    private String tokenSession;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

}