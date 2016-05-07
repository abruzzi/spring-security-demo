package com.thoughtworks.spring.rbac.demo.service;

import com.thoughtworks.spring.rbac.demo.entity.KanBanUser;
import com.thoughtworks.spring.rbac.demo.entity.KanBanUserDetails;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class KanBanAuthenticationUserDetailsService
        implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
        String principal = (String) token.getPrincipal();
        if(principal != null) {
            return new KanBanUserDetails(new KanBanUser(principal));
        }

        return null;
    }
}
