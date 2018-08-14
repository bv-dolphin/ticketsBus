package com.osprey.studio.domain.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Получение данные(сredentials) о пользователи с внешней формы;
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin {

    private String login;
    private String password;
    private Boolean rememberMe;

}
