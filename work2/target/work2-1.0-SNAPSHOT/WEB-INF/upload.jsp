<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>CMS内容管理系统</title>
    <meta name="keywords" content="Admin">
    <meta name="description" content="Admin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Core CSS  -->
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/glyphicons.min.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/pages.css">
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/plugins.css">
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/responsive.css">

    <!-- Boxed-Layout CSS -->
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/boxed.css">


    <!-- Core Javascript - via CDN -->
<%--    <script type="text/javascript" src="${baseurl}/js/jquery.min.js">--%>
<%--        // 判断是否填写上传人并已选择上传文件--%>
<%--        function check(){--%>
<%--            var name = document.getElementById("idCard").value;--%>
<%--            var file = document.getElementById("file").value;--%>
<%--            if(name==""){--%>
<%--                alert("填写上传人");--%>
<%--                return false;--%>
<%--            }--%>
<%--            if(file.length==0||file==""){--%>
<%--                alert("请选择上传文件");--%>
<%--                return false;--%>
<%--            }--%>
<%--            return true;--%>
<%--        }--%>
<%--    </script>--%>

</head>

<body>
<!-- Start: Header -->
<header class="navbar navbar-fixed-top" style="background-image: none; background-color: rgb(240, 240, 240);">
    <div class="pull-left"> <a class="navbar-brand" href="#">
        <div class="navbar-logo"><img src="${baseurl}/images/logo.png" alt="logo"></div>
    </a> </div>
    <div class="pull-right header-btns">
        <a class="user"><span class="glyphicons glyphicon-user"></span> admin</a>
        <a href="login.html" class="btn btn-default btn-gradient" type="button"><span class="glyphicons glyphicon-log-out"></span> 退出</a>
    </div>
</header>
<!-- End: Header -->

<!-- Start: Main -->
<div id="main">

    <section id="content">
        <div id="topbar" class="affix">
            <ol class="breadcrumb">
                <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                <li class="active">文件上传</li>
            </ol>
        </div>
        <div class="container">

            <div class="row">
                <div class="col-md-10 col-lg-11 center-column">
<%--                    <form action="${baseurl}/toUpload"--%>
<%--                          method="post" enctype="multipart/form-data" onsubmit="return check()" class="cmxform">--%>
                    <form action="${baseurl}/freshman/toUpload"
                          method="post" enctype="multipart/form-data" class="cmxform">
                        <%--				//2040706101 杨艾琳--%>
                        <div class="panel">
                            <div class="panel-heading">
                                <div class="panel-title">文件上传</div>
                                <div class="panel-btns pull-right margin-left">
                                    <a href="news_list.html" class="btn btn-default btn-gradient dropdown-toggle"><span class="glyphicon glyphicon-chevron-left"></span></a>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="col-md-7">
<%--                                    <div class="form-group">--%>
<%--                                        <div class="input-group"> <span class="input-group-addon">新生ID</span>--%>
<%--                                            <input type="text" readonly name="idCard" value="${freshman.idCard}" class="form-control">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--&lt;%&ndash;                                    <div class="form-group">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        <div class="input-group"> <span class="input-group-addon">新生ID</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                            <input type="text" readonly name="ticknumber" value="${freshman.ticketNumber}" class="form-control">&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                                    </div>&ndash;%&gt;--%>
<%--                                    <div class="form-group">--%>
<%--                                        <div class="input-group"> <span class="input-group-addon">姓名</span>--%>
<%--                                            <input type="text" readonly name="name" value="${freshman.name}" class="form-control">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <div class="input-group"> <span class="input-group-addon">性别</span>--%>
<%--                                            <input type="text" name="sex" value="${freshman.sex}" class="form-control">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <div class="input-group"> <span class="input-group-addon">年龄</span>--%>
<%--                                            <input type="text" name="age" value="${freshman.age}" class="form-control">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>

                                    <div>
<%--                                        上传人：<input id="name" type="text" name="name" /><br />--%>
                                        请上传作业文件：<input id="file" type="file" name="uploadFile"
                                                     multiple="multiple" class="form-control"/><br />
<%--                                        <input type="submit" value="上传" />--%>
                                    </div>

<%--                                    <div class="form-group">--%>
<%--                                        <div class="input-group"> <span class="input-group-addon">生日</span>--%>
<%--                                            <input type="text" name="birthday" value="${freshman.birthday}" class="form-control">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
                                </div>
<%--                                <div class="form-group col-md-12">--%>
<%--                                    <textarea style="width:100%;height:150px;"></textarea>--%>
<%--                                </div>--%>
                                <div class="col-md-7">
                                    <div class="form-group">
                                        <input type="submit" value="提交" class="submit btn btn-blue">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
    </section>
    <!-- End: Content -->
</div>

</body>

</html>
