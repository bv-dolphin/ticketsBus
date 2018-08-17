package com.osprey.studio.domain.forms;

import com.osprey.studio.domain.entities.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistration extends User  {

      private String email;
      private String firstName;
      private String lastName;
      private String login;
      private String password;


}
