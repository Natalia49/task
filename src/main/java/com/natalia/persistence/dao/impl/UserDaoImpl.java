package com.natalia.persistence.dao.impl;

import com.natalia.persistence.dao.UserDao;
import com.natalia.persistence.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao{
    public UserDaoImpl() {
        super(User.class);
    }
}
