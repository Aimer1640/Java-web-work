<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="keywords" content="Admin">
    <meta name="description" content="Admin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Core CSS  -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="css/theme.css">
    <link rel="stylesheet" type="text/css" href="css/pages.css">
    <link rel="stylesheet" type="text/css" href="css/responsive.css">

    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        //刷新验证码
        //2040706101_杨艾琳
        function refresh() {
            loginForm.vCode.src = encodeURI("code.jsp?id=" + new Date());
        }
        function loginValidate(){
            $.ajax({
                url:"loginServlet",
                type:"json",
                method:"post",
                data:$("#loginForm").serialize(),
                async:true,
                success:function (data){
                    if (data=="正确"){
                        window.location.href='showAllBooksServlet';
                    }else {
                        $("#toolTip").html(data);
                    }
                },
                error:function (){
                    alert("异步请求错误！")
                }
            });
        }
    </script>
</head>
<body class="login-page">

<!-- Start: Main -->
<div id="main">
    <div class="container">
        <div class="row">
            <div id="page-logo"></div>
        </div>
        <div class="row">
            <div class="panel">
                <div class="panel-heading">
                    <div class="panel-title">系统登录入口</div>
                </div>

                <form action="login" class="cmxform" id="altForm" method="post">
                    <div class="panel-body">
                        <div class="form-group">
                            <div class="input-group"> <span class="input-group-addon">用户名</span>
                                <input type="text" name="username" class="form-control" autocomplete="off"  placeholder="请输入您的用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group"> <span class="input-group-addon">密&nbsp;&nbsp;&nbsp;码</span>
                                <input type="password" name="password" class="form-control" autocomplete="off" placeholder="请输入您的密码">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="input-group"> <span class="input-group-addon">验证码：</span>
                                <input class="inputinfo" type="text" name="code" placeholder="验证码" />
                                <img src="code.jsp" name="vCode" onclick="refresh()">
                            </div>
                        </div>
                    </div>

                    <div class="panel-footer"> <span class="panel-title-sm pull-left" style="padding-top: 7px;"></span>
                        <div class="form-group margin-bottom-none">
                            <input type="hidden" value="login" name="action-mark" />
                            <input class="btn btn-primary pull-right" type="submit" value="登 录" onclick="loginValidate()"/>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div>
                        <tr>
                            <td colspan="3">
                                <!-- 此处显示验证码、用户名或密码输入错误信息 -->
                                <div id="toolTip"></div>
                            </td>
                        </tr>
                    </div>


                </form>

            </div>
        </div>
    </div>
</div>
<!-- End: Main -->

</body>

</html>