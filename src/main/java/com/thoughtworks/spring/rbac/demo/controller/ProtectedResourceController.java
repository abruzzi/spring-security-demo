package com.thoughtworks.spring.rbac.demo.controller;

import com.thoughtworks.spring.rbac.demo.entity.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/protected")
public class ProtectedResourceController {

    @RequestMapping("/{id}")
    public Message getOne(Principal principal, @PathVariable("id") String id) {
        return new Message("Protected resource for: "+principal.getName());
    }
}
