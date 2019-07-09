package com.github.web.service;

import com.github.web.entity.User;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/8 16:51
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     * @param userName :
     * @return com.github.memory.entity.User
     * @throws
     */
    User getByUserName(String userName);
}
