package com.thoughtworks.spring.rbac.demo.service;

import com.thoughtworks.spring.rbac.demo.entity.Message;
import org.springframework.stereotype.Service;

@Service
public class MockUserService {
    public Message getUserByName(String name) {
        return new Message("Qiu Juntao");
    }
}
