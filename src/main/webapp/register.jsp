<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Anchor Bootstrap 4.1.3 UI Kit by WowThemesNet</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport'/>
    <link href="https://fonts.googleapis.com/css?family=Nunito:300,300i,400,600,800" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link href="/statics/css/main.css" rel="stylesheet"/>
    <link href="/statics/css/aos.css" rel="stylesheet"/>
    <script src="/statics/jquery-3.6.1.js" type="text/javascript"></script>
    <script src="/statics/js/popper.min.js" type="text/javascript"></script>
    <script src="/statics/bootstrap-5.3.0/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="/statics/js/functions.js" type="text/javascript"></script>
    <script src="/statics/js/aos.js" type="text/javascript"></script>
    <script>
        $(function (){

            $('#formSubmit').bind("submit",function (){
                if ($('#upassword').val()==$('#checkPassword').val()){
                    // alert(1);
                    return true;
                }
                else {
                    // $("#passwordConfirm").attr("visibility","visible");
                    document.getElementById("passwordConfirm").innerHTML="两次输入的密码不一样";
                    // alert(2);
                    return false;
                }
                return false;
            });
            $('#checkPassword').bind("keyup",function (){
                if ($('#upassword').val()==$('#checkPassword').val()){
                    // alert(3);

                    document.getElementById("passwordConfirm").innerHTML=null;
                }
            })
        })
    </script>

</head>

<body>
<nav class="topnav navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container-fluid">
        <div class="navbar-collapse collapse" id="navbarColor02" style="">
            <ul class="navbar-nav mr-auto d-flex align-items-center">
                <li class="nav-item">
                    <a class="nav-link" href="/index.jsp">首页</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login.jsp">登录</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="d-md-flex h-md-100 align-items-center">
    <div class="col-md-6 p-0 bg-indigo h-md-100">
        <div class="text-white d-md-flex align-items-center h-100 p-5 text-center justify-content-center">
            <div class="logoarea pt-5 pb-5">
                <p>
                    <i class="fa fa-anchor fa-3x"></i>
                </p>
                <h1 class="mb-0 -mt3 display-5">旅游信息平台</h1>
            </div>
        </div>
    </div>
    <div class="col-md-6 p-0 bg-white h-md-100 loginarea">
        <div class="d-md-flex align-items-center h-md-100 p-5 justify-content-center">
            <form class="border rounded p-5" id="formSubmit" action="/registerServlet">
                <h3 class="mb-4 text-center">注册</h3>
                <label class="form-control-label" for="uname">用户名</label>
                <div class="form-group">
                    <input type="用户名" class="form-control" id="uname" name="uname" required placeholder="请输入用户名">
                </div>

                    <label class="form-control-label" for="upassword">密码</label>
                    <div class="form-group">
                        <input type="password" class="form-control" id="upassword" name="upassword" required>
                    </div>
                    <label class="form-control-label" for="checkPassword">确认密码</label>
                <small class="d-block mt-0 text-center" id="passwordConfirm" style="color: red;"></small>
                    <div class="form-group">
                        <input type="password" class="form-control" id="checkPassword" required>
                    </div>
                <label class="form-control-label" for="uphone">手机号</label>
                <div class="form-group">
                    <input type="text" class="form-control" name="uphone" id="uphone" required>
                </div>
                <label class="form-control-label" for="uemail">电子邮箱</label>
                <div class="form-group">
                    <input type="email" class="form-control" name="uemail" id="uemail" required>
                </div>
                <button type="submit" class="btn btn-success btn-round btn-block shadow-sm">注册</button>
                <small class="d-block mt-0 text-center" id="checkMsg" style="visibility: visible;color: red">${registerMsg}</small>
                <small class="d-block mt-1 text-center">已有账号?<a  href="login.jsp">去登录</a></small>
            </form>
        </div>
    </div>
</div>
</body>
</html>