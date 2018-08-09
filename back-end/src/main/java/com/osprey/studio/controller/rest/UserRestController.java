package com.osprey.studio.controller.rest;

import com.osprey.studio.controller.rest.common.AbstractBaseRestController;
import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.forms.UserRegistrationForm;
import com.osprey.studio.service.UserService;
import com.osprey.studio.service.common.BaseService;
import com.osprey.studio.service.security.SignUpService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.osprey.studio.controller.rest.BusRestController.NAME_RESOURCE;

@RestController
@RequestMapping("/" + UserRestController.ROOT_PATH)
@Api(description = "/" + NAME_RESOURCE)
public class UserRestController extends AbstractBaseRestController<User> {

    public static final String ROOT_PATH = "users";
    public static final String NAME_RESOURCE = "name_resurses";

    private final UserService userService;
    private final SignUpService signUpService;


    public UserRestController(UserService userService, SignUpService signUpService) {
        this.userService = userService;
        this.signUpService = signUpService;
    }

    /**
     * Сохранение пользователя через Rest, принимаем JSON;
     */
    @PostMapping()
    public ResponseEntity<Object> addUser(@RequestBody UserRegistrationForm userRegistrationForm) {
        signUpService.signUp(userRegistrationForm);
        return ResponseEntity.ok().build();
    }

    @Override
    protected BaseService<User> getService() {
        return userService;
    }
}
