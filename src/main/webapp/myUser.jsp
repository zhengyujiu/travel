<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
    <title>个人中心-用户信息</title>
    <meta charset="utf-8"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
    #tablediv {
        position: relative;
        width: 900px;
        height: 600px;
        left: 200px;
        top: 100px;
        text-align: center;
        vertical-align: middle;
    }
    #tablediv table th, td, caption {
        font-size: 17px;
        text-align: center;
        vertical-align: middle;
    }

    #tablediv table caption {
        font-size: 20px;
        font-weight: bold;
    }

</style>
<body>

<div id="tablediv">
    <table class="table table-hover table-bordered" id="table">
        <caption>个人信息</caption>
        <thead>
        <tr>
            <th>姓名</th>
            <th>密码</th>
            <th>性别</th>
            <th>年龄</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>资金</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${user.uname}</td>
                <td>${user.upassword}</td>
                <td><c:if test="${empty user.usex}">null</c:if> <c:if test="${not empty user.usex}"></c:if> ${user.usex}</td>
                <td><c:if test="${empty user.uage}">null</c:if> <c:if test="${not empty user.uage}"></c:if> ${user.uage}</td>
                <td>${user.uphone}</td>
                <td>${user.uemail}</td>
                <td>${user.ufunds}</td>
            </tr>
        </tbody>
    </table>
    <a class="btn"  href="homeServlet" style="position: relative;left: 450px">返回主页</a>
</div>

</div>
</body>
</html>