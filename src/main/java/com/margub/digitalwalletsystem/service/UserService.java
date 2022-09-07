package com.margub.digitalwalletsystem.service;

import com.margub.digitalwalletsystem.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    Map<String, User> userMap = new HashMap<>();
    public String createUser(String name) {
        User user = new User(name);
        userMap.put(user.getId(), user);
        return user.getId();
    }
}
