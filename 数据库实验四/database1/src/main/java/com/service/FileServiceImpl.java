package com.service;

import com.bean.CatInfo;
import com.bean.User;
import com.util.LinkDB;

import java.util.ArrayList;

public class FileServiceImpl implements FileService{

    @Override
    public ArrayList<CatInfo> getAllInfo() {
        LinkDB link=new LinkDB();
        link.connectDB();
        String sql="select * from cat_info";
        ArrayList<CatInfo> list=link.searchDBCatInfo(sql);
        link.closeDB();
        return list;
    }
}
