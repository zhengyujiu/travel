<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--需要写该属性为false后，才能使用el表达式--%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>用户-酒店</title>
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

    #cancelHotelChoose{
        position: absolute;
        left: 100px;
        top: 80px;
        font-size: 17px;
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
                <li class="active"><a href="#">订酒店</a></li>
                <li><a href="orderCanteenServlet">美食</a></li>
                <li><a href="suggestServlet">个性推荐</a></li><li><a href="produceOrderServlet">生成订单</a></li>
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
                    <li><a href="logOutServlet" style="position: relative;left: 505px">注册/登录</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>

<div id="cancelHotelChoose">
    <a href="cancelChooseOrderServlet?chooseHotel=-1">取消酒店选择?</a>
</div>

<%--根据景点是否被选择，调整酒店页面的布局：选择距离/搜索城市--%>
<div id="searchCity">
    <%-- 如果没有选择景点，则表示可以先选择酒店，因为城市还未确定，所以可以查询酒店所在的城市 --%>
    <%-- 表单提交的action，值为要访问的servlet的名字，或者/travel/arriveServlet   --%>
    <c:if test="${sessionScope.chooseAttraction==null}">
        <form class="bs-example bs-example-form" role="form" action="orderHotelServlet" method="get">
            <div class="row">
                <div class="col-lg-3">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="请输入想要前往的城市" name="QueryCity">
                        <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">Go!</button>
                    </span>
                    </div>
                </div>
            </div>
        </form>
    </c:if>
</div>

<div id="searchDistance">
<%-- 判断此时用户是否已经选择景点，如果选择了景点则显示选择距离的下拉列表，否则不显示，因为距离是根据所选景点来计算的 --%>
    <c:if test="${sessionScope.chooseAttraction!=null}">
        <div class="btn-group" id="distance">
            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">选择距离
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu">
                <li>
                    <a href="orderHotelServlet?ahDistance=200">200米内</a>
                </li>
                <li>
                    <a href="orderHotelServlet?ahDistance=500">500米内</a>
                </li>
                <li>
                    <a href="orderHotelServlet?ahDistance=1000">1km内</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="orderHotelServlet?ahDistance=2000">2km及以上</a>
                </li>
            </ul>
        </div>
    </c:if>
</div>

<div style="margin-top: 50px">
    <table class="table table-hover" id="show">
        <thead>
        <tr>
            <th>酒店名称</th>
            <th>图片</th>
            <th>地址</th>
            <th>邮箱</th>
            <th>电话</th>
            <th>城市</th>
            <th>收藏</th>
            <th>是否选择</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.hotelList}" var="hotel">
            <tr>
                <td>${hotel.hname}</td>
                <td><img src="statics/pagephone/hotels/${hotel.hpicture}" width="150px" height="150px"></td>
                <td>${hotel.haddress1}</td>
                <td>${hotel.hemail}</td>
                <td>${hotel.hphone}</td>
                <td>${hotel.hcity}</td>
                    <%-- 使用bootstrap字体图标 --%>
                <td><a href="addCollectServlet?hid=${hotel.hid}"><span class="glyphicon glyphicon-bookmark"></span>收藏</a>
                </td>
                <td><a href="chooseOrderServlet?chooseHotel=${hotel.hid}&hname=${hotel.hname}">选择</a></td>
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