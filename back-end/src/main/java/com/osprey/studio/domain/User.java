package com.osprey.studio.domain;

import com.osprey.studio.domain.enums.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users_tbl",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email", name = "email_unique")})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true)
public class User extends BaseEntity implements UserDetails {

    public static final boolean BUN_NULL = false;
    public static final int LENGTH = 100;

    @NotBlank(message = "errors.user.firstname.not-null")
    @Column(name = "fist_name", nullable = BUN_NULL, length = LENGTH)
    private String firstName;

    @NotBlank(message = "errors.user.last-name.not-null")
    @Column(name = "last_name", nullable = BUN_NULL, length = LENGTH)
    private String lastName;

    @NotBlank(message = "errors.user.password.not-null")
    @Column(name = "password", nullable = BUN_NULL, length = LENGTH)
    private String password;

    @Email(message = "errors.user.email.value.email_not_correct")
    @Column(name = "email", nullable = BUN_NULL, length = LENGTH) //unique уникальное значение
    private String email;

    @Column(name = "active")
    private Boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user2roles_tbl",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = BUN_NULL),
            foreignKey = @ForeignKey(name = "users2roles_user_fk"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "roles_enum"}))
    @Enumerated(EnumType.STRING)
    @Column(name = "roles_enum", length = LENGTH_ENUM, nullable = BUN_NULL )
    private Set<Role> roles = new HashSet<>();


    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email; // ?????
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getActive();
    }


}