package com.github.web.service.impl;


import com.github.web.entity.User;
import com.github.web.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/8 17:23
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getByUserName(String userName) {
        User user = new User();
        user.setUserName("admin");
        user.setPassword(DigestUtils.md5DigestAsHex("admin".getBytes()));
        return user;
    }
}
