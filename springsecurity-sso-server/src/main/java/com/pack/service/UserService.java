package com.pack.service;


import com.pack.model.SysUser;

public interface UserService {

    /**
     * 根据用户名获取系统用户
     */
    SysUser getUserByName(String username);

}
