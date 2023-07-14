<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台订单管理</title>
    <link href="/statics/css/tabler.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="statics/css/all.min.css">
    <link rel="stylesheet" href="statics/css/quick-website.css" id="stylesheet">
    <script src="/statics/bootstrap-5.3.0/js/bootstrap.bundle.js"></script>
    <script src="/statics/js/svg-injector.min.js"></script>
    <script src="/statics/js/feather.min.js"></script>
    <script src="/statics/jquery-3.6.1.js"></script>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/checkout/">

    <link rel="stylesheet" href="/statics/css/bootstrap-datetimepicker.min.css">
    <script crossorigin="anonymous" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/statics/bootstrap-5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="/statics/js/orderForm.js"></script>
    <script src="/statics/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>

    <link href="/statics/bootstrap-5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        #allOrdersBtn{
            position: relative;
            left: 10px;
        }



    </style>
    <script type="text/javascript">
        $(function(){
            $("[data-toggle='popover']").popover();
            if (!${empty deleteMsg}){
                alert("删除成功");
            };
            if (!${empty changeMsg}){
                alert("${changeMsg}");
            };
            if (!${empty addMsg}){
                alert("${addMsg}");
            };
            $('.deleteBtn').bind("click",function (){
                const r=confirm("确认删除吗?");
                if (r){
                    return true;
                }else {
                    return false;
                }
            });
            //关于修改功能js
            $('#confirmChangeButton').bind("click",function (){
                $("#changeFormDiv").css("display","none");
            });
            $('#cancelChangeButton').bind("click",function (){
                $("#changeFormDiv").css("display","none");
            });
            $('.changeBtn').bind("click",function (){
                $("#changeFormDiv").css("display","block");
            });
            //关于增加功能的js
            $('#confirmAddButton').bind("click",function (){
                $("#addFormDiv").css("display","none");
            });
            $('#cancelAddButton').bind("click",function (){
                $("#addFormDiv").css("display","none");
            });
            $('.addBtn').bind("click",function (){
                $("#addFormDiv").css("display","block");
            });


            $('.datetimepicker1').datetimepicker({
                language: 'zh-CN', // 中文语言包
                autoclose: 1, // 选中日期后自动关闭
                format: 'yyyy-mm-dd', // 日期格式
                minView: "month", // 最小日期显示单元，这里最小显示月份界面，即可以选择到日
                todayBtn: 1, // 显示今天按钮
                todayHighlight: 1, // 显示今天高亮
            });
            $('.datetimepicker2').datetimepicker({
                language: 'zh-CN', // 中文语言包
                autoclose: 1, // 选中日期后自动关闭
                format: 'yyyy-mm-dd', // 日期格式
                minView: "month", // 最小日期显示单元，这里最小显示月份界面，即可以选择到日
                todayBtn: 1, // 显示今天按钮
                todayHighlight: 1, // 显示今天高亮
            });

            $('#datetimepicker1').datetimepicker({
                language: 'zh-CN', // 中文语言包
                autoclose: 1, // 选中日期后自动关闭
                format: 'yyyy-mm-dd', // 日期格式
                minView: "month", // 最小日期显示单元，这里最小显示月份界面，即可以选择到日
                todayBtn: 1, // 显示今天按钮
                todayHighlight: 1, // 显示今天高亮
            });
            $('#datetimepicker2').datetimepicker({
                language: 'zh-CN', // 中文语言包
                autoclose: 1, // 选中日期后自动关闭
                format: 'yyyy-mm-dd', // 日期格式
                minView: "month", // 最小日期显示单元，这里最小显示月份界面，即可以选择到日
                todayBtn: 1, // 显示今天按钮
                todayHighlight: 1, // 显示今天高亮
            });


            function countPrice(){
                var ostartDay=$(".datetimepicker1").val();
                var oendDay=$(".datetimepicker2").val();
                var timeDiff=new Date(oendDay).getTime()-new Date(ostartDay).getTime();
                var days=Math.ceil(timeDiff/(1000*3600*24))+1;

                if ($('.datetimepicker1').val()!=null&&$('.datetimepicker2').val()!=null&&days>=1){
                    document.getElementsByClassName('dateErrorInfo').innerHTML=null;
                    //当两个日期都不为空，且日期选择正确时，为总价格赋值，并让确定按钮可以提交
                    if ($('.hname').val()!=""){
                        $('.ototalPrice').val(days*(parseInt($('.rprice').val())+parseInt($('.aprice').val())));
                    }else {
                        console.log(1);
                        $('.ototalPrice').val(days*$('.rprice').val());
                    }
                    $('#confirmChangeButton').attr("disabled",false);
                }else {
                    //当用户没有选择日期时不提示错误信息
                    if ($('.datetimepicker1').val()==""&&$('.datetimepicker2').val()==""){
                        document.getElementsByClassName('dateErrorInfo').innerHTML=null;
                    }else {
                        //当用户选择了日期，且选择错误时提供错误信息
                        document.getElementsByClassName('dateErrorInfo').innerHTML="日期选择有误";
                    }
                    $('.ototalPrice').val(null);
                    $('#confirmChangeButton').attr("disabled",true);
                }
            };

            function countPrice2() {
                var ostartDay = $("#datetimepicker1").val();
                var oendDay = $("#datetimepicker2").val();
                var timeDiff = new Date(oendDay).getTime() - new Date(ostartDay).getTime();
                var days = Math.ceil(timeDiff / (1000 * 3600 * 24)) + 1;

                if ($('#datetimepicker1').val() != null && $('#datetimepicker2').val() != null && days >= 1) {

                    $('#confirmAddButton').attr("disabled", false);
                } else {
                    if ($('#datetimepicker1').val() == "" && $('#datetimepicker2').val() == "") {
                        document.getElementsByClassName('dateErrorInfo').innerHTML = null;
                    } else {

                        $('#confirmAddButton').attr("disabled", true);
                    }
                }
                ;
            }
            setInterval(countPrice2,500);
            setInterval(countPrice,500);
        })

    </script>

