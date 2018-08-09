package com.osprey.studio.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService detailsService;
    private final PasswordEncoder passwordEncoder;
    private final DataSource dataSource;

    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService detailsService,
                          PasswordEncoder passwordEncoder,
                          @Qualifier("dataSource") DataSource dataSource) {
        this.detailsService = detailsService;
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
    }

    /**
     * Настройка доступа URL к и частичное изменение параметров безопасности;
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
//                Доступ к URL по роли;
//                .antMatchers("/users/**").hasAuthority("ADMIN")
//                Доступно всем;
                .antMatchers("/signUp/**").permitAll()
//                Доступно при авторизации;
                .antMatchers("/").authenticated()
//                Другие запросы должны быть авторизированы;
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                 Переопределение встроенной переменной в Spring. Получаем из формы;
                .usernameParameter("login")
//                Переопределение стандартной формы авторизации на свою;
                .loginPage("/login")
//                Переход после авторизации;
                .defaultSuccessUrl("/")
//                Доступ к форме login разрешён;
                .permitAll()
                .and()
//                Запомнить SESSION пользователя;
                .rememberMe()
//                Переопределение встроенной переменной в Spring. Получаем из формы;
                .rememberMeParameter("remember-me")
//                Где находить «токены»;
                .tokenRepository(tokenRepository())
                .and()
//                Иначе ошибка There was an unexpected error (type=Not Found, status=404)
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
//        http.csrf().disable();
    }

    /**
     * Хранилище для ИД сессии(кто зашел) пользователя для SESSION COOKIE BASED;
     * JdbcTokenRepositoryImpl взаимодействует с таблицей где хранится информация о сессии пользователя;
     * Таблица создается скриптом data.sql;
     */
    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    /**
     * Адаптация модели безопасности Spring к источнику хранение пользователей;
     * detailsService - хранилище пользователей;
     * passwordEncoder - способ шифрование пароля;
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailsService).passwordEncoder(passwordEncoder);
    }

}
