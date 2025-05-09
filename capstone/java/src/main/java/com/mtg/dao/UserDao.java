package com.mtg.dao;

import com.mtg.model.RegisterUserDto;
import com.mtg.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    User createUser(RegisterUserDto user);
}
