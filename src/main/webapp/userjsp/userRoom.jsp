<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--需要写该属性为false后，才能使用el表达式--%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>用户-目的地</title>
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

    #hotel {
        position: relative;
        left: 50px;
        margin-top: 20px;
    }

    #search {
        position: relative;
        left: 450px;
        top: -170px;
    }

    #returnHotel {
        position: relative;
        top: -270px;
        left: 1120px;
    }

    #cancelRoomChoose {
        position: relative;
        left: 100px;
        top: -120px;
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
                <li><a href="suggestServlet">个性推荐</a></li>
                <li><a href="produceOrderServlet">生成订单</a></li>
                <li class="dropdown" style="position: relative;left: 450px">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        个人中心
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="myUser.jsp"><span class="glyphicon glyphicon-user"></span> 我的信息</a></li>
                        <li class="divider"></li>
                        <li><a href="myCommentServlet"><span class="glyphicon glyphicon-list-alt"></span> 我的评论</a></li>
                        <li class="divider"></li>
                        <li><a href="oneUserCollectionList"><span class="glyphicon glyphicon-bookmark"></span> 我的收藏</a></li>
                        <li class="divider"></li>
                        <li><a href="oneUserOrderList"><span class="glyphicon glyphicon-briefcase"></span> 我的订单</a></li>

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

<%--将所属酒店的信息展示在预定酒店房间的页面当中--%>
<div id="hotel">
    <p style="font-size: 20px;font-weight: bold;position:relative;top: 70px">${requestScope.hotel.hname}酒店</p>
    <p style="position:relative;left: 120px;top: -30px"><img
            src="statics/pagephone/hotels/${requestScope.hotel.hpicture}" width="150px" height="150px"></p>
</div>

<div id="search">
    <form action="orderRoomServlet" method="get" style="width: 700px;position:relative;left: -50px">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">酒店房间条件查询</h3>
            </div>
            <div class="panel-body">
                <div style="display:inline-block;">
                    <div style="float:left;padding:6px;">
                        <span>房间类型</span>
                    </div>
                    <div style="float:left;">
                        <input type="text" name="QueryRoomType" class="form-control" style="width:200px;"
                               placeholder="请输入所需酒店房间类型"/>
                    </div>
                    <div style="float:left;padding:6px;">
                        <span>房间价格</span>
                    </div>
                    <div style="float:left;">
                        <select id="gender" class="form-control" style="width:200px;" name="QueryRoomPrice">
                            <option selected="selected" disabled="disabled" style='display: none'></option>
                            <option value="80">80元</option>
                            <option value="150">150元</option>
                            <option value="300">300元</option>
                            <option value="500">500元</option>
                            <option value="1000">1000元</option>
                        </select>
                    </div>
                    <div style="float:left;margin-left:20px;">
                        <button id="query" class="btn btn-primary">查询</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

<%--因为在推荐中选择订单，一旦选择了某个酒店后，就不允许重新修改酒店，而在自主选择订单中，酒店是可以重新选择的。所以这里需要做逻辑的判断，看是通过什么方式来选择房间--%>
<c:if test="${requestScope.suggestOrder!=1}">
    <div id="returnHotel">
        <a href="orderHotelServlet">重新预定酒店?</a>
    </div>
</c:if>

<div id="cancelRoomChoose">
    <a href="cancelChooseOrderServlet?chooseRoom=-1">取消房间选择?</a>
</div>

<div style="position: relative;top: -80px">
    <table class="table table-hover" style="text-align: center;vertical-align: middle">
        <thead>
        <tr>
            <th>房间号</th>
            <th>房间类型</th>
            <th>房间价格</th>
            <th>是否选择</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.roomList}" var="room">
            <tr>
                <td>${room.rid}</td>
                <td>${room.rtype}</td>
                <td>${room.rprice}</td>
                    <%-- 如果是自主选择房间，选择房间后则应在chooseOrderServlet记录，然后跳转到餐厅servlet中来选择餐厅               --%>
                <c:if test="${requestScope.suggestOrder!=1}">
                    <td><a href="chooseOrderServlet?chooseRoom=${room.rid}&rtype=${room.rtype}&rprice=${room.rprice}">选择</a></td>
                </c:if>
                    <%-- 如果是推荐选择房间，则选择房间后,应到suggestOrderServlet中写入所选房间，然后跳转到个性推荐页面，进行下一步操作 --%>
                <c:if test="${requestScope.suggestOrder==1}">
                    <td><a href="suggestOrderServlet?chooseRoom=${room.rid}&rtype=${room.rtype}&rprice=${room.rprice}">选择</a></td>
                </c:if>
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