package com.osprey.studio.domain.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

            USER, ADMIN, MANAGER, GUEST, DRIVER;

    @Override
    public String getAuthority() {
        return name();
    }

}
