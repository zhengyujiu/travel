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

    #search {
        position: relative;
        left: 500px;
        top: 7px;
    }

    #cancelArriveChoose {
        position: relative;
        top: 40px;
        left: 500px;
        font-size: 17px;
    }

</style>
<script type="text/javascript">
    $(function (){
        //如果得到插入结果的值为yes，则表示插入成功显示yes，否则显示插入失败
        if(${requestScope.insertResult=="yes"}){
            alert("评论成功!");
        }else if (${requestScope.insertResult=="no"}){
            alert("评论失败!");
        }
        //如果都不匹配，则说明其没有进行评论，则不显示提示信息
    });
    function userComment(o) {
        //将aid,aname从点击评论的button标签获取到，用于传入到增加评论的servlet中
        var aid = $(o).attr("aid");
        var aname = $(o).attr("aname");
        //向模态框中传值，将景点的名称传入到模态框的表单之中
        $('#attractionName').val(aname);
        //将景点的aid传入到模态框的隐藏域中，为了传入到userCommentServlet中
        $("#attractionID").attr("value", aid);
    };
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
                <%-- 注意a标签中使用servlet的名字进行页面的跳转 --%>
                <li><a href="homeServlet">首页</a></li>
                <li class="active"><a href="#">目的地</a></li>
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

<div id="search">
    <div id="cancelArriveChoose">
        <a href="cancelChooseOrderServlet?chooseAttraction=-1">取消目的地选择?</a>
    </div>
    <%-- 表单提交的action，值为要访问的servlet的名字，或者/travel/arriveServlet   --%>
    <form class="bs-example bs-example-form" role="form" action="arriveServlet" method="get" style="float: left">
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
</div>

<div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title" style="font-weight: bold">旅游城市大全</h3>
        </div>
        <div class="panel-body">
            please choose one
        </div>
        <table class="table" style="text-align: center;vertical-align: middle">
            <th colspan="4">旅游城市</th>
            <tr>
                <td><a href="arriveServlet?QueryCity=北京">北京</a></td>
                <td><a href="arriveServlet?QueryCity=上海">上海</a></td>
                <td><a href="arriveServlet?QueryCity=丽江">丽江</a></td>
                <td><a href="arriveServlet?QueryCity=西安">西安</a></td>
            </tr>
            <tr>
                <td><a href="arriveServlet?QueryCity=西双版纳">西双版纳</a></td>
                <td><a href="arriveServlet?QueryCity=昆明">昆明</a></td>
                <td><a href="arriveServlet?QueryCity=天津">天津</a></td>
                <td><a href="arriveServlet?QueryCity=武汉">武汉</a></td>
            </tr>
            <tr>
                <td><a href="arriveServlet?QueryCity=成都">成都</a></td>
                <td><a href="arriveServlet?QueryCity=九寨沟">九寨沟</a></td>
                <td><a href="都江堰">都江堰</a></td>
                <td><a href="arriveServlet?QueryCity=重庆">重庆</a></td>
            </tr>
            <tr>
                <td><a href="arriveServlet?QueryCity=张家界">张家界</a></td>
                <td><a href="arriveServlet?QueryCity=杭州">杭州</a></td>
                <td><a href="arriveServlet?QueryCity=定西">定西</a></td>
                <td><a href="arriveServlet?QueryCity=三亚">三亚</a></td>
            </tr>
        </table>
    </div>
</div>

<div style="margin-top: 50px">
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
            <th>评论</th>
            <th>收藏</th>
            <th>是否选择</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.attractionList}" var="attraction">
            <tr>
                <td>${attraction.aname}</td>
                <td><img src="statics/pagephone/attractions/${attraction.apicture}" width="150px" height="150px"></td>
                <td>${attraction.adescription}</td>
                <td>${attraction.aaddress}</td>
                <td>${attraction.atype}</td>
                <td>${attraction.ascore}分</td>
                <td>${attraction.acity}</td>
                <td>${attraction.aprice}元</td>
                    <%-- 点击按钮后，打开评论模态框，输入评论信息，提交后，写入数据库 --%>
                <td>
                        <%-- button按钮点击后，获取到button按钮的元素数据，将其传入到模态框中 --%>
                    <button onclick="userComment(this)" class="btn btn-primary" data-toggle="modal"
                            data-target="#addComment" aid="${attraction.aid}" aname="${attraction.aname}">
                        评论
                    </button>
                </td>
                <td><a href="addCollectionServlet?aid=${attraction.aid}"><span class="glyphicon glyphicon-bookmark"></span>收藏</a></td>
                </td>
                    <%-- 如果用户选择了某个景点，则将景点中的所有数据存放到session中，便于订单查询 --%>
                <td>
                    <a href="chooseOrderServlet?chooseAttraction=${attraction.aid}&aname=${attraction.aname}&aprice=${attraction.aprice}">选择</a>
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

<%--该模态框用于用户点击评论按钮后，输入评论信息，然后将评论信息写入数据库--%>
<div class="modal fade" id="addComment" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <%-- 该按钮用于关闭模态框 --%>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">用户评论景点信息</h4>
            </div>
            <div class="modal-body">
                <%-- 模态框的主体为待修改用户数据的表单 --%>
                <form class="form-horizontal" role="form" method="post" action="addCommentServlet">
                    <input type="hidden" id="attractionID" name="aid" value="">
                    <div class="form-group">
                        <%-- 评论模态框中的景点名称是用于展示的，所以其值不可更改! --%>
                        <label for="attractionName" class="col-sm-2 control-label">景点名称</label>
                        <div class="col-sm-6">
                            <input type="text" name="attractionName" class="form-control" id="attractionName" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ccontent" class="col-sm-2 control-label">评论内容</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="ccontent" id="ccontent"
                                   placeholder="请输入对该景点评论的内容">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uscore" class="col-sm-2 control-label">景点评分</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="uscore" id="uscore"
                                   placeholder="请输入对景点的评分">
                        </div>
                    </div>
                    <%--  该模态框的页脚本身应在主体的外部，但因为表单提交需要，将其放在内部! --%>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">提交更改</button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>