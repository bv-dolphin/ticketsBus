package com.osprey.studio.service.security;

import com.osprey.studio.domain.forms.UserLogin;

public interface LoginService {
     String createToken(UserLogin userLogin);
}
