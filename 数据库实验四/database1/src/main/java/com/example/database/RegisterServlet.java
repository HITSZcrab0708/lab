package com.example.database;

import com.bean.User;
import com.service.LoginService;
import com.service.LoginServiceImpl;
import com.util.LinkDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u_name=req.getParameter("u_id");
        String u_pwd=req.getParameter("u_pwd");
        LinkDB linkDB=new LinkDB();
        linkDB.connectDB();
        String sql="INSERT INTO `catdb`.`users_info` (`u_id`, `u_name`, `u_pwd`) VALUES (null, '"+u_name+"', '"+u_pwd+"')";
        linkDB.insertDB(sql);
        linkDB.closeDB();
    }
}
