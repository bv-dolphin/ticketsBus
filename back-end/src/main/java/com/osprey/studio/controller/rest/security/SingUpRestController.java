package com.osprey.studio.controller.rest.security;

import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.service.security.SignUpService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.osprey.studio.controller.rest.BusRestController.NAME_RESOURCE;

/**
 * Сохраниение пользователя через Rest;
 */
@RestController
@RequestMapping("/" + SingUpRestController.ROOT_PATH)
@Api(description = "/" + NAME_RESOURCE)
public class SingUpRestController  {

    public static final String ROOT_PATH = "api/public";
    public static final String NAME_RESOURCE = "name_resurses";

    private final SignUpService signUpService;


    public SingUpRestController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    /**
     * Сохранение пользователя через Rest, принимаем JSON;
     */
    @PostMapping("/signUp")
    public ResponseEntity<Object> signUp(@RequestBody UserRegistration userRegistration) {
        signUpService.signUp(userRegistration);
        return ResponseEntity.ok().build();
    }

}
