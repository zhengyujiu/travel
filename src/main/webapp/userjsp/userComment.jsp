<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
    <title>后台-个人中心-我的评论</title>
    <meta charset="utf-8"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
        var currentPage =${requestScope.pageBean.currentPage};
        // 字符串拼接的方式，给当前页对应的分页值设置为active!
        $("#page+currentPage").attr("class", "active");
        if (currentPage - 1 < 1) {
            $("#prev").attr("class", "disabled");
        }
        if (currentPage + 1 >${requestScope.pageNum}) {
            $("#next").attr("class", "disabled");
        }
        $("[data-toggle='popover']").popover();
    });
</script>
<body>

<div id="tablediv">
    <table class="table table-hover table-bordered" id="table">
        <caption>我的评论</caption>
        <thead>
        <tr>
            <th>序号</th>
            <th>景点名称</th>
            <th>用户评分</th>
            <th>评论时间</th>
            <th>评论内容</th>
            <th>更新</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.pageBean.list}" var="comment" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${comment.comment_attraction.aname}</td>
                <td>${comment.uscore}</td>
                <td>${comment.cdate}</td>
                <td>${comment.ccontent}</td>
                <td>
                    <a href="commentDeleteServlet?cid=${comment.cid}&currentPage=${requestScope.pageBean.currentPage}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul class="pagination">
        <c:if test="${requestScope.pageBean.currentPage-1<1}">
            <li id="prev"><a href="myCommentServlet?currentPage=1">&laquo;</a></li>
        </c:if>
        <c:if test="${requestScope.pageBean.currentPage-1>=1}">
            <li id="prev"><a href="myCommentServlet?currentPage=${requestScope.pageBean.currentPage-1}">&laquo;</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${requestScope.pageNum}" step="1" var="i">
            <li id="page${i}"><a href="myCommentServlet?currentPage=${i}">${i}</a></li>
        </c:forEach>

        <c:if test="${requestScope.pageBean.currentPage+1>requestScope.pageNum}">
            <li id="next"><a href="myCommentServlet?currentPage=${requestScope.pageNum}">&raquo;</a></li>
        </c:if>
        <c:if test="${requestScope.pageBean.currentPage+1<=requestScope.pageNum}">
            <li id="next"><a href="myCommentServlet?currentPage=${requestScope.pageBean.currentPage+1}">&raquo;</a>
            </li>
        </c:if>
    </ul>
</div>

</div>
</body>
</html>