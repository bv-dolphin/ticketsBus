package com.osprey.studio.domain.forms;

import com.osprey.studio.domain.entities.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UserRegistration extends User{

      @Email(message = "Email is not correct")
      @NotBlank(message = "Email cannot be empty")
      private String email;
      @NotBlank(message = "Password cannot be empty")
      private String password;
      /*@NotBlank(message = "Confirm password cannot be empty")
      private String confirmPassword;*/

      private String activationCode;


}
