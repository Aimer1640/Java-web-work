<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>教务员主页</title>
    <!-- Core CSS  -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/glyphicons.min.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pages.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/plugins.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/responsive.css">

    <!-- Boxed-Layout CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/boxed.css">


    <!-- Core Javascript - via CDN -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script>
        function checkAll(obj){
            //获取name=id的复选框
            var boxs = document.getElementsByName("id");
            alert(obj.checked);
            for(var i = 0; i < boxs.length; i++) {
                boxs[i].checked = obj.checked;
            }
        }
    </script>
</head>

<body>
<!-- Start: Header -->
<header class="navbar navbar-fixed-top" style="background-image: none; background-color: rgb(240, 240, 240);">
    <div class="pull-left"><a class="navbar-brand" href="#">
        <div class="navbar-logo"><img src="${pageContext.request.contextPath}/images/logo.png" alt="logo"></div>
    </a></div>
    <div class="pull-right header-btns">
        <a class="user"><span class="glyphicons glyphicon-user"></span> ${user.account} </a>
        <a href="${pageContext.request.contextPath}/login.html" class="btn btn-default btn-gradient" type="button"><span
                class="glyphicons glyphicon-log-out"></span> 退出</a>
    </div>
</header>
<!-- End: Header -->

<!-- Start: Main -->
<div id="main">
    <!-- Start: Sidebar -->
    <aside id="sidebar" class="affix">
        <div id="sidebar-search">

        </div>
        <div id="sidebar-menu">
            <ul class="nav sidebar-nav">
                <li>
                    <a href="${baseurl}/index.html"><span class="glyphicons glyphicon-home"></span><span
                            class="sidebar-title">后台首页</span></a>
                </li>
                <li>
                    <a href="${baseurl}/news_list.html"><span class="glyphicons glyphicon-file"></span><span class="sidebar-title">系部管理</span></a>
                </li>
                <li>
                    <a href="${baseurl}/findAllMajors"><span class="glyphicons glyphicon-paperclip"></span><span
                            class="sidebar-title">专业管理</span></a>
                </li>
                <li>
                    <a href="${baseurl}/findAllClasses"><span class="glyphicons glyphicon-paperclip"></span><span
                            class="sidebar-title">班级管理</span></a>
                </li>
                <li>
                    <a href="${baseurl}/website.html"><span class="glyphicons glyphicon-paperclip"></span><span
                            class="sidebar-title">网站信息</span></a>
                </li>
            </ul>
        </div>
    </aside>
    <!-- End: Sidebar -->

    <!-- Start: Content -->
    <section id="content">
        <div id="topbar" class="affix">
            <ol class="breadcrumb">
                <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            </ol>
        </div>
        <div class="container">


            <div class="col-md-11">
                <div id="docs-content">
                    <h2 class="page-header margin-top-none">个人信息</h2>
                    <table class="table">
                        <tr>
                            <td colspan="2">您好，${user.account}</td>
                        </tr>
                        <tr>
                            <td width="100">最后登录时间:</td>
                            <td><%= new Date()%>></td>
                        </tr>
                        <tr>
                            <td>最后登录IP:</td>
                            <td>127.0.0.1</td>
                        </tr>
                    </table>

                    <h2 class="page-header margin-top-none">系统信息</h2>
                    <table class="table">
                        <tr>
                            <td width="100">操作系统：</td>
                            <td>Windows</td>
                        </tr>
                        <tr>
                            <td>Servlet 版本:</td>
                            <td>4.0.1</td>
                        </tr>
                        <tr>
                            <td>MySQL 版本:</td>
                            <td>8.0.20</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </section>
    <!-- End: Content -->
</div>
<!-- End: Main -->
</body>
</html>