<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
    <title>后台-用户管理</title>
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

    #addUser{
        position: absolute;
        top: 50px;
        right:100px;
    }

</style>
<script type="text/javascript">
    $(function () {
        var currentPage =${requestScope.pageBean.currentPage};
        //使用字符串拼接的方式，给当前页对应的分页值设置为active!
        $("#page+currentPage").attr("class", "active");
        if (currentPage - 1 < 1) {
            $("#prev").attr("class", "disabled");
        }
        if (currentPage + 1 >${requestScope.pageNum}) {
            $("#next").attr("class", "disabled");
        }
        $("[data-toggle='popover']").popover();
    });

    //这里的o表示数据表格中某一个修改button标签
    function userRevise(o) {
        //将该button标签的属性id的值拿到，即每一个button标签设置的uid
        var index = $(o).attr("id");
        //将button标签存放的uid拿出来放在变量uid中
        var uid = $(o).attr("uid");

        //获取表格中的一行数据  注意给原表格加上id为table
        var uname = document.getElementById("table").rows[index].cells[0].innerText;
        var upassword = document.getElementById("table").rows[index].cells[1].innerText;
        var uage = document.getElementById("table").rows[index].cells[2].innerText;
        var usex = document.getElementById("table").rows[index].cells[3].innerText;
        var uphone = document.getElementById("table").rows[index].cells[4].innerText;
        var uemail = document.getElementById("table").rows[index].cells[5].innerText;
        var ufunds = document.getElementById("table").rows[index].cells[6].innerText;
        //向模态框中传值  将模态框中的元素标签id拿到，然后赋值即可
        $('#uname').val(uname);
        $('#upassword').val(upassword);
        $('#uage').val(uage);
        if (usex == '男') {
            document.getElementById('man').checked = true;
        } else {
            document.getElementById('women').checked = true;
        }
        $('#uphone').val(uphone);
        $('#uemail').val(uemail);
        $('#ufunds').val(ufunds);
        //向模态框的隐藏域中设置uid的值
        $("#uid").attr("value", uid)
    }
</script>
<body>

<div id="addUser">
    <%-- 点击该按钮打开用户新增的模态框 --%>
    <button class="btn btn-primary" data-toggle="modal" data-target="#userAdd">
        新增用户
    </button>
</div>

<div id="tablediv">
    <table class="table table-hover table-bordered" id="table">
        <caption>用户管理中心</caption>
        <thead>
        <tr>
            <th>用户名称</th>
            <th>密码</th>
            <th>年龄</th>
            <th>性别</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>资金</th>
            <th colspan="2">更新</th>
        </tr>
        </thead>
        <tbody>
        <%-- 注：varStatus提供了可以迭代的索引和计数等信息，刚好可以作为序号，范围在0-5之间，status的index从0开始 --%>
        <c:forEach items="${requestScope.pageBean.list}" var="user" varStatus="status">
            <tr>
                <td>${user.uname}</td>
                <td>${user.upassword}</td>
                <td>${user.uage}</td>
                <td>${user.usex}</td>
                <td>${user.uphone}</td>
                <td>${user.uemail}</td>
                <td>${user.ufunds}</td>
                <td>
                        <%-- 给每个按钮增加一个动态id，uid，为了在模态框中展示对应该行数据 创建点击事件onclick，this标签当前标签元素，在打开模态框前，先将原表格数据写入到模态框元素标签中--%>
                    <button id="${status.index+1}" class="btn btn-primary" data-toggle="modal" data-target="#userRevise"
                            onclick="userRevise(this)" uid="${user.uid}">修改
                            <%-- 创建自定义属性uid，用于给button元素存放用户id，为了提供给修改servlets                       --%>
                    </button>
                </td>
                <td><%-- 在删除时，为了删除该条记录后仍然能跳转到当前页，需要将当前页传过去 --%>
                    <a href="userDeleteServlet?uid=${user.uid}&currentPage=${requestScope.pageBean.currentPage}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul class="pagination">
        <c:if test="${requestScope.pageBean.currentPage-1<1}">
            <li id="prev"><a href="userManagerServlet?currentPage=1">&laquo;</a></li>
        </c:if>
        <c:if test="${requestScope.pageBean.currentPage-1>=1}">
            <li id="prev"><a href="userManagerServlet?currentPage=${requestScope.pageBean.currentPage-1}">&laquo;</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${requestScope.pageNum}" step="1" var="i">
            <li id="page${i}"><a href="userManagerServlet?currentPage=${i}">${i}</a></li>
        </c:forEach>

        <c:if test="${requestScope.pageBean.currentPage+1>requestScope.pageNum}">
            <li id="next"><a href="userManagerServlet?currentPage=${requestScope.pageNum}">&raquo;</a></li>
        </c:if>
        <c:if test="${requestScope.pageBean.currentPage+1<=requestScope.pageNum}">
            <li id="next"><a href="userManagerServlet?currentPage=${requestScope.pageBean.currentPage+1}">&raquo;</a>
            </li>
        </c:if>
    </ul>
