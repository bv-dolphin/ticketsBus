package com.osprey.studio.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static com.osprey.studio.domain.User.BUN_NULL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@Entity
@Table(name = "tokens_tbl",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"session", "user_id"}, name = "token_unique"),
                @UniqueConstraint(columnNames = "session", name = "session_unique")})
public class Token extends BaseEntity {
    public static final int LENGTH = 100;

    @NotNull(message = "errors.tokens.token-session.not-null")
    @Column(name = "session", nullable = BUN_NULL, length = LENGTH)
    private String tokenSession;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "tokens_users_fk"))
    private User user;

}