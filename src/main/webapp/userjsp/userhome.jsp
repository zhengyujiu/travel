<%--项目结构设置中，设置artifacts为tomcat的webapp目录即可访问到
设置tomcat配置为更新类和资源文件
IDEA中使用ctrl+alt+l 来格式化代码
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--需要写该属性为false后，才能使用el表达式--%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>用户-主页面</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
    #myCarousel {
        width: 100%;
        height: 400px;
    }

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

    body {
        background-color: #ffffff;
    }

</style>
<script>
        $(function(){
            if (!${empty msg}){
                alert("${msg}");
                <% request.setAttribute("msg",null);%>
            }
            <%--if (!${empty collectionMsg}){--%>
            <%--    alert("${collectionMsg}");--%>
            <%--    <% request.setAttribute("msg",null);%>--%>
            <%--}--%>
        })
</script>
<body>
<%-- 导航栏设置 --%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-home"></span> 旅游信息平台</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="arriveServlet">目的地</a></li>
                <li><a href="orderHotelServlet">订酒店</a></li>
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
<%-- 轮播图页面展示 使用bootstrap插件 data-ride表示从页面开始即播放 data-interval表示时间间隔--%>
<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
        <li data-target="#myCarousel" data-slide-to="5"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="statics/pagephone/Carousel/景点5.jpg" alt="..." style="width:100%;height: 400px;">
        </div>
        <div class="item">
            <img src="statics/pagephone/Carousel/景点6.jpg" alt="..." style="width:100%;height: 400px;">
        </div>
        <div class="item">
            <img src="statics/pagephone/Carousel/景点4.jpg" alt="..." style="width:100%;height: 400px;">
        </div>
        <div class="item">
            <img src="statics/pagephone/Carousel/景点3.jpg" alt="..." style="width:100%;height: 400px;">
        </div>
        <div class="item">
            <img src="statics/pagephone/Carousel/景点1.jpg" alt="..." style="width:100%;height: 400px;">
        </div>
        <div class="item">
            <img src="statics/pagephone/Carousel/景点2.jpg" alt="..." style="width:100%;height: 400px;">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel"
       data-slide="prev"><span _ngcontent-c3="" aria-hidden="true"
                               class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="carousel-control right" href="#myCarousel"
       data-slide="next"><span _ngcontent-c3="" aria-hidden="true"
                               class="glyphicon glyphicon-chevron-right"></span></a>
    <%--    &rsaquo; 变成小箭头在上方存在--%>
</div>

<div style="margin-top: 50px">
    <p style="text-align: center;font-size: 30px;margin-bottom: 50px">特色旅游景点展示</p>
    <table class="table table-hover" id="show">
        <thead>
        <tr>
            <th>景点名称</th>
            <th>图片</th>
            <th>描述</th>
            <th>地址</th>
            <th>类型</th>
            <th>评分</th>
            <th>城市</th>
            <th>价格</th>
            <th>收藏</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.attractionList}" var="attraction">
            <tr>
                <td>${attraction.aname}</td>
                <td><img src="/statics/pagephone/attractions/${attraction.apicture}" width="150px" height="150px"></td>
                <td>${attraction.adescription}</td>
                <td>${attraction.aaddress}</td>
                <td>${attraction.atype}</td>
                <td>${attraction.ascore}分</td>
                <td>${attraction.acity}</td>
                <td>${attraction.aprice}元</td>
                <td><a href="addCollectionServlet?aid=${attraction.aid}"><span class="glyphicon glyphicon-bookmark"></span>收藏</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div style="margin-top: 50px">
    <p style="text-align: center;font-size: 30px;margin-bottom: 50px">目的地景点分类展示</p>
    <c:forEach items="${requestScope.attractionsByType}" var="map">
        <div class="list-group">
            <a href="#" class="list-group-item active">
                <h4 class="list-group-item-heading">
                        ${map.key}
                </h4>
            </a>
            <table class="table table-hover" id="show">
                <thead>
                <tr>
                    <th>景点名称</th>
                    <th>图片</th>
                    <th>描述</th>
                    <th>地址</th>
                    <th>类型</th>
                    <th>得分</th>
                    <th>城市</th>
                    <th>价格</th>
                    <th>收藏</th>
                </tr>
                </thead>
                <tbody>
                <a href="#" class="list-group-item" style="">
                    <c:forEach items="${map.value}" var="value">
                        <tr>
                            <td>${value.aname}</td>
                            <td><img src="statics/pagephone/attractions/${value.apicture}" width="150px" height="150px">
                            </td>
                            <td>${value.adescription}</td>
                            <td>${value.aaddress}</td>
                            <td>${value.atype}</td>
                            <td>${value.ascore}分</td>
                            <td>${value.acity}</td>
                            <td>${value.aprice}元</td>
                            <td><a href="addCollectServlet?aid=${attraction.aid}"><span class="glyphicon glyphicon-bookmark"></span>收藏</a></td>
                        </tr>
                    </c:forEach>
                </a>
                </tbody>
            </table>
        </div>
    </c:forEach>
</div>

<%--使用bootstrap做主页面页脚--%>
<div class="container-fluid" style="padding-top: 40px;margin-bottom: 0px">
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