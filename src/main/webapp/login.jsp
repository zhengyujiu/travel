<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="author" content="Webpixels">
    <title>用户登录</title>
    <style>
        @keyframes hidePreloader {
            0% {
                width: 100%;
                height: 100%;
            }

            100% {
                width: 0;
                height: 0;
            }
        }

        body > div.preloader {
            position: fixed;
            background: white;
            width: 100%;
            height: 100%;
            z-index: 1071;
            opacity: 0;
            transition: opacity .5s ease;
            overflow: hidden;
            pointer-events: none;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        body:not(.loaded) > div.preloader {
            opacity: 1;
        }

        body:not(.loaded) {
            overflow: hidden;
        }

        body.loaded > div.preloader {
            animation: hidePreloader .5s linear .5s forwards;
        }
    </style>
    <script src="/statics/jquery.min.js"></script>
    <script src="/statics/jquery-3.6.1.js"></script>
    <script src="/statics/bootstrap-5.3.0/js/bootstrap.bundle.js"></script>
    <script src="/statics/js/svg-injector.min.js"></script>
    <script src="/statics/js/feather.min.js"></script>
    <script src="/statics/js/quick-website.js"></script>

    <script>
        window.addEventListener("load", function () {
            setTimeout(function () {
                document.querySelector('body').classList.add('loaded');
            }, 300);
        });

        $(function () {
            if (!${empty msg}) {
                $('#loginMsg').attr("visibility", "visible");
            } else {
                $('#loginMsg').attr("visibility", "hidden");
            }
        })
        $(function () {
            if (!${empty registerMsg}) {
                alert(${registerMsg});
            }
        })

    </script>
    <link rel="stylesheet" href="statics/css/all.min.css">
    <link rel="stylesheet" href="statics/css/quick-website.css" id="stylesheet">
</head>

<body>

<section>
    <div class="container d-flex flex-column">
        <div class="row align-items-center justify-content-center min-vh-100">
            <div class="col-md-6 col-lg-5 col-xl-5 py-6 py-md-0">
                <div class="card shadow zindex-100 mb-0">
                    <div class="card-body px-md-5 py-5">
                        <div class="mb-5">
                            <h6 class="h3">登录</h6>
                            <p class="text-muted mb-0">登录您的帐户以继续.</p>
                        </div>
                        <span class="clearfix"></span>
                        <form action="/loginServlet" method="post">
                            <div class="form-group">
                                <label class="form-control-label" for="uname">用户名</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i data-feather="user"></i></span>
                                    </div>
                                    <input type="text" class="form-control" id="uname" name="uname"
                                           placeholder="请输入用户名" required>
                                </div>
                            </div>
                            <div class="form-group mb-0">
                                <div class="d-flex align-items-center justify-content-between">
                                    <div>
                                        <label class="form-control-label" for="upassword">密码</label>
                                    </div>

                                </div>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"><i data-feather="key"></i></span>
                                    </div>
                                    <input type="password" class="form-control" id="upassword" name="upassword" required
                                           placeholder="请输入密码">
                                </div>
                                <small style="color: red;" id="loginMsg">${msg}</small>
                            </div>
                            <div class="mt-4">
                                <button type="submit" class="btn btn-block btn-primary">登录</button>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer px-md-5"><small>未注册?</small>
                        <a href="#" class="small font-weight-bold">创建账户</a></div>
                </div>
            </div>
        </div>
    </div>
</section>
<script>
    feather.replace({
        'width': '1em',
        'height': '1em'
    })
</script>
</body>

</html>