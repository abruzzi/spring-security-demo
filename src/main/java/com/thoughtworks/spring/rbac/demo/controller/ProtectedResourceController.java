package com.thoughtworks.spring.rbac.demo.controller;

import com.thoughtworks.spring.rbac.demo.entity.Message;
import com.thoughtworks.spring.rbac.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/protected")
public class ProtectedResourceController {

    @Autowired
    private PermissionService permissionService;

    @PreAuthorize("@permissionService.check(principal, #id)")
    @RequestMapping("/{id}")
    public Message getOne(@PathVariable("id") String id) {
        return new Message("Protected resource");
    }
}
