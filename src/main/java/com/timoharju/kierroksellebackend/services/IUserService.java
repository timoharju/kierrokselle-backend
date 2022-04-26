package com.timoharju.kierroksellebackend.services;

import com.timoharju.kierroksellebackend.models.Role;
import com.timoharju.kierroksellebackend.models.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User>getUsers();
}