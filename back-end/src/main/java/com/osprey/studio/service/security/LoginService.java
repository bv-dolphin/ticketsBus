package com.osprey.studio.service.security;

import com.osprey.studio.domain.forms.LoginForm;
import com.osprey.studio.domain.transfer.TokenDto;

public interface LoginService {
    TokenDto login(LoginForm loginForm);
}
