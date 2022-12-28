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

@WebServlet("/checkin")
public class CheckInServlet extends HttpServlet {
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
        String cat_id=req.getParameter("cat_id");
        String username=req.getParameter("username");
        String cat_position=req.getParameter("cat_position");
        String record_time=req.getParameter("record_time");
        String feed_food=req.getParameter("feed_food");
        LinkDB linkDB=new LinkDB();
        linkDB.connectDB();
        String sql="INSERT INTO `catdb`.`feed_record` (cat_id,username,cat_position,record_time,feed_food) VALUES ("+cat_id+", '"+username+"', '"+cat_position+"','"+record_time+"','"+feed_food+"')";
//        insert into feed_record(cat_id,username,cat_position,record_time,feed_food)
//        values(4,"a1","主楼","2022/12/19","鱼干");
        linkDB.insertDB(sql);
        linkDB.closeDB();
    }
}
