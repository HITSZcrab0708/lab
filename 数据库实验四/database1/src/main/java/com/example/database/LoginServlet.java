package com.example.database;

import com.bean.CatInfo;
import com.bean.User;
import com.service.FileService;
import com.service.FileServiceImpl;
import com.service.LoginService;
import com.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
        User u=new User();
        u.setU_name(u_name);
        u.setU_pwd(u_pwd);
        //实现登录服务层的逻辑
        LoginService l=new LoginServiceImpl();
        User user=l.loginService(u);
        if(u_name.equals(user.getU_name())&&u_pwd.equals(user.getU_pwd()))
        {
            FileService fs=new FileServiceImpl();
            ArrayList<CatInfo> arr=fs.getAllInfo();
            req.setAttribute("user",user);
            req.setAttribute("arr",arr);
            req.getRequestDispatcher("mainpage.jsp").forward(req,resp);
        }
        else
        {
            req.setAttribute("error","账户和密码不一致");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
