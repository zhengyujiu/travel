<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Dashboard - Tabler - Premium and Open Source dashboard template with responsive and high quality UI.</title>
    <link href="/statics/css/tabler.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="statics/css/all.min.css">
    <link rel="stylesheet" href="statics/css/quick-website.css" id="stylesheet">
    <script src="/statics/bootstrap-5.3.0/js/bootstrap.bundle.js"></script>
    <script src="/statics/js/svg-injector.min.js"></script>
    <script src="/statics/js/feather.min.js"></script>
    <script src="/statics/js/quick-website.js"></script>
    <script>
        $(function(){
            $('#searchBtn').bind()
        })
    </script>
    <style>
        #allOrdersBtn{
           position: relative;
            left: 175px;
        }
    </style>

</head>
<body  class=" layout-boxed">
<div class="page">
    <div class="page-wrapper">
        <div class="page-body">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h2 class=" col-9">用户订单</h2>
                        <form action="/searchOrderByAname">
                            <div class="input-group">
                                <input type="text"  class="form-control"  name="searchName"
                                       placeholder="输入用户名进行搜索" required>
                                <div class="input-group-append">
                                    <button class="input-group-text" id="searchBtn" type="submit"><i data-feather="search"></i></button>
                                </div>
                            </div>
                        </form>


                    </div>
                    <div class="table-responsive">
                        <table class="table card-table table-vcenter text-nowrap datatable">
                            <tr>
                                <td>订单编号</td>
                                <td >景点名称</td>
                                <td>酒店名称</td>
                                <td>酒店地址</td>
                                <td>房间类型</td>
                                <td>房间号</td>
                                <td>餐厅名称</td>
                                <td>餐厅地址</td>
                                <td>起始日期</td>
                                <td>截止日期</td>
                                <td>总价格</td>
                            </tr>
                            <c:forEach items="${pageBean.list}" var="order" >
                                <tr>
                                    <td>${order.oid }</td>
                                    <td>${order.attraction.aname}</td>
                                    <td><c:if test="${not empty order.hotel.hname}">${order.hotel.hname}</c:if><c:if test="${empty order.hotel.hname}">未预定酒店</c:if></td>
                                    <td><c:if test="${not empty order.hotel.haddress1}">${order.hotel.haddress1}</c:if><c:if test="${empty order.hotel.haddress1}">未预定酒店</c:if></td>
                                    <td><c:if test="${not empty order.room.rtype}">${order.room.rtype}</c:if><c:if test="${empty order.room.rtype}">未预定房间</c:if></td>
                                    <td><c:if test="${not empty order.rid}">${order.rid}</c:if><c:if test="${empty order.rid}">未预定房间</c:if></td>
                                    <td><c:if test="${not emptyorder.canteen.rcname}">${order.canteen.rcname}</c:if><c:if test="${empty order.canteen.rcname}">未预定房间</c:if></td>
                                    <td><c:if test="${not empty order.canteen.rcaddress}">${order.canteen.rcaddress}</c:if><c:if test="${empty order.canteen.rcaddress}">未预定房间</c:if></td>
                                    <td>${order.ostartTime}</td>
                                    <td>${order.oendTime}</td>
                                    <td >${order.ototalPrice}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>

                    <%--分页用的--%>
                    <div class="card-footer d-flex align-items-center">
                        <ul class="pagination m-0 ms-auto">
                            <c:set var="pageCount" value="${pageBean.totalCount%pageBean.pageSize==0?
                            pageBean.totalCount/pageBean.pageSize:(pageBean.totalCount/pageBean.pageSize+1)}"  scope="page"></c:set>
                            <c:if test="${pageBean.currentPage>1}">
                                <li class="page-item"><a class="page-link" href="/oneUserOrderList?currentPage=${pageBean.currentPage-1}&pageSize=5&searchName=${searchName}">上一页</a></li>
                            </c:if>
                            <li class="page-item">当前第${pageBean.currentPage}页</li>
                            <c:if test="${pageBean.currentPage<=pageCount-1}">
                                <li class="page-item"><a class="page-link" href="oneUserOrderList?currentPage=${pageBean.currentPage+1}&pageSize=5&searchName=${searchName}">下一页</a></li>
                            </c:if>
                        </ul>
                        <form action="oneUserOrderList?pageSize=5&searchName=${searchName}">
                            <input type="number" min="1" name="currentPage" required >
                            <button type="submit" CLASS="btn">跳转</button>
                        </form>

                        <a class="btn" id="allOrdersBtn" href="oneUserOrderList" >全部订单</a>
                        <a class="btn"  href="homeServlet" style="position: relative;left: 450px">返回主页</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    feather.replace({
        'width': '1em',
        'height': '1em'
    })
</script>
</body>
</html>



