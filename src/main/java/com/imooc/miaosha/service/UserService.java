package com.imooc.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.User;
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getById(int i) {
        return userDao.getById(i);
    }

    @Transactional
    public void tx() {
        User u1 = new User();
        u1.setId(1L);
        u1.setNickname("user1");
        userDao.insert(u1);

        User u2 = new User();
        u2.setId(2L);
        u2.setNickname("user2");
        userDao.insert(u2);
    }

}