</head>
<body  class=" layout-boxed">
<div class="page">
    <div class="page-wrapper">
        <div class="page-body">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h2 class=" col-6"  >用户订单</h2>

<%--                        <a class="btn btn-sm btn-primary"><h4>添加订单</h4></a>--%>
                        <button type="button" class="btn btn-outline-info addBtn " data-toggle="modal" data-target="#addOrderForm">添加订单</button>



                            <form action="/searchOrderByUname" style="position: relative; left: 100px">
                                <div class="input-group">
                                    <input type="text"  class="form-control"  name="searchName"
                                           placeholder="输入用户名进行搜索" required style="position: relative;top: 20px">
                                    <span class="input-group-append" style="position: relative;top: -15px;left: 225px">
                                    <button style="display: inline" class="input-group-text" id="searchBtn" type="submit"><i data-feather="search"></i></button>
                                    </span>
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
                                        <button type="button" class="btn btn-sm btn-outline-primary changeBtn" data-toggle="modal" data-target="#changeFormDiv">修改</button>
                                        <a class="btn btn-sm btn-outline-danger deleteBtn"  href="deleteOrderByOid?deleteOid=${order.oid}&searchName=${searchName}">删除</a>
                                    </td>
                                </tr>

                                <%--这个是点完修改订单应该弹出来的页面--%>
                                <div class="modal fade" id="changeFormDiv" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                    <%-- 该按钮用于关闭模态框 --%>
                                                <h4 class="modal-title" id="myModalLabel">用户订单修改表单</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                    <%-- 模态框的主体为待修改用户数据的表单 --%>
                                                <form class="form-horizontal" role="form" method="get" action="changeOrderByOid" >
                                                    <input name="oldOtotalPrice" type="hidden" value="${order.ototalPrice}">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">订单id</label>
                                                        <div class="col-sm-9">
                                                            <input type="text"  class="oid form-control" name="oid" value="${order.oid}" readonly>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label  class="col-sm-3 control-label">用户id</label>
                                                        <div class="col-sm-9">
                                                            <input type="text"  class="uid form-control" name="uid" value="${order.uid}" readonly>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">用户名</label>
                                                        <div class="col-sm-9">
                                                            <input type="text"  class="uname form-control" name="uname" value="${order.user.uname}" readonly>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label  class="col-sm-3 control-label">景点名称</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" name="aname" class="aname form-control" required>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">景点单价/日</label>
                                                        <div class="col-sm-9">
                                                            <input type="text"  name="aprice" class="aprice form-control" required>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">酒店名称</label>
                                                        <div class="col-sm-9">
                                                            <input type="text"  class="hname form-control" name="hname"  placeholder="空" >
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">房间号</label>
                                                        <div class="col-sm-9">
                                                            <input type="text"  class="rid form-control" name="rid"  placeholder="空" >
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">房间单价/日</label>
                                                        <div class="col-sm-9">
                                                            <input type="text"  class="rprice form-control" name="rprice" placeholder="空">
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">餐厅名称</label>
                                                        <div class="col-sm-9">
                                                            <input type="text" class="rcname form-control" name="rcname" placeholder="空">
                                                        </div>
                                                    </div>



                                                    <div class="form-group">
                                                        <label  class="col-sm-3 control-label">起始日期</label>
                                                        <div class="col-sm-9">
                                                            <input  type="text"  class="datetimepicker1 form-control" name="ostartTime" required>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label  class="col-sm-3 control-label">结束日期</label>
                                                        <div class="col-sm-9">
                                                            <input  type="text"  class="datetimepicker2 form-control" name="oendTime" required>
                                                        </div>
                                                    </div>

                                                    <div class="form-group">
                                                        <label  class="col-sm-3 control-label">总费用</label>
                                                        <div class="col-sm-9">
                                                            <input type="text"  name="ototalPrice" class="ototalPrice form-control" readonly="readonly">
                                                        </div>
                                                    </div>

                                                    <div class="modal-footer">
                                                        <button type="submit" class="btn btn-primary" disabled id="confirmChangeButton" >确认修改</button>
                                                        <a href="/queryOrderByPage" ><button class="btn btn-default " type="button" data-dismiss="modal" id="cancelChangeButton" >关闭</button></a>
                                                    </div>
                                                </form>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>
