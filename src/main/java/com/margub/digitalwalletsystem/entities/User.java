package com.margub.digitalwalletsystem.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    String id;
    String name;

    public User(String name) {
        id = UUID.randomUUID().toString();
        this.name = name;
    }
}
