<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
    <title>后台-景点管理</title>
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
        top: 80px;
        text-align: center;
        vertical-align: middle;
    }

    #tablediv table td, th, caption {
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

    #addUser {
        position: absolute;
        top: 30px;
        right: 100px;
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
    function attractionRevise(o) {
        //将该button标签的属性id的值拿到，即每一个button标签设置的uid
        var index = $(o).attr("id");
        //将button标签存放的uid拿出来放在变量uid中
        var aid = $(o).attr("aid");
        var apicture = $(o).attr("apicture");

        //获取表格中的一行数据  注意给原表格加上id为table
        var aname = document.getElementById("table").rows[index].cells[0].innerText;
        var adescription = document.getElementById("table").rows[index].cells[2].innerText;
        var aaddress = document.getElementById("table").rows[index].cells[3].innerText;
        var atype = document.getElementById("table").rows[index].cells[4].innerText;
        var ascore = document.getElementById("table").rows[index].cells[5].innerText;
        var acity = document.getElementById("table").rows[index].cells[6].innerText;
        var aprice = document.getElementById("table").rows[index].cells[7].innerText;

        //向模态框中传值  将模态框中的元素标签id拿到，然后赋值即可
        $('#aname').val(aname);
        $('#aaddress').val(aaddress);
        $('#adescription').val(adescription);
        $('#atype').val(atype);
        $('#ascore').val(ascore);
        $('#aprice').val(aprice);
        $('#acity').val(acity);
        $('#apicture').val(apicture);
        //向模态框的隐藏域中设置aid的值
        //向模态框中对应标签属性设置值为aid
        $("#aid1").attr("value", aid)
    }
</script>
<body>

<div id="addUser">
    <%-- 点击该按钮打开用户新增的模态框 --%>
    <button class="btn btn-primary" data-toggle="modal" data-target="#attractionAdd">
        新增景点
    </button>
</div>

<div id="tablediv">
    <table class="table table-hover table-bordered" id="table">
        <caption>景点管理中心</caption>
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
            <th colspan="2">更新</th>
        </tr>
        </thead>
        <tbody>
        <%-- 注：varStatus提供了可以迭代的索引和计数等信息，刚好可以作为序号，范围在0-5之间，status的index从0开始 --%>
        <c:forEach items="${requestScope.pageBean.list}" var="attraction" varStatus="status">
            <tr>
                <td>${attraction.aname}</td>
                <td><img src="statics/pagephone/attractions/${attraction.apicture}" width="50px" height="50px"/></td>
                <td>${attraction.adescription}</td>
                <td>${attraction.aaddress}</td>
                <td>${attraction.atype}</td>
                <td>${attraction.ascore}</td>
                <td>${attraction.acity}</td>
                <td>${attraction.aprice}</td>
                <td>
                        <%-- 给每个按钮增加一个动态id，uid，为了在模态框中展示对应该行数据 创建点击事件onclick，this标签当前标签元素，在打开模态框前，先将原表格数据写入到模态框元素标签中--%>
                    <button id="${status.index+1}" class="btn btn-primary" data-toggle="modal"
                            data-target="#attractionRevise"
                            onclick="attractionRevise(this)" aid="${attraction.aid}" apicture="${attraction.apicture}">
                        修改
                            <%-- 创建自定义属性uid，用于给button元素存放用户id，为了提供给修改servlet，将该button标签对应图片路径存放属性apicture中，为了用户可以获取到                       --%>
                    </button>
                </td>
                <td><%-- 在删除时，为了删除该条记录后仍然能跳转到当前页，需要将当前页传过去 --%>
                    <a href="attractionDeleteServlet?aid=${attraction.aid}&currentPage=${requestScope.pageBean.currentPage}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul class="pagination">
        <c:if test="${requestScope.pageBean.currentPage-1<1}">
            <li id="prev"><a href="attractionManagerServlet?currentPage=1">&laquo;</a></li>
        </c:if>
        <c:if test="${requestScope.pageBean.currentPage-1>=1}">
            <li id="prev"><a
                    href="attractionManagerServlet?currentPage=${requestScope.pageBean.currentPage-1}">&laquo;</a>
            </li>
        </c:if>

        <c:forEach begin="1" end="${requestScope.pageNum}" step="1" var="i">
            <li id="page${i}"><a href="attractionManagerServlet?currentPage=${i}">${i}</a></li>
        </c:forEach>

        <c:if test="${requestScope.pageBean.currentPage+1>requestScope.pageNum}">
            <li id="next"><a href="attractionManagerServlet?currentPage=${requestScope.pageNum}">&raquo;</a></li>
        </c:if>
        <c:if test="${requestScope.pageBean.currentPage+1<=requestScope.pageNum}">
            <li id="next"><a
                    href="attractionManagerServlet?currentPage=${requestScope.pageBean.currentPage+1}">&raquo;</a>
            </li>
        </c:if>
    </ul>
