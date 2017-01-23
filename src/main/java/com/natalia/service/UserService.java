package com.natalia.service;

import com.natalia.persistence.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
}
