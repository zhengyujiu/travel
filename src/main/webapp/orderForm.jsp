<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>生成订单</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/checkout/">
    <link href="/statics/bootstrap-5.3.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }
        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
        .b-example-divider {
            height: 3rem;
            background-color: rgba(0, 0, 0, .1);
            border: solid rgba(0, 0, 0, .15);
            border-width: 1px 0;
            box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
        }
        .b-example-vr {
            flex-shrink: 0;
            width: 1.5rem;
            height: 100vh;
        }
        .bi {
            vertical-align: -.125em;
            fill: currentColor;
        }
        .nav-scroller {
            position: relative;
            z-index: 2;
            height: 2.75rem;
            overflow-y: hidden;
        }
        .nav-scroller .nav {
            display: flex;
            flex-wrap: nowrap;
            padding-bottom: 1rem;
            margin-top: -1px;
            overflow-x: auto;
            text-align: center;
            white-space: nowrap;
            -webkit-overflow-scrolling: touch;
        }
    </style>
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
                <form class="needs-validation" novalidate>
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="userId" class="form-label">用户ID</label>
                            <input type="text" class="form-control" id="userId" value="1" readonly="readonly">
                        </div>

                        <div class="col-sm-6">
                            <label for="uname" class="form-label">用户名</label>
                            <input type="text" class="form-control" id="uname" name="uname" value="郑渝久" >
                        </div>

                        <div class="col-12">
                            <label for="aname" class="form-label">景点名称</label>
                            <input type="text" class="form-control" name="aname" id="aname" readonly="readonly" value="1">
                        </div>

                        <div class="col-12">
                            <label for="hname" class="form-label">酒店名称</label>
                            <input type="text" class="form-control" id="hname" name="hname"  readonly="readonly" value="1">
                        </div>

                        <div class="col-12">
                            <label for="rcname" class="form-label">餐厅名称</label>
                            <input type="text" class="form-control" id="rcname" name="rcname"  readonly="readonly" value="1">
                        </div>

                        <div class="col-md-6">
                            <label for="country" class="form-label">Country</label>
                            <select class="form-select" id="country" required>
                                <option value="">Choose...</option>
                                <option>United States</option>
                            </select>
                            <div class="invalid-feedback">
                                Please select a valid country.
                            </div>
                        </div>


                        <div class="col-sm-6">

                        </div>

                        <div class="col-sm-6">

                        </div>
                    </div>

                    <hr class="my-4">

                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="same-address">
                        <label class="form-check-label" for="same-address">Shipping address is the same as my billing address</label>
                    </div>

                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="save-info">
                        <label class="form-check-label" for="save-info">Save this information for next time</label>
                    </div>

                    <hr class="my-4">
                    <hr class="my-4">

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
                </form>
            </div>
        </div>
    </main>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017–2022 旅游信息平台</p>
    </footer>
</div>


<script src="/statics/bootstrap-5.3.0/js/bootstrap.bundle.min.js"></script>
<script src="/statics/js/orderForm.js"></script>
</body>
</html>
