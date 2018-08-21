package com.osprey.studio.config;

import com.osprey.studio.security.token.JWTConfigurer;
import com.osprey.studio.security.token.TokenProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService detailsService;
    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;
    private final TokenProvider tokenProvider;

    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService detailsService,
                          PasswordEncoder passwordEncoder,
                          @Qualifier("dataSource") DataSource dataSource,
                          TokenProvider tokenProvider) {
        this.detailsService = detailsService;
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
        this.tokenProvider = tokenProvider;
    }

    /**
     * Конфигурация безопасности для URL(Rest);
     */
    @Configuration
    @Order(1)
    public class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .userDetailsService(detailsService)
                    .antMatcher("/api/*")
                    .csrf()
                    .disable()
                    .headers()
                    .frameOptions()
                    .disable()
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/api/public/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .apply(this.securityConfigurerAdapter());

        }

        private JWTConfigurer securityConfigurerAdapter() {
            return new JWTConfigurer(SecurityConfig.this.tokenProvider);
        }

        @Bean(name = "apiAuthManager")
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }
    }

    /**
     * Конфигурация безопасности для Session;
     */
    @Configuration
    public class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                        .antMatchers("/public/**", "/registration**", "/recovery**", "/activate/*").permitAll()
                        .antMatchers("/static/**").permitAll()
                        .anyRequest().authenticated()
                    .and()
                        .formLogin()
                            .loginPage("/public/login")
                                .usernameParameter("email")
                    .defaultSuccessUrl("/public/main")
                        .permitAll()
                    .and()
                        .rememberMe()
                            .rememberMeParameter("remember-me")
                        .tokenRepository(tokenRepository())
                    .and()
                        .logout()
                        .deleteCookies("JSESSIONID")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                        .logoutSuccessUrl("/public/login")
                    .and()
                        .exceptionHandling();
        }
        /**
         * Хранилище для ИД сессии(кто зашел) пользователя для SESSION COOKIE BASED;
         * JdbcTokenRepositoryImpl взаимодействует с таблицей где хранится информация о сессии пользователя;
         * Таблица создается скриптом data.sql;
         */
        @Bean(name = "tokenRepository")
        public PersistentTokenRepository tokenRepository() {
            JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
            tokenRepository.setDataSource(dataSource);
            return tokenRepository;
        }
        /**
         * Адаптация модели безопасности Spring к источнику хранение пользователей;
         * detailsService - какой сервис использовать для загрузки пользователя по логину;
         * passwordEncoder - способ шифрование пароля;
         */
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(detailsService).passwordEncoder(passwordEncoder);
        }
    }



}
