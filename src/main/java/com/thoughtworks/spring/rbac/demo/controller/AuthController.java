package com.thoughtworks.spring.rbac.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping
    public ResponseEntity<String> simpleAuth(@RequestHeader(value="X-KANBAN-TOKEN", defaultValue = "") String token) {
        if(StringUtils.isEmpty(token)) {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>("Authorized", HttpStatus.OK);
        }
    }
}
