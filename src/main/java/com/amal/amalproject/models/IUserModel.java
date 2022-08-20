package com.amal.amalproject.models;

import com.amal.amalproject.entities.User;

import java.util.List;

public interface IUserModel {
    User addUser(User user);
    List<User> getAllUsers();
}
