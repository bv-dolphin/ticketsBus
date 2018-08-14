package com.osprey.studio.security.token;

import com.osprey.studio.security.filters.TokenJwtFilter;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfigurer  extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    private final TokenProvider tokenProvider;

    public JWTConfigurer(final TokenProvider tokenProvider) {
        super();
        this.tokenProvider = tokenProvider;
    }

    /**
     * Добавление фильтра TokenJwtFilter перед UsernamePasswordAuthenticationFilter - в таком случаи указанный фильтр не срабатывает;
     * SecurityConfig -> ApiWebSecurityConfigurationAdapter- > void configure(HttpSecurity http)
     */
    @Override
    public void configure(HttpSecurity http) {
        final TokenJwtFilter customFilter = new TokenJwtFilter(this.tokenProvider);

        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
