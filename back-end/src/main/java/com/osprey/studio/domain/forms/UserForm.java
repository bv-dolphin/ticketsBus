package com.osprey.studio.domain.forms;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
