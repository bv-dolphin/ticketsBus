package com.osprey.studio.domain.forms;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationForm {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
