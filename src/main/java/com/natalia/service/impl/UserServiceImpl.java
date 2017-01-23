package com.natalia.service.impl;

import com.natalia.persistence.dao.UserDao;
import com.natalia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.natalia.persistence.entity.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        List<User> users = userDao.findAll();
        return users;
    }



}
