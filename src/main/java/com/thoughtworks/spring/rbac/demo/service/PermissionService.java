package com.thoughtworks.spring.rbac.demo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    public boolean check(User currentUser, String id) {

        System.err.println(currentUser);
        System.err.println(id);
        return false;
    }
}
