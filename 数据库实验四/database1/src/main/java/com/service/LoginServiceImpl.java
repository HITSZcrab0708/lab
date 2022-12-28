package com.service;

import com.bean.User;
import com.dao.LoginDao;
import com.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
    @Override
    public User loginService(User u) {
        LoginDao ld= new LoginDaoImpl();
        return ld.logindao(u);
    }

}
