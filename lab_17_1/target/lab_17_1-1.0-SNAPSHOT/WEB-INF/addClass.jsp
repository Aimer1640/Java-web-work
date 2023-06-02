<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加新班级</title>
    <!-- Core CSS  -->
    <link rel="stylesheet" type="text/css" href="${basePath}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/glyphicons.min.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="${basePath}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/pages.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/plugins.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/responsive.css">

    <!-- Boxed-Layout CSS -->
    <%--<link rel="stylesheet" type="text/css" href="${basePath}/css/boxed.css">
--%>

    <!-- Core Javascript - via CDN -->
    <script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
    <script>
            $.ajax({
                url: "${basePath}/officer/findMajorByDeptId?deptId=407",
                type: "post",
                //定义回调响应的数据格式为JSON字符串,该属性可以省略
                dataType: "json",
                //成功响应的结果
                success: function (result) {
                    $.each(result,function (i,item) {
                        $("#majorId").append("<option value="+item.majorId+">"+item.majorName+"</option>");
                    })
                }
            });

    </script>
</head>

<body>
<%@include file="header.jsp" %>

<!-- Start: Main -->
<div id="main">
    <%@include file="sidebar.jsp" %>
    <!-- Start: Content -->
    <section id="content">
        <div id="topbar" class="affix">
            <ol class="breadcrumb">
                <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                <li class="active">班级管理</li>
            </ol>
        </div>
        <div class="container">

            <div class="row">
                <div class="col-md-10 col-lg-11 center-column">
                    <form action="${basePath}/officer/addClass" method="post" class="cmxform">
                        <div class="panel">
                            <div class="panel-heading">
                                <div class="panel-title">添加新班级</div>
                                <div class="panel-btns pull-right margin-left">
                                    <a href="news_list.html" class="btn btn-default btn-gradient dropdown-toggle"><span
                                            class="glyphicon glyphicon-chevron-left"></span></a>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="col-md-7">
                                    <div class="form-group">
                                        <div class="input-group"><span class="input-group-addon">班级名称</span>
                                            <input type="text" name="className" value="" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"><span class="input-group-addon">班级人数</span>
                                            <input type="text" name="classSize" value="" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"><span class="input-group-addon">剩余人数</span>
                                            <input type="text" name="classSurplus" value="" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"><span class="input-group-addon">所属专业</span>
                                            <select id="majorId" name="majorId">
                                                <option>请选择专业</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"><span class="input-group-addon">导师ID</span>
                                            <input type="text" name="tutorId" value="" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"><span class="input-group-addon">辅导员ID</span>
                                            <input type="text" name="instructorId" value="" class="form-control">
                                        </div>
                                    </div>
                                </div>

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
