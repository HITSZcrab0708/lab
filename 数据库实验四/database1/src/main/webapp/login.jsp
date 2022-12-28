<%--
  Created by IntelliJ IDEA.
  User: crab0708
  Date: 2022/12/24
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <style>
        #login-box {
            width: 30%;
            height: auto;
            margin: 0 auto;
            margin-top: 13%;
            text-align: center;
            background: #00000060;
            padding: 20px 50px;
        }

        #login-box h1 {
            color: #fff;
        }

        #login-box .form .item {
            margin-top: 15px;
        }

        #login-box .form .item i {
            font-size: 18px;
            color: #fff;
        }

        #login-box .form .item input {
            width: 180px;
            font-size: 18px;
            border: 0;
            border-bottom: 2px solid #fff;
            padding: 5px 10px;
            background: #ffffff00;
            color: #fff;
        }

        #login-box button {
            margin-top: 20px;
            width: 190px;
            height: 30px;
            font-size: 20px;
            font-weight: 700;
            color: #fff;
            background-image: linear-gradient(to right, #74ebd5 0%, #9face6 100%);
            border: 0;
            border-radius: 15px;
        }
    </style>
</head>
<body>
<div id="login-box">
        <h1>Login</h1>
        <div class="form">
            <img src="1.png"><br>
            <div class="item">
                <i class="fa fa-github-alt" style="font-size:24px"></i>
                <input type="text" id="u_id" placeholder="用户名">
            </div>
            <div class="item">
                <i class="fa fa-search" style="font-size:24px"></i>
                <input type="text" id="u_pwd" placeholder="密码">
            </div>
        </div>
        <button id="btn01">登录</button><button id="btn02">注册</button><br>
        <span id="error" style="color: aqua">${error}</span>
        <script>
            let btn001=document.getElementById("btn01");
            btn001.onclick=function () {
                let id_str=document.getElementById("u_id").value;
                if(id_str=="")
                {
                    alert("用户名为空");
                    return;
                }
                let pwd_str=document.getElementById("u_pwd").value;
                if(pwd_str=="")
                {
                    alert("密码为空");
                    return;
                }
                //访问服务器
                window.location.href="login?u_id="+id_str+"&u_pwd="+pwd_str;
            }
            let btn002=document.getElementById("btn02");
            btn002.onclick=function (){
                let id_str=document.getElementById("u_id").value;
                if(id_str=="")
                {
                    alert("用户名为空");
                    return;
                }
                let pwd_str=document.getElementById("u_pwd").value;
                if(pwd_str=="")
                {
                    alert("密码为空");
                    return;
                }
                window.location.href="register?u_id="+id_str+"&u_pwd="+pwd_str;
                window.location.href="";
                alert("注册成功！");
            }
        </script>
</div>
</body>
</html>