<%--                                --%>
                            </c:forEach>
                        </table>
                    </div>

<%--                    --%>

<%--                    这是点完添加订单应该跳出来的页面--%>
<%--                    <div class=" justify-content-center align-items-center " id="addFormDiv" >--%>
<%--                        <form class="needs-validation" action="addOrderServlet" method="get">--%>
<%--                            <div class="row">--%>

<%--                                <div class="col-3">--%>
<%--                                    <label>用户名</label>--%>
<%--                                    <input type="text"  id="addUname" name="addUname"  required>--%>
<%--                                </div>--%>
<%--                                <div class="col-3">--%>
<%--                                    <label >景点名称</label>--%>
<%--                                    <input type="text" id="addAname" name="addAname" required>--%>
<%--                                </div>--%>
<%--                                <div class="col-3">--%>
<%--                                    <label  >酒店名称</label>--%>
<%--                                    <input type="text"  id="addHname" name="addHname"   >--%>
<%--                                </div>--%>
<%--                                <div class="col-3">--%>
<%--                                    <label>房间号</label>--%>
<%--                                    <input type="text" id="addRid" name="addRid"  >--%>
<%--                                </div>--%>
<%--                                <div class="col-4">--%>
<%--                                    <label >餐厅名称</label>--%>
<%--                                    <input type="text" class="addRcname" name="addRcname">--%>
<%--                                </div>--%>
<%--                                <div class="col-4 ">--%>
<%--                                    <label >起始日期</label>--%>
<%--                                    <input  type="text"  id="datetimepicker1" name="addOstartTime" required>--%>
<%--                                </div>--%>
<%--                                <div class="col-4 ">--%>
<%--                                    <label>截止日期</label>--%>
<%--                                    <input  type="text"  id="datetimepicker2" name="addOendTime" required>--%>
<%--                                </div>--%>
<%--                                <small style="color: red" class="dateErrorInfo" class="d-flex justify-content-center align-items-center"></small>--%>
<%--                                <div class="my-4"></div>--%>
<%--                                <button class="w-100 btn btn-primary btn-lg" type="submit" id="confirmAddButton" disabled >确认添加</button>--%>
<%--                                <a href="/queryOrderByPage" ><button class="w-100 btn btn-danger btn-lg" type="button" id="cancelAddButton" >取消添加</button></a>--%>
<%--                            </div>--%>
<%--                        </form>--%>
<%--                    </div>--%>

                    <div class="modal fade" id="addOrderForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <%-- 该按钮用于关闭模态框 --%>
                                        <h4 class="modal-title" id="myModalLabel">添加表单</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                </div>
                                <div class="modal-body">
                                    <%-- 模态框的主体为待修改用户数据的表单 --%>
                                    <form class="form-horizontal" role="form" method="get" action="addOrderServlet">
                                        <div class="form-group">
                                            <label for="addUname" class="col-sm-3 control-label">用户名</label>
                                            <div class="col-sm-6">
                                                <input type="text" name="addUname" class="form-control" id="addUname" placeholder="请输入名字">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="addAname" class="col-sm-3 control-label">景点名称</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="addAname" id="addAname"
                                                       placeholder="请输入景点名称">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="addHname" class="col-sm-3 control-label">酒店名称</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="addHname" id="addHname" placeholder="请输入酒店名称">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="addRid" class="col-sm-3 control-label">房间号</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="addRid" id="addRid" placeholder="请输入房间号">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="addRcname" class="col-sm-3 control-label">餐厅名称</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="addRcname" id="addRcname"
                                                       placeholder="请输入餐厅名称">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label  class="col-sm-3 control-label">起始日期</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control "  id="datetimepicker1" name="addOstartTime" required
                                                       placeholder="请选择起始日期">
                                            </div>
                                        </div>
                                            <div class="form-group">
                                                <label  class="col-sm-3 control-label">结束日期</label>
                                                <div class="col-sm-6">
                                                    <input type="text" class="form-control " id="datetimepicker2" name="addOendTime"  required
                                                           placeholder="请选择结束日期">
                                                </div>
                                            </div>
                                        <div class="modal-footer">
                                            <button type="submit" class="btn btn-primary" disabled id="confirmAddButton" >添加</button>
                                            <a href="/queryOrderByPage" ><button class="btn btn-default " type="button" data-dismiss="modal" id="cancelAddButton" >关闭</button></a>
                                        </div>
                                    </form>
                                </div>
                            </div><!-- /.modal-content -->
                        </div><!-- /.modal -->
                    </div>
                    <%--分页用的--%>
                    <div class="card-footer d-flex align-items-center">
                        <ul class="pagination m-0 ms-auto">
                            <c:set var="pageCount" value="${pageBean.totalCount%pageBean.pageSize==0?
                            pageBean.totalCount/pageBean.pageSize:(pageBean.totalCount/pageBean.pageSize+1)}"  scope="page"></c:set>
                            <c:if test="${pageBean.currentPage>1}">
                                <li class="page-item"><a class="page-link" href="/queryOrderByPage?currentPage=${pageBean.currentPage-1}&pageSize=5&searchName=${searchName}">上一页</a></li>
                            </c:if>
                            <li class="page-item"><a class="page-link">当前第${pageBean.currentPage}页</a></li>
                            <c:if test="${pageBean.currentPage<=pageCount-1}">
                                <li class="page-item"><a class="page-link" href="queryOrderByPage?currentPage=${pageBean.currentPage+1}&pageSize=5&searchName=${searchName}">下一页</a></li>
                            </c:if>
                        </ul>
                        <form action="queryOrderByPage?pageSize=5&searchName=${searchName}">
                            <input type="number" min="1" name="currentPage" required  >
                            <button type="submit" CLASS="btn btn-outline-secondary">跳转</button>
                        </form>
                        <a class="btn btn-outline-dark" id="allOrdersBtn" href="queryOrderByPage" >全部订单</a>
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
    });
</script>
</body>
</html>



