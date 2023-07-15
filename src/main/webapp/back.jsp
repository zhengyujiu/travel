<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
  <meta charset="utf-8"/>
  <link href="/statics/css/tabler.min.css" rel="stylesheet"/>

  <script src="/statics/bootstrap-5.3.0/js/bootstrap.bundle.js"></script>
  <script src="/statics/js/svg-injector.min.js"></script>
  <script src="/statics/js/feather.min.js"></script>
<%--  <script src="/statics/js/quick-website.js"></script>--%>
    <script src="statics/jquery-3.6.1.js"></script>
  <style>
    @import url('https://rsms.me/inter/inter.css');
    :root {
      --tblr-font-sans-serif: 'Inter Var', -apple-system, BlinkMacSystemFont, San Francisco, Segoe UI, Roboto, Helvetica Neue, sans-serif;
    }
    body {
      font-feature-settings: "cv03", "cv04", "cv11";
    }
    #myDiv {
        width: 100%;
        height: 0; /* 初始高度设为 0，以便撑满 div */
        padding-bottom: 56.25%; /* 根据 iframe 的宽高比例调整值，此处假设为 16:9 的比例 */
    }

    #myIframe {
        position: absolute; /* 设置 iframe 为绝对定位，以便填充 div */
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
    }
  </style>
    <script>
        $(function (){
            $("#userManage").bind("click",function (){
                $("#myIframe").attr("src","userManagerServlet");
            });
            $("#commentManage").bind("click",function (){
                $("#myIframe").attr("src","/backjsp/userManager.jsp");
            });
            $("#suggestionManage").bind("click",function (){
                $("#myIframe").attr("src","/backjsp/userManager.jsp");
            });
            $("#attractionManage").bind("click",function (){
                $("#myIframe").attr("src","attractionManagerServlet");
            });
            $("#hotelManage").bind("click",function (){
                $("#myIframe").attr("src","/backjsp/userManager.jsp");
            });
            $("#canteenManage").bind("click",function (){
                $("#myIframe").attr("src","/backjsp/userManager.jsp");
            });
            $("#roomManage").bind("click",function (){
                $("#myIframe").attr("src","/backjsp/userManager.jsp");
            });
            $("#orderManage").bind("click",function (){
                $("#myIframe").attr("src","/queryOrderByPage");
            });
        });
    </script>
</head>
<body bgcolor="#ffffff">
<div class="page">
  <aside class="navbar navbar-vertical navbar-expand-lg" data-bs-theme="dark">
    <div class="container-fluid">
        <h1 class="navbar-brand navbar-brand-autodark">
        &nbsp&nbsp旅游信息后台管理系统
        </h1>
      <div class="collapse navbar-collapse" id="sidebar-menu">
        <ul class="navbar-nav pt-lg-3">
          <li class="nav-item" id="userManage">
            <span class="nav-link" href="./" >
                  <span class="nav-link-icon d-md-none d-lg-inline-block">
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M5 12l-2 0l9 -9l9 9l-2 0" /><path d="M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-7" /><path d="M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v6" /></svg>
                  </span>
              <span class="nav-link-title">
                    用户管理
              </span>
            </span>
          </li>
          <li class="nav-item " id="commentManage">
            <span class="nav-link" >
                  <span class="nav-link-icon d-md-none d-lg-inline-block">
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M12 3l8 4.5l0 9l-8 4.5l-8 -4.5l0 -9l8 -4.5" /><path d="M12 12l8 -4.5" /><path d="M12 12l0 9" /><path d="M12 12l-8 -4.5" /><path d="M16 5.25l-8 4.5" /></svg>
                  </span>
              <span class="nav-link-title">
                    评论管理
              </span>
            </span>
          </li>


          <li class="nav-item" id="suggestionManage">
            <span class="nav-link" >
                  <span class="nav-link-icon d-md-none d-lg-inline-block"><!-- Download SVG icon from http://tabler-icons.io/i/ghost -->
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M5 11a7 7 0 0 1 14 0v7a1.78 1.78 0 0 1 -3.1 1.4a1.65 1.65 0 0 0 -2.6 0a1.65 1.65 0 0 1 -2.6 0a1.65 1.65 0 0 0 -2.6 0a1.78 1.78 0 0 1 -3.1 -1.4v-7" /><path d="M10 10l.01 0" /><path d="M14 10l.01 0" /><path d="M10 14a3.5 3.5 0 0 0 4 0" /></svg>
                  </span>
              <span class="nav-link-title">
                    推荐管理
              </span>
            </span>
          </li>

          <li class="nav-item dropdown">
            <span class="nav-link dropdown-toggle" href="#navbar-help" data-bs-toggle="dropdown" data-bs-auto-close="false" role="button" aria-expanded="false" >
                      <span class="nav-link-icon d-md-none d-lg-inline-block">
                        <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M12 12m-4 0a4 4 0 1 0 8 0a4 4 0 1 0 -8 0" /><path d="M12 12m-9 0a9 9 0 1 0 18 0a9 9 0 1 0 -18 0" /><path d="M15 15l3.35 3.35" /><path d="M9 15l-3.35 3.35" /><path d="M5.65 5.65l3.35 3.35" /><path d="M18.35 5.65l-3.35 3.35" /></svg>
                      </span>
              <span class="nav-link-title">
                    资源管理
              </span>
            </span>
              <div class="dropdown-menu">
                  <div class="dropdown-menu-columns">
                      <div class="dropdown-menu-column">
                          <span class="dropdown-item" href="./alerts.html" id="attractionManage">
                              景点管理
                          </span>
                          <span class="dropdown-item" href="./alerts.html" id="hotelManage">
                              酒店管理
                          </span>
                          <span class="dropdown-item" href="./alerts.html" id="canteenManage">
                              餐厅管理
                          </span>
                          <span class="dropdown-item" href="./alerts.html" id="roomManage">
                              房间管理
                          </span>
                      </div>
                  </div>
              </div>
          </li>

          <li class="nav-item" id="orderManage">
            <span class="nav-link">
                  <span class="nav-link-icon d-md-none d-lg-inline-block">
                    <svg xmlns="http://www.w3.org/2000/svg" class="icon" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M12 12m-4 0a4 4 0 1 0 8 0a4 4 0 1 0 -8 0" /><path d="M12 12m-9 0a9 9 0 1 0 18 0a9 9 0 1 0 -18 0" /><path d="M15 15l3.35 3.35" /><path d="M9 15l-3.35 3.35" /><path d="M5.65 5.65l3.35 3.35" /><path d="M18.35 5.65l-3.35 3.35" /></svg>
                  </span>
              <span class="nav-link-title">
                    订单管理
              </span>
            </span>
          </li>
        </ul>
      </div>
      </div>
  </aside>
    <div class="page-wrapper" >
        <div style="position: relative;left: 0px" id="myDiv">
            <iframe src="backjsp/userManager.jsp" id="myIframe" >
            </iframe>
        </div>
    </div>
</div>


</body>
</html>