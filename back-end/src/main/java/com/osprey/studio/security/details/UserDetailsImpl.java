package com.osprey.studio.security.details;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.State;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Адаптер к модели безопасности Spring;
 */
@Getter
public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }
    /**
     * Роли пользователя;
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getRoles();
    }
    /**
     * Пароль пользователя;
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    /**
     * Логин пользователя;
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }
    /**
     * Срок действия аккаунта не истек;
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    /**
     * Аккаунт не заблокирован;
     */
    @Override
    public boolean isAccountNonLocked() {
        return !user.getState().equals(State.BANNED);
    }
    /**
     * Пароль действительный;
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    /**
     * Аккаунт активный;
     */
    @Override
    public boolean isEnabled() {
        return user.getState().equals(State.ACTIVE);
    }
}
