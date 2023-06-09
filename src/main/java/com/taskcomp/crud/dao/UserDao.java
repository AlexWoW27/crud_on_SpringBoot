package com.taskcomp.crud.dao;

import com.taskcomp.crud.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();

    void save(User user);

    void delete(Long id);

    void update(Long id, User updateUser);

    User show(Long id);

}
