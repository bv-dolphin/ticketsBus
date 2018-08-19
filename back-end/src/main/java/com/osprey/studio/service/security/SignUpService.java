package com.osprey.studio.service.security;

import com.osprey.studio.domain.forms.UserRegistration;

public interface SignUpService {

    boolean signUp(UserRegistration userRegistration);

}
