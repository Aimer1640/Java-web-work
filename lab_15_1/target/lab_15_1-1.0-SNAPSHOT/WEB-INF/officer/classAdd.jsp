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
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/glyphicons.min.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="css/theme.css">
    <link rel="stylesheet" type="text/css" href="css/pages.css">
    <link rel="stylesheet" type="text/css" href="css/plugins.css">
    <link rel="stylesheet" type="text/css" href="css/responsive.css">

    <!-- Boxed-Layout CSS -->
    <link rel="stylesheet" type="text/css" href="css/boxed.css">


    <!-- Core Javascript - via CDN -->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
        $.ajax({
            url:"${baseurl}/officer/findMajorsByDeptId?deptId=407",
            type:"post",
            dataType:"json",
            success:function (result){
                $.each(result,function (i,item){
                    $("#majorId").append("<option value="+item.majorId+">"+item.majorName+"</option>>");
                })
            }
        });
        // 2040706101 杨艾琳
        $.ajax({
            url:"${baseurl}/officer/findTeacherByRoleId?roleId=0",
            type:"post",
            dataType:"json",
            success:function (result){
                $.each(result,function (i,item){
                    $("#tutorId").append("<option value="+item.jobId+">"+item.teacherName+"</option>>");
                })
            }
        });
        // 2040706101 杨艾琳
        $.ajax({
            url:"${baseurl}/officer/findTeacherByRoleId?roleId=1",
            type:"post",
            dataType:"json",
            success:function (result){
                $.each(result,function (i,item){
                    $("#instructorId").append("<option value="+item.jobId+">"+item.teacherName+"</option>>");
                })
            }
        });
    </script>


</head>

<body>
<!-- Start: Header -->
<header class="navbar navbar-fixed-top" style="background-image: none; background-color: rgb(240, 240, 240);">
    <div class="pull-left"> <a class="navbar-brand" href="#">
        <div class="navbar-logo"><img src="images/logo.png" alt="logo"></div>
    </a> </div>
    <div class="pull-right header-btns">
        <a class="user"><span class="glyphicons glyphicon-user"></span> admin</a>
        <a href="login.html" class="btn btn-default btn-gradient" type="button"><span class="glyphicons glyphicon-log-out"></span> 退出</a>
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
                    <a href="toIndex"><span class="glyphicons glyphicon-home"></span><span class="sidebar-title">后台首页</span></a>
                </li>
                <li>
                    <a href="showAllDepts"><span class="glyphicons glyphicon-file"></span><span class="sidebar-title">系别管理</span></a>
                </li>
                <li>
                    <a href="showAllMajors"><span class="glyphicons glyphicon-paperclip"></span><span class="sidebar-title">专业管理</span></a>
                </li>
                <li>
                    <a href="showAllClasses"><span class="glyphicons glyphicon-credit-card"></span><span class="sidebar-title">班级管理</span></a>
                </li>
                <li>
                    <a href="showAllUsers"><span class="glyphicons glyphicon-paperclip"></span><span class="sidebar-title">用户管理</span></a>
                </li>
            </ul>
        </div>
    </aside>
    <!-- End: Sidebar -->
    <!-- Start: Content -->
    <section id="content">
        <div id="topbar" class="affix">
            <ol class="breadcrumb">
                <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                <li class="active">添加专业</li>
            </ol>
        </div>
        <div class="container">

            <div class="row">
                <div class="col-md-10 col-lg-11 center-column">
                    <form action="${baseurl}/officer/addClass" method="post" class="cmxform">
                        <div class="panel">
                            <div class="panel-heading">
                                <div class="panel-title">添加班级</div>
                                <div class="panel-btns pull-right margin-left">
                                    <a href="news_list.html" class="btn btn-default btn-gradient dropdown-toggle"><span class="glyphicon glyphicon-chevron-left"></span></a>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="col-md-7">
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">班级ID</span>
                                            <input type="text" name="classId" value="" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">班级名称</span>
                                            <input type="text" name="className" value="" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">班级人数</span>
                                            <input type="text" name="classSize" value="" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">剩余人数</span>
                                            <input type="text" name="classSurplus" value="" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">所属专业</span>
<%--                                            <input type="text" name="classSurplus" value="" class="form-control">--%>
                                            <select id="majorId" name="majorId">
                                                <option>请选择专业</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">辅导员</span>
                                            <select id="instructorId" name="instructorId">
                                                <option>请选择辅导员</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">学习导师</span>
                                            <select id="tutorId" name="tutorId">
                                                <option>学习导师</option>
                                            </select>
                                        </div>
                                    </div>
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
