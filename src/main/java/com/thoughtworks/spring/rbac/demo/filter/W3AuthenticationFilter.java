package com.thoughtworks.spring.rbac.demo.filter;

import com.thoughtworks.spring.rbac.demo.service.MockUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import javax.servlet.http.HttpServletRequest;

public class W3AuthenticationFilter extends
        AbstractPreAuthenticatedProcessingFilter {
    @Autowired
    MockUserService mockUserService;

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String w3Id = (String) request.getAttribute("w3");
        System.err.println(mockUserService.getUserByName(w3Id));
        return new PreAuthenticatedAuthenticationToken(w3Id, "nb");
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return null;
    }
}
