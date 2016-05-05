package com.thoughtworks.spring.rbac.demo.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class W3LoginEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private String loginFormUrl;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        String current = request.getRequestURL().toString();

        redirectStrategy.sendRedirect(request, response, loginFormUrl+"?return="+current);
    }

    public W3LoginEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        this.loginFormUrl = loginFormUrl;
    }
}
