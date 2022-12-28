package com.util;
import com.bean.CatInfo;
import com.bean.CatRecord;
import com.bean.FeedRecord;
import com.bean.User;

import java.sql.*;
import java.util.ArrayList;

public class LinkDB {
    static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/catdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    static final String USER = "root";
    static final String PASS = "mysql";

    private Connection conn = null;
    private Statement stmt=null;

    public void connectDB()
    {
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }

    public void insertDB(String sql){
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }finally {
            // 关闭资源
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2){
            }// 什么都不做
        }
    }

    public User searchDBUser(String sql)
    {
        try{
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            int id = 0;
            String name = null;
            String pwd = null;
            while(rs.next()) {
                id = rs.getInt("u_id");
                name = rs.getString("u_name");
                pwd = rs.getString("u_pwd");
            }
            User u=new User(id,name,pwd);
            return u;
        }catch(SQLException se)
        {
            // 处理 JDBC 错误
            se.printStackTrace();
        }finally {
            // 关闭资源
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2){
            }// 什么都不做
        }
        return null;
    }

    public ArrayList<CatInfo> searchDBCatInfo(String sql)
    {
        ArrayList<CatInfo> list=new ArrayList<>();
        try{
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            int cat_id;
            String cat_name;
            int cat_breed;
            int cat_color;
            int cat_character;
            String cat_position;
            int cat_count;
            while(rs.next()) {
                cat_id = rs.getInt("cat_id");
                cat_name = rs.getString("cat_name");
                cat_breed = rs.getInt("cat_breed");
                cat_color=rs.getInt("cat_color");
                cat_character=rs.getInt("cat_character");
                cat_position=rs.getString("cat_position");
                cat_count=rs.getInt("cat_count");
                CatInfo catInfo=new CatInfo(cat_id,cat_name,cat_breed,cat_color,cat_character,cat_position,cat_count);
                list.add(catInfo);
            }
            return list;
        }catch(SQLException se)
        {
            // 处理 JDBC 错误
            se.printStackTrace();
        }finally {
            // 关闭资源
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2){
            }// 什么都不做
        }
        return null;
    }

    public ArrayList<CatRecord> searchDBCatRecord(String sql)
    {
        ArrayList<CatRecord> list=new ArrayList<>();
        try{
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            int record_id;
            int cat_id;
            String username;
            String cat_position;
            String record_time;
            String last_update;
            while(rs.next()) {
                record_id = rs.getInt("record_id");
                cat_id = rs.getInt("cat_id");
                username = rs.getString("username");
                cat_position=rs.getString("cat_position");
                record_time=rs.getString("record_time");
                last_update=rs.getString("last_update");
                CatRecord catRecord=new CatRecord(record_id,cat_id,username,cat_position,record_time,last_update);
                list.add(catRecord);
            }
            return list;
        }catch(SQLException se)
        {
            // 处理 JDBC 错误
            se.printStackTrace();
        }finally {
            // 关闭资源
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2){
            }// 什么都不做
        }
        return null;
    }

    public ArrayList<FeedRecord> searchDBFeedRecord(String sql)
    {
        ArrayList<FeedRecord> list=new ArrayList<>();
        try{
            stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            int record_id;
            int cat_id;
            String username;
            String cat_position;
            String record_time;
            String feed_food;
            String last_update;
            while(rs.next()) {
                record_id = rs.getInt("record_id");
                cat_id = rs.getInt("cat_id");
                username = rs.getString("username");
                cat_position=rs.getString("cat_position");
                record_time=rs.getString("record_time");
                feed_food=rs.getString("feed_food");
                last_update=rs.getString("last_update");
                FeedRecord feedRecord=new FeedRecord(record_id,cat_id,username,cat_position,record_time,feed_food,last_update);
                list.add(feedRecord);
            }
            return list;
        }catch(SQLException se)
        {
            // 处理 JDBC 错误
            se.printStackTrace();
        }finally {
            // 关闭资源
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2){
            }// 什么都不做
        }
        return null;
    }

    public void closeDB(){
        try{
            if(conn!=null) {
                conn.close();
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}