</div>
<%--注意模态框的内容，只有当点击对应button标签或a链接时，才可将模态框内容展示出来，否则不会展示模态框的内容--%>
<%-- 修改用户信息的模态框的展示 --%>
<!-- 模态框（Modal） -->
<div class="modal fade" id="userRevise" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <%-- 该按钮用于关闭模态框 --%>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">用户信息修改表单</h4>
            </div>
            <div class="modal-body">
                <%-- 模态框的主体为待修改用户数据的表单 --%>
                <form class="form-horizontal" role="form" method="post" action="userReviseServlet">
                    <%-- 设置隐藏域，因为模态框中无uid信息，而更新修改时，需要通过该uid进行 --%>
                    <input type="hidden" id="uid" name="uid" value="">
                    <%-- 需要将当前页也传给servlet中，为了提交成功后，返回对应当前页中 --%>
                    <input type="hidden" name="currentPage" value="${requestScope.pageBean.currentPage}">
                    <div class="form-group">
                        <label for="uname" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" name="uname" class="form-control" id="uname" placeholder="请输入名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upassword" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="upassword" id="upassword"
                                   placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uage" class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="uage" id="uage" placeholder="请输入年龄">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-6">
                            <!-- 单选框选项 -->
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="usex" id="man" value="男" checked>
                                            男
                                        </label>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="usex" id="women" value="女">
                                            女
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uphone" class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="uphone" id="uphone" placeholder="请输入电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uemail" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="uemail" id="uemail"
                                   placeholder="请输入电子邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ufunds" class="col-sm-2 control-label">资金</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="ufunds" id="ufunds"
                                   placeholder="请输入个人资金">
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

<%-- 新增用户信息的模态框展示 --%>
<div class="modal fade" id="userAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <%-- 该按钮用于关闭模态框 --%>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">新增用户信息表单</h4>
            </div>
            <div class="modal-body">
                <%-- 模态框的主体为待修改用户数据的表单 --%>
                <form class="form-horizontal" role="form" method="post" action="userAddServlet">
                    <%-- 需要将当前页也传给servlet中，为了提交成功后，返回对应当前页中 --%>
                    <input type="hidden" name="currentPage" value="${requestScope.pageBean.currentPage}">
                    <div class="form-group">
                        <label for="uname1" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" name="uname1" class="form-control" id="uname1" placeholder="请输入名字">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="upassword1" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="upassword1" id="upassword1"
                                   placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uage1" class="col-sm-2 control-label">年龄</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="uage1" id="uage1" placeholder="请输入年龄">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-6">
                            <!-- 单选框选项 -->
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="usex1" id="man1" value="男" checked>
                                            男
                                        </label>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="usex1" id="women1" value="女">
                                            女
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uphone1" class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="uphone1" id="uphone1" placeholder="请输入电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="uemail1" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="uemail1" id="uemail1"
                                   placeholder="请输入电子邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ufunds1" class="col-sm-2 control-label">资金</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="ufunds1" id="ufunds1"
                                   placeholder="请输入个人资金">
                        </div>
                    </div>
                    <%--  该模态框的页脚本身应在主体的外部，但因为表单提交需要，将其放在内部! --%>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">确认新增</button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>