package com.swh.blog.service;

import com.swh.blog.po.User;


public interface UserService {

    User checkUser(String username, String password);
}
