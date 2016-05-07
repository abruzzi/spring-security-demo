package com.thoughtworks.spring.rbac.demo.entity;

public class KanBanUser {
    private String name;

    public KanBanUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
