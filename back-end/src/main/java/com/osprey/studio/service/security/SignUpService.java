package com.osprey.studio.service.security;

import com.osprey.studio.domain.forms.UserRegistrationForm;

public interface SignUpService {
    void signUp(UserRegistrationForm userRegistrationForm);
}
