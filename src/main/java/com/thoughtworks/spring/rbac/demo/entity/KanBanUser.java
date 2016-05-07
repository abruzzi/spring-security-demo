package com.thoughtworks.spring.rbac.demo.entity;

public class KanBanUser {
    public KanBanUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
