<%--
  Created by IntelliJ IDEA.
  User: crab0708
  Date: 2022/12/25
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主界面</title>
    <style>
        #head_{
            height: 100px;
            width: 100%;
            background-color: #47b2ee;
        }
        #personFile{
            width: 120px;
            height: 50px;
            padding-top: 25px;
            margin-left: 90%;
        }
        #search{
            height: 70px;
            width: 100%;
            background-color: cornflowerblue;
        }
        #inner_s{
            /*width: 200px;
            height: 40px;
            padding-right: 70%;
            padding-top: 50%;*/
            width: 30%;
            padding-top:25px;
            padding-left: 45%;
        }
        #table{
            margin-left: 30%;
            margin-top: 30px;
        }
        td{
            text-align: center;
            height: 20px;
            width: 150px;
            border: #f1ecec 1px solid;
            padding:1px;

        }

    </style>

</head>
<body>

<div id="head_">
    <div id="personFile">
        名字:<span style="color: #f3f2f8">${user.getU_name()}</span><br>
        编号:<span style="color: #f5efef">${user.getU_id()}</span>
    </div>
</div>

<div id="search">
    <div id="inner_s">
        <input type="text" style="font-size: 20px; height: 26px;width: 100px" placeholder="输入id查询">&nbsp;&nbsp;
        <button  id="btn1" style="font-size: 18px; height: 28px;">查询</button>
        <button  id="btn2" style="font-size: 18px; height: 28px;">新增</button>
        <button  id="btn3" style="font-size: 18px; height: 28px;">喂食记录</button>
        <button  id="btn4" style="font-size: 18px; height: 28px;">打卡记录</button>
    </div>
    <script>
        let btn003=document.getElementById("btn3");
        btn003.onclick=function ()
        {
            window.location.href="feed?";
        }
        let btn004=document.getElementById("btn4");
        btn004.onclick=function ()
        {
            window.location.href="record?"
        }
    </script>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr >
            <td>id</td>
            <td>昵称</td>
            <td>种类</td>
            <td>颜色</td>
            <td>性格</td>
            <td>栖息地</td>
            <td>打卡次数</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${arr}" var="item">
            <tr>
                <td>${item.getCat_id()}</td>
                <td>${item.getCat_name()}</td>
                <td>${item.getCat_breed()}</td>
                <td>${item.getCat_color()}</td>
                <td>${item.getCat_character()}</td>
                <td>${item.getCat_position()}</td>
                <td>${item.getCat_count()}</td>
                <td><button style="color: chocolate">修改</button>
                    <button style="color: chocolate">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
</div>
</body>
</html>


