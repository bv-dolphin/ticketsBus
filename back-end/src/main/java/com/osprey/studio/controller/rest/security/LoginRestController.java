package com.osprey.studio.controller.rest.security;

import com.osprey.studio.domain.forms.UserLogin;
import com.osprey.studio.domain.transfer.JWTToken;
import com.osprey.studio.security.token.JWTConfigurer;
import com.osprey.studio.service.security.LoginService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Получение Token по UserLogin(пользователь и пароль);
 */
@RestController
@RequestMapping("/api/public")
public class LoginRestController {

    private final LoginService loginService;

    public LoginRestController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Проверить полученого пользователя;
     */
    @GetMapping("/login")
    public String isAuthenticated(final @RequestBody HttpServletRequest request) {
        return request.getRemoteUser();
    }

    /**
     * Получить токен по UserLogin;
     */
    @PostMapping("login")
    public ResponseEntity<JWTToken> login(final @RequestBody UserLogin userLogin) {

        final String jwt = loginService.createToken(userLogin);
        final HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
    }


}
