package com.osprey.studio.domain.entities;

import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.domain.enums.State;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
@Entity
@Table(name = "users_tbl",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email", name = "email_unique")})
public class User extends BaseEntity {

    public static final boolean BUN_NULL = false;
    public static final int LENGTH = 100;

//    @NotBlank(message = "errors.user.firstname.not-null")
    @Column(name = "fist_name",  length = LENGTH)
    private String firstName;

//    @NotBlank(message = "errors.user.last-name.not-null")
    @Column(name = "last_name",  length = LENGTH)
    private String lastName;

  //  @NotBlank(message = "errors.user.password.not-null")

    @Column(name = "password",nullable = BUN_NULL, length = LENGTH)
    private String password;

    @Email(message = "errors.user.email.value.email_not_correct")
    @Column(name = "email", nullable = BUN_NULL, length = LENGTH, unique = true) //unique уникальное значение
    private String email;

    @Column(name = "active")
    private Boolean active;

    @Enumerated(EnumType.STRING)
    @Column(name = "state_enum")
    private State state;
    @Column(name = "active_code")
    private String activationCode;



    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user2roles_tbl",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            foreignKey = @ForeignKey(name = "users2roles_user_fk"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "roles_enum"}))
    @Enumerated(EnumType.STRING)
    @Column(name = "roles_enum", length = LENGTH_ENUM )
    private Set<Role> roles = new HashSet<>();

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }
    public boolean isGuest() { return roles.contains(Role.GUEST);
    }

}