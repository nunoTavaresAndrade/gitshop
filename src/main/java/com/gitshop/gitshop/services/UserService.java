package com.gitshop.gitshop.services;

import com.gitshop.gitshop.models.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}