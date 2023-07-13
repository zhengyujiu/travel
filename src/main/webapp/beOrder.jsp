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
    <script src="/statics/jquery-3.6.1.js"></script>
    <script>
        $(function(){
            if (!${empty deleteMsg}){
                alert("删除成功");
            };

            $('#deleteBtn').bind("click",function (){
                const r=confirm("确认删除吗?");
                if (r){
                    return true;
                }else {
                    return false;
                }
            });



            $('#changeBtn').bind("click",function (){
                $("#").attr("display")
            });

        })
    </script>
    <style>
        #allOrdersBtn{
            position: relative;
            left: 175px;
        }
        #addOrderIframe{
            display: none;
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
                        <form action="/searchOrderByUname">
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
                            <tr >
                                <td style="padding: 8px;margin-left: 5px">订单编号</td>
                                <td style="padding: 8px;margin-left: 5px">用户id</td>
                                <td style="padding: 8px;margin-left: 5px">用户名</td>
                                <td style="padding: 8px;margin-left: 5px">用户手机</td>
                                <td style="padding: 8px;margin-left: 5px">酒店名称</td>
                                <td style="padding: 8px;margin-left: 5px">房间号</td>
                                <td style="padding: 8px;margin-left: 5px">房间类型</td>
                                <td style="padding: 8px;margin-left: 5px">餐厅名称</td>
                                <td style="padding: 8px;margin-left: 5px">起始日期</td>
                                <td style="padding: 8px;margin-left: 5px">截止日期</td>
                                <td style="padding: 8px;margin-left: 5px">总价格</td>
                                <td style="padding: 8px;margin-left: 5px">操作</td>
                            </tr>
                            <c:forEach items="${pageBean.list}" var="order" >
                                <tr>
                                    <td style="padding: 8px;margin-left: 5px" >${order.oid }</td>
                                    <td style="padding: 8px;margin-left: 5px">${order.uid}</td>
                                    <td style="padding: 8px;margin-left: 5px">${order.user.uname}</td>
                                    <td style="padding: 8px;margin-left: 5px">${order.user.uphone}</td>
                                    <td style="padding: 8px;margin-left: 5px"><c:if test="${not empty order.hotel.hname}">${order.hotel.hname}</c:if><c:if test="${empty order.hotel.hname}">未预定酒店</c:if></td>
                                    <td style="padding: 8px;margin-left: 5px"><c:if test="${not empty order.rid}">${order.rid}</c:if><c:if test="${empty order.rid}">未预定房间</c:if></td>
                                    <td style="padding: 8px;margin-left: 5px"><c:if test="${not empty order.room.rtype}">${order.room.rtype}</c:if><c:if test="${empty order.room.rtype}">未预定房间</c:if></td>
                                    <td style="padding: 8px;margin-left: 5px"><c:if test="${not emptyorder.canteen.rcname}">${order.canteen.rcname}</c:if><c:if test="${empty order.canteen.rcname}">未预定餐厅</c:if></td>
                                    <td style="padding: 8px;margin-left: 5px">${order.ostartTime}</td>
                                    <td style="padding: 8px;margin-left: 5px">${order.oendTime}</td>
                                    <td style="padding: 8px;margin-left: 5px" >${order.ototalPrice}</td>
                                    <td style="padding: 8px;margin-left: 5px">
                                        <a class="btn-sm btn-primary" id="changeBtn" href="changeOrderById">修改</a>
                                        <a class="btn-sm btn-danger"  id="deleteBtn" href="deleteOrderByOid?deleteOid=${order.oid}&searchName=${searchName}">删除</a>
                                    </td>
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
                                <li class="page-item"><a class="page-link" href="/queryOrderByPage?currentPage=${pageBean.currentPage-1}&pageSize=5&searchName=${searchName}">上一页</a></li>
                            </c:if>
                            <li class="page-item">当前第${pageBean.currentPage}页</li>
                            <c:if test="${pageBean.currentPage<=pageCount-1}">
                                <li class="page-item"><a class="page-link" href="queryOrderByPage?currentPage=${pageBean.currentPage+1}&pageSize=5&searchName=${searchName}">下一页</a></li>
                            </c:if>
                        </ul>
                        <form action="queryOrderByPage?pageSize=5&searchName=${searchName}">
                            <input type="number" min="1" name="currentPage" required >
                            <button type="submit" CLASS="btn">跳转</button>
                        </form>
                        <a class="btn" id="allOrdersBtn" href="queryOrderByPage" >全部订单</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%--这个是点完修改订单应该弹出来的页面--%>
    <div class="row g-5  d-flex justify-content-center align-items-center" >
        <div class="col-md-7 col-lg-8">
            <form class="needs-validation" action="/insertOrder" method="get">
                <div class="row g-3">
                    <div class="col-sm-3">
                        <label for="uid" class="form-label">用户ID</label>
                        <input type="text" class="form-control" id="uid" name="uid" value="${user.uid}" readonly="readonly">
                    </div>

                    <div class="col-sm-3">
                        <label for="uname" class="form-label">用户名</label>
                        <input type="text" class="form-control" id="uname" name="uname" value="${user.uname}" >
                    </div>

                    <div class="col-3">
                        <label for="aname" class="form-label">景点名称</label>
                        <input type="text" class="form-control" name="aname" id="aname" readonly="readonly" value="${aname}">
                    </div>
                    <div class="col-3">
                        <label for="aprice" class="form-label">景点单价/日</label>
                        <input type="text" class="form-control" name="aprice" id="aprice" readonly="readonly" value="${aprice}">
                    </div>
                    <div class="col-3">
                        <label for="hname" class="form-label" >酒店名称</label>
                        <input type="text" class="form-control" id="hname" name="hname"  readonly="readonly" value="${hname}" placeholder="空">
                    </div>
                    <div class="col-3">
                        <label for="rid" class="form-label">房间号</label>
                        <input type="text" class="form-control" id="rid" name="rid"  readonly="readonly" value="${rid}" placeholder="空">
                    </div>
                    <div class="col-3">
                        <label for="rtype" class="form-label">房间类型</label>
                        <input type="text" class="form-control" id="rtype" name="rtype"  readonly="readonly" value="${rid}" placeholder="空">
                    </div>
                    <div class="col-3">
                        <label for="rprice" class="form-label">房间单价/日</label>
                        <input type="text" class="form-control" id="rprice" name="rprice"  readonly="readonly" value="${rprice}" placeholder="空">
                    </div>
                    <div class="col-4">
                        <label for="rcname" class="form-label">餐厅名称</label>
                        <input type="text" class="form-control" id="rcname" name="rcname"  readonly="readonly" value="${rcname}" placeholder="空">
                    </div>
                    <div class="col-4 ">
                        <label for="datetimepicker1" class="form-label">起始日期</label>
                        <input class="form-control" type="text"  id="datetimepicker1" name="ostartTime" >
                    </div>
                    <div class="col-4 ">
                        <label for="datetimepicker2" class="form-label">截止日期</label>
                        <input class="form-control" type="text"  id="datetimepicker2" name="oendTime" >
                    </div>
                    <small style="color: red" id="dateErrorInfo" class="d-flex justify-content-center align-items-center"></small>
                    <div class="col-12">
                        <label for="ototalPrice" class="form-label">总费用</label>
                        <input type="text" class="form-control" name="ototalPrice" id="ototalPrice" readonly="readonly">
                    </div>
                    <div class="my-4"></div>
                    <button class="w-100 btn btn-primary btn-lg" type="submit" id="confirmButton" disabled>确认支付</button>
                    <a href="index.jsp " ><button class="w-100 btn btn-danger btn-lg" type="button" id="cancelButton" >取消支付</button></a>
                </div>
            </form>
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



