package com.osprey.studio.security.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

/**
 * Удобно для отладки - компонент который следить за событиями ПО;
 */
public class AuthenticationEventListener  implements ApplicationListener<AbstractAuthenticationEvent> {
    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {

        if (event instanceof InteractiveAuthenticationSuccessEvent) {
            return;
        }

        Authentication authentication = event.getAuthentication();

        String auditMessage = "Login attempt with username: " +
                authentication.getName() + " " +
                authentication.getAuthorities() + " " +
                authentication.getCredentials() + " " +
                authentication.getPrincipal() + " " +
                "\t\tSuccess: " + authentication.isAuthenticated();

        System.out.println(auditMessage);
    }
}
