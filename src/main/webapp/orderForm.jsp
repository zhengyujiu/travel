<%@ page import="com.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <%
        String aname=request.getParameter("aname");
        String aprice=request.getParameter("aprice");
        String hname=request.getParameter("hname");
        String rid=request.getParameter("rid");
        String rprice=request.getParameter("rprice");
        String rcname=request.getParameter("rcname");
        String rtype=request.getParameter("rtype");
        String aid=request.getParameter("aid");
        String hid=request.getParameter("hid");
        String rcid=request.getParameter("rcid");
        rprice="100";
        aprice="100";
        aid="1";
        rid="101";
        rcid="1";

        request.getSession().setAttribute("aid",aid);
        request.getSession().setAttribute("hid",hid);
        request.getSession().setAttribute("rcid",rcid);
        request.setAttribute("rid",rid);
        request.setAttribute("aname",aname);
        request.setAttribute("aprice",aprice);
        request.setAttribute("hname",hname);
        request.setAttribute("rprice",rprice);
        request.setAttribute("rcname",rcname);
        request.setAttribute("rtype",rtype);
    %>
<%--现在能通过表单传过去的属性是：rid uid ostart_time oend_time ototal_price --%>
<%--    还缺 aid hid rcid--%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>生成订单</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/checkout/">
    <link href="/statics/bootstrap-5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/statics/css/bootstrap-datetimepicker.min.css">
    <script src="statics/jquery-3.6.1.js"></script>
    <script crossorigin="anonymous" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="/statics/bootstrap-5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="/statics/js/orderForm.js"></script>
    <script src="/statics/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
    <style>
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
        body{
            background-image: url("statics/imgs/orderFormBg.jpg");
            width: 100%;
            height: 100%;
            position: absolute;
        }
    </style>
    <script>
        $(function(){
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
                var ostartDay=$("#datetimepicker1").val();
                var oendDay=$("#datetimepicker2").val();
                var timeDiff=new Date(oendDay).getTime()-new Date(ostartDay).getTime();
                var days=Math.ceil(timeDiff/(1000*3600*24))+1;
                if ($('#datetimepicker1').val()!=null&&$('#datetimepicker2').val()!=null&&days>=1){
                    document.getElementById('dateErrorInfo').innerHTML=null;
                    //当两个日期都不为空，且日期选择正确时，为总价格赋值，并让确定按钮可以提交
                    if ($('#hname').val()!=null){
                        $('#ototalPrice').val(days*(${rprice}+${aprice}));
                    }else {
                        $('#ototalPrice').val(days*${aprice});
                    }
                    $('#confirmButton').attr("disabled",false);
                }else {
                    //当用户没有选择日期时不提示错误信息
                    if ($('#datetimepicker1').val()==""&&('#datetimepicker2').val()==""){
                        document.getElementById('dateErrorInfo').innerHTML=null;
                    }else {
                        //当用户选择了日期，且选择错误时提供错误信息
                        document.getElementById('dateErrorInfo').innerHTML="日期选择有误";
                    }
                    $('#ototalPrice').val(null);
                    $('#confirmButton').attr("disabled",true);
                }
            }
            setInterval(countPrice,100);
        })
    </script>
    <link href="/statics/css/orderForm.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container">
    <main>
        <div class="py-5 text-center">
            <h2>确认订单</h2>
        </div>
        <div class="row g-5  d-flex justify-content-center align-items-center" >
            <div class="col-md-7 col-lg-8">
                <form class="needs-validation" action="/insertOrder" method="get">
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="uid" class="form-label">用户ID</label>
                            <input type="text" class="form-control" id="uid" name="uid" value="${user.uid}" readonly="readonly">
                        </div>

                        <div class="col-sm-6">
                            <label for="uname" class="form-label">用户名</label>
                            <input type="text" class="form-control" id="uname" name="uname" value="${user.uname}" >
                        </div>

                        <div class="col-6">
                            <label for="aname" class="form-label">景点名称</label>
                            <input type="text" class="form-control" name="aname" id="aname" readonly="readonly" value="${aname}">
                        </div>
                        <div class="col-6">
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
                        <div class="col-12">
                            <label for="rcname" class="form-label">餐厅名称</label>
                            <input type="text" class="form-control" id="rcname" name="rcname"  readonly="readonly" value="${rcname}" placeholder="空">
                        </div>
                        <div class="col-6 ">
                            <label for="datetimepicker1" class="form-label">起始日期</label>
                            <input class="form-control" type="text"  id="datetimepicker1" name="ostartTime" >
                        </div>
                        <div class="col-6 ">
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
    </main>
    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017–2022 旅游信息平台</p>
    </footer>
</div>
</body>
</html>