</div>

<div class="modal fade" id="attractionAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <%-- 该按钮用于关闭模态框 --%>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">景点信息新增表单</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" method="post" action="attractionAddServlet">
                    <%-- 需要将当前页也传给servlet中，为了提交成功后，返回对应当前页中 --%>
                    <input type="hidden" name="currentPage" value="${requestScope.pageBean.currentPage}">
                    <div class="form-group">
                        <label for="aname1" class="col-sm-3 control-label" style="text-align: center">景点名称</label>
                        <div class="col-sm-6">
                            <input type="text" name="aname1" class="form-control" id="aname1"
                                   placeholder="请输入景点名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="aaddress1" class="col-sm-3 control-label" style="text-align: center">地址</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="aaddress1" id="aaddress1"
                                   placeholder="请输入景点地址">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="adescription1" class="col-sm-3 control-label"
                               style="text-align: center">描述</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="adescription1" id="adescription1"
                                   placeholder="请输入景点描述信息">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="atype1" class="col-sm-3 control-label" style="text-align: center">类型</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="atype1" id="atype1"
                                   placeholder="请输入景点类型">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ascore1" class="col-sm-3 control-label" style="text-align: center">评分</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="ascore1" id="ascore1"
                                   placeholder="请输入景点评分">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="aprice1" class="col-sm-3 control-label" style="text-align: center">价格</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="aprice1" id="aprice1"
                                   placeholder="请输入景点价格">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="acity1" class="col-sm-3 control-label"
                               style="text-align: center">景点所在城市</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="acity1" id="acity1"
                                   placeholder="请输入景点所在城市">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="apicture1" class="col-sm-3 control-label"
                               style="text-align: center">景点图片路径</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="apicture1" id="apicture1"
                                   placeholder="请输入该景点图片在项目中的路径">
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

<div class="modal fade" id="attractionRevise" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <%-- 该按钮用于关闭模态框 --%>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">景点信息修改表单</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" method="post" action="attractionReviseServlet">
                    <%-- 设置隐藏域，因为模态框中无uid信息，而更新修改时，需要通过该uid进行 --%>
                    <input type="hidden" id="aid1" name="aid" value="">
                    <%-- 需要将当前页也传给servlet中，为了提交成功后，返回对应当前页中 --%>
                    <input type="hidden" name="currentPage" value="${requestScope.pageBean.currentPage}">
                    <div class="form-group">
                        <label for="aname" class="col-sm-3 control-label" style="text-align: center">景点名称</label>
                        <div class="col-sm-6">
                            <input type="text" name="aname" class="form-control" id="aname"
                                   placeholder="请输入景点名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="aaddress" class="col-sm-3 control-label" style="text-align: center">地址</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="aaddress" id="aaddress"
                                   placeholder="请输入景点地址">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="adescription" class="col-sm-3 control-label" style="text-align: center">描述</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="adescription" id="adescription"
                                   placeholder="请输入景点描述信息">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="atype" class="col-sm-3 control-label" style="text-align: center">类型</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="atype" id="atype"
                                   placeholder="请输入景点类型">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="ascore" class="col-sm-3 control-label" style="text-align: center">评分</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="ascore" id="ascore"
                                   placeholder="请输入景点评分">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="aprice" class="col-sm-3 control-label" style="text-align: center">价格</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="aprice" id="aprice"
                                   placeholder="请输入景点价格">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="acity" class="col-sm-3 control-label"
                               style="text-align: center">景点所在城市</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="acity" id="acity"
                                   placeholder="请输入景点所在城市">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="apicture" class="col-sm-3 control-label"
                               style="text-align: center">景点图片路径</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="apicture" id="apicture"
                                   placeholder="请输入该景点图片在项目中的路径">
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