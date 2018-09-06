package net.togogo.service;

import net.togogo.bean.User;

public interface UserService {

    //判断用户是否注册成功
    boolean createUser (User user);

    //判断邮箱是否存在
    boolean checkExist (String email);
}
