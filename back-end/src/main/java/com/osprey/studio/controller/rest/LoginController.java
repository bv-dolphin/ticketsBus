package com.osprey.studio.controller.rest;

import com.osprey.studio.domain.forms.LoginForm;
import com.osprey.studio.domain.transfer.TokenDto;
import com.osprey.studio.service.security.LoginService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Клиент вводит логин и пароль и получает токин;
     * RequestBody - параметры;
     */
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginForm loginForm) {
        return ResponseEntity.ok(loginService.login(loginForm));
    }
}
