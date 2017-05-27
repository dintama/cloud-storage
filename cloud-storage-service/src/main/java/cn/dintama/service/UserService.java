package cn.dintama.service;

import cn.dintama.entity.User;

/**
 * Created by Dintama on 2017/5/25.
 */
public interface UserService {

    User getUserByEmail(String email);

    Boolean validateLogin(User user);

    Boolean validateSignUp(User user);
}
