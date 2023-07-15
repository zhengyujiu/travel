<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--需要写该属性为false后，才能使用el表达式--%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>用户-个性推荐</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
    .navbar {
        /*将导航栏的外边距设置为0*/
        margin-bottom: 0;
    }

    .navbar-default {
        background-color: #badce3;
    }

    /*从table标签到th,td设置垂直和水平对齐方式*/
    #show tbody td, th {
        vertical-align: middle;
        text-align: center;
    }

    /*搜索距离下拉列表的样式*/
    #searchDistance {
        position: relative;
        left: 650px;
        top: 60px;
    }

    /*搜索城市下拉列表的样式*/
    #searchCity {
        position: relative;
        left: 500px;
        top: 15px;
    }

    #distance {
        position: relative;
        top: -50px;
        left: 450px;
        font-size: 16px;
    }

    #cancelHotelChoose {
        position: absolute;
        left: 100px;
        top: 80px;
        font-size: 17px;
    }

    #cancelSuggestChoose {
        position: relative;
        left: 50px;
        top: 20px;
    }

</style>

<body>
<%-- 导航栏设置 --%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span> 旅游信息平台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <%-- 注意a标签中使用servlet的名字进行页面的跳转 --%>
                <li><a href="homeServlet">首页</a></li>
                <li><a href="arriveServlet">目的地</a></li>
                <li><a href="orderHotelServlet">订酒店</a></li>
                <li><a href="orderCanteenServlet">美食</a></li>
                <li class="active"><a href="#">个性推荐</a></li>
                <li><a href="produceOrderServlet">生成订单</a></li>
                <li class="dropdown" style="position: relative;left: 450px">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        个人中心
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> 我的信息</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><span class="glyphicon glyphicon-list-alt"></span> 我的评论</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><span class="glyphicon glyphicon-bookmark"></span> 我的收藏</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><span class="glyphicon glyphicon-briefcase"></span> 我的订单</a></li>
                    </ul>
                </li>
                <c:if test="${requestScope.IsLogin==1}">
                    <li><a href="logOutServlet" style="position: relative;left: 455px">退出登录</a></li>
                </c:if>
                <c:if test="${requestScope.IsLogin==0}">
                    <li><a href="#" style="position: relative;left: 505px">注册/登录</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<div id="cancelSuggestChoose">
    <a href="cancelSuggestOrderServlet">取消推荐选择?</a>
</div>

<div style="margin-top: 50px">
    <table class="table table-hover" id="show">
        <thead>
        <tr>
            <th>酒店名称</th>
            <th>酒店图片</th>
            <th>餐厅名称</th>
            <th>餐厅图片</th>
            <th>景点名称</th>
            <th>景点图片</th>
            <th>是否选择</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.mapList}" var="map">
            <tr>
                <td>${map.get("aname")}</td>
                <td><img src="statics/pagephone/attractions/${map.get("apicture")}" width="150px" height="150px"/></td>
                <td>${map.get("hname")}</td>
                <td><img src="statics/pagephone/hotels/${map.get("hpicture")}" width="150px" height="150px"/></td>
                <td>${map.get("rcname")}</td>
                <td><img src="statics/pagephone/canteen/${map.get("rcpicture")}" width="150px" height="150px"/></td>
                <td>
                    <a href="suggestOrderServlet?chooseAttraction=${map.get("aid")}&chooseHotel=${map.get("hid")}&chooseCanteen=${map.get("rcid")}&aname=${map.get("aname")}&aprice=${map.get("aprice")}&hname=${map.get("hname")}&rcname=${map.get("rcname")}">选择</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<%--使用bootstrap做主页面页脚--%>
<div class="container-fluid" style="dfpadding-top: 40px;margin-bottom: 0px;margin-top: 200px">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron">
                <div class="container">
                    <center>
                        <p>Copyright© 2023 All Rights Reserved. </p>
                        <p>宁夏大学信息工程学院--Niit旅游信息平台期末项目实训</p>
                        地址：宁夏大学怀远校区 &nbsp;&nbsp;&nbsp; 电话:18840455162
                        <%--创作人注释--%>
                        <p></p>
                        创作人：王添-郑渝久-胡晓梅
                    </center>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>