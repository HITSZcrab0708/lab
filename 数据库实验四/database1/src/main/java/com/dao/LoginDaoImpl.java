package com.dao;

import com.bean.User;
import com.util.LinkDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao{
    @Override
    public User logindao(User u) {
        String name=u.getU_name();
        String pwd=u.getU_pwd();
        LinkDB link=new LinkDB();
        link.connectDB();
        String sql="select * from users_info where u_name='"+name+"' and u_pwd='"+pwd+"'";
        User u1=link.searchDBUser(sql);
        link.closeDB();
        return u1;
    }
}
