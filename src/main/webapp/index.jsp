<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/checkout/">
    <link href="/statics/bootstrap-5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/statics/css/bootstrap-datetimepicker.min.css">
    <script src="statics/jquery-3.6.1.js"></script>
    <script crossorigin="anonymous" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/statics/bootstrap-5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="/statics/js/orderForm.js"></script>
    <script src="/statics/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
    <script>
        $(function(){
            if (!${empty msg}){
                alert("${msg}");
                <% request.setAttribute("msg",null);%>
            }
        })

    </script>
</head>
<body>
<h2>前端首页</h2>
<div class="modal fade" id="addOrderForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <%-- 该按钮用于关闭模态框 --%>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">用户订单修改表单</h4>
            </div>
            <div class="modal-body">
                <%-- 模态框的主体为待修改用户数据的表单 --%>
                <form class="form-horizontal" role="form" method="post" action="userReviseServlet">
                    <%-- 设置隐藏域，因为模态框中无uid信息，而更新修改时，需要通过该uid进行 --%>
                    <input type="hidden" id="uid" name="uid" value="">
                    <%-- 需要将当前页也传给servlet中，为了提交成功后，返回对应当前页中 --%>
                    <input type="hidden" name="currentPage" value="${requestScope.pageBean.currentPage}">
                    <div class="form-group">
                        <label for="addUname" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" name="addUname" class="form-control" id="addUname" placeholder="请输入名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addAname" class="col-sm-2 control-label">景点名称</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="addAname" id="addAname"
                                   placeholder="请输入景点名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addHname" class="col-sm-2 control-label">酒店名称</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="addHname" id="addHname" placeholder="请输入酒店名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addRid" class="col-sm-2 control-label">房间号</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="addRid" id="addRid" placeholder="请输入房间号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="addRcname" class="col-sm-2 control-label">餐厅名称</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="addRcname" id="addRcname"
                                   placeholder="请输入餐厅名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">起始日期</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control datetimepicker1"  name="ostartTime" required
                                   placeholder="请选择起始日期">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">结束日期</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control datetimepicker2" name="oendTime"  required
                                   placeholder="请选择结束日期">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">总价格</label>
                        <div class="col-sm-6">
                            <input type="text" class="ototalPrice form-control" name="ototalPrice"  readonly >
                        </div>
                    </div>
                    <%--  该模态框的页脚本身应在主体的外部，但因为表单提交需要，将其放在内部! --%>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary" disabled id="confirmAddButton" >添加</button>
                        <%--                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>--%>
                        <a href="/queryOrderByPage" ><button class="btn btn-default " type="button" data-dismiss="modal" id="cancelAddButton" >关闭</button></a>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>
