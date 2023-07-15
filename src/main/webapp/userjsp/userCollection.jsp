<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
    <title>个人中心-我的收藏</title>
    <meta charset="utf-8"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="/statics/css/tabler.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="statics/css/all.min.css">
    <link rel="stylesheet" href="statics/css/quick-website.css" id="stylesheet">
    <script src="/statics/bootstrap-5.3.0/js/bootstrap.bundle.js"></script>
    <script src="/statics/js/svg-injector.min.js"></script>
    <script src="/statics/js/feather.min.js"></script>
    <script src="/statics/js/quick-website.js"></script>
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

    /*body{*/
    /*    background-color: #9eeaf9;*/
    /*}*/

</style>
<script type="text/javascript">
    $(function () {
        $('#cancelBtn').bind("click",function (){
            const r=confirm("确认取消收藏吗?");
            if (r){
                return true;
            }else {
                return false;
            }
        });
    });
</script>
<body>

<div id="tablediv">
    <table class="table table-hover table-bordered" id="table">
        <caption>我的收藏</caption>
        <thead>
        <tr>
            <th>收藏序号</th>
            <th>景点名称</th>
            <th>酒店名称</th>
            <th>餐厅名称</th>
            <th>收藏时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageBean.list}" var="collection" >
            <tr>
                <td>${collection.clid}</td>
                <td><c:if test="${empty collection.attraction.aname}">未收藏</c:if> <c:if test="${not empty collection.attraction.aname}">${collection.attraction.aname}</c:if></td>
                <td><c:if test="${empty collection.hotel.hname}">未收藏</c:if> <c:if test="${not empty collection.hotel.hname}">${collection.hotel.hname}</c:if></td>
                <td><c:if test="${empty collection.canteen.rcname}">未收藏</c:if> <c:if test="${not empty collection.canteen.rcname}">${collection.canteen.rcname}</c:if></td>
                <td><c:if test="${empty collection.cltime}">未收藏</c:if> <c:if test="${not empty collection.cltime}">${collection.cltime}</c:if></td>
                <td>
                    <a href="deleteCollection?clid=${collection.clid}" id="cancelBtn">取消收藏</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="card-footer d-flex align-items-center">
        <ul class="pagination m-0 ms-auto">
            <c:set var="pageCount" value="${pageBean.totalCount%pageBean.pageSize==0?
                            pageBean.totalCount/pageBean.pageSize:(pageBean.totalCount/pageBean.pageSize+1)}"  scope="page"></c:set>
            <c:if test="${pageBean.currentPage>1}">
                <li class="page-item"><a class="page-link" href="/oneUserCollectionList?currentPage=${pageBean.currentPage-1}&pageSize=5&searchName=${searchName}">上一页</a></li>
            </c:if>
            <li class="page-item">当前第${pageBean.currentPage}页</li>
            <c:if test="${pageBean.currentPage<=pageCount-1}">
                <li class="page-item"><a class="page-link" href="oneUserCollectionList?currentPage=${pageBean.currentPage+1}&pageSize=5&searchName=${searchName}">下一页</a></li>
            </c:if>
        </ul>
        <form action="oneUserCollectionList?pageSize=5&searchName=${searchName}">
            <input type="number" min="1" name="currentPage" required >
            <button type="submit" CLASS="btn">跳转</button>
        </form>

        <a class="btn" id="allOrdersBtn" href="oneUserCollectionList" >全部订单</a>
        <a class="btn"  href="homeServlet" style="position: relative;left: 300px">返回主页</a>

    </div>
</div>

</div>
</body>
</html>