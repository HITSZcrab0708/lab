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
    <title>喂食界面</title>
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
            width: 100%;
            padding-top:25px;
            padding-left: 25%;
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
        <input type="text" id="input_catid" style="font-size: 20px; height: 26px;width: 100px" placeholder="输入猫id">
        <input type="text" id="input_username" style="font-size: 20px; height: 26px;width: 100px" placeholder="输入用户名">
        <input type="text" id="input_position" style="font-size: 20px; height: 26px;width: 100px" placeholder="输入地址">
        <input type="text" id="input_time" style="font-size: 20px; height: 26px;width: 100px" placeholder="输入时间">
        <input type="text" id="input_food" style="font-size: 20px; height: 26px;width: 100px" placeholder="输入食物种类">&nbsp;&nbsp;
        <button  id="btn2"  style="font-size: 18px; height: 28px;">登记</button>
        <button  id="btn3"  style="font-size: 18px; height: 28px;">图鉴</button>
        <button  id="btn4"  style="font-size: 18px; height: 28px;">打卡记录</button>
    </div>
    <script>
        let btn002=document.getElementById("btn2");
        btn002.onclick=function ()
        {
            let catid_str=document.getElementById("input_catid").value;
            if(catid_str=="")
            {
                alert("猫id为空");
                return;
            }
            let username_str=document.getElementById("input_username").value;
            if(username_str=="")
            {
                alert("用户名为空");
                return;
            }
            let position_str=document.getElementById("input_position").value;
            if(position_str=="")
            {
                alert("地址为空");
                return;
            }
            let time_str=document.getElementById("input_time").value;
            if(time_str=="")
            {
                alert("时间为空");
                return;
            }
            let food_str=document.getElementById("input_food").value;
            if(food_str=="")
            {
                alert("食物种类为空");
                return;
            }
            //TODO
            //建立新的servlet并调用，类似registerservlet用于添加信息
            window.location.href="checkin?cat_id="+catid_str+"&username="+username_str+"&cat_position="+position_str+"&record_time="+time_str+"&feed_food="+food_str;
            window.location.href="feed?"
            window.location.reload();
        }
        let btn003=document.getElementById("btn3");
        btn003.onclick=function ()
        {
            window.location.href="main?";
        }
        let btn004=document.getElementById("btn4");
        btn004.onclick=function ()
        {
            window.location.href="record?";
        }
    </script>
</div>

<div>
    <table id="table" style="height: 30px;width: 700px;border: black 1px solid;border-collapse:collapse;">
        <tr >
            <td>id</td>
            <td>猫id</td>
            <td>用户名</td>
            <td>喂食地址</td>
            <td>记录时间</td>
            <td>食物种类</td>
            <td>更新时间</td>
        </tr>
        <c:forEach items="${arr}" var="item">
            <tr>
                <td>${item.getRecord_id()}</td>
                <td>${item.getCat_id()}</td>
                <td>${item.getUsername()}</td>
                <td>${item.getCat_position()}</td>
                <td>${item.getRecord_time()}</td>
                <td>${item.getFeed_food()}</td>
                <td>${item.getLast_update()}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
</div>
</body>
</html>


