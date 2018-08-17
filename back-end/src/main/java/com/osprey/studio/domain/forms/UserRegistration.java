package com.osprey.studio.domain.forms;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistration {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
