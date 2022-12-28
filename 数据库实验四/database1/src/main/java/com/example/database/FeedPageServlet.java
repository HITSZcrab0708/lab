package com.example.database;

import com.bean.CatRecord;
import com.bean.FeedRecord;
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
import java.util.ArrayList;

@WebServlet("/feed")
public class FeedPageServlet extends HttpServlet {
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
        User user =new User(2,"admin","admin");
        LinkDB linkDB=new LinkDB();
        linkDB.connectDB();
        String sql="select * from feed_record";
        ArrayList<FeedRecord> arr;
        arr=linkDB.searchDBFeedRecord(sql);
        linkDB.closeDB();
        req.setAttribute("user",user);
        req.setAttribute("arr",arr);
        req.getRequestDispatcher("feedpage.jsp").forward(req,resp);
    }
}
