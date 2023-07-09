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
            }
        })

    </script>
</head>
<body>
<h2>Hello World!</h2>
<%
    String age="10";
%>
<c:out value="age"></c:out>
<input type="password">
</body>
</html>
