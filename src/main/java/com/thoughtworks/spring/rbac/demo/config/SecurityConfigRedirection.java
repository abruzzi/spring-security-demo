package com.thoughtworks.spring.rbac.demo.config;

import com.thoughtworks.spring.rbac.demo.service.W3UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigRedirection extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(preAuthProvider());
    }

    private AuthenticationProvider preAuthProvider() {
        PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
        provider.setPreAuthenticatedUserDetailsService(new W3UserDetailsService());

        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(new LinkForbiddenEntryPoint())
                .and()
                .addFilter(getW3AuthenticationFilter())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

        //http.exceptionHandling().authenticationEntryPoint(myEntryPoint);
        //.addFilter(getW3AuthenticationFilter(), W3Interceptor.class)
    }

    @Bean
    public W3AuthenticationFilter getW3AuthenticationFilter() throws Exception {
        W3AuthenticationFilter filter = new W3AuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());

        return filter;
    }

}
