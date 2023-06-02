<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改班级信息</title>
    <!-- Core CSS  -->
    <link rel="stylesheet" type="text/css" href="${basePath}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/glyphicons.min.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="${basePath}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/pages.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/plugins.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/responsive.css">

    <!-- Boxed-Layout CSS -->
    <link rel="stylesheet" type="text/css" href="${basePath}/css/boxed.css">


    <!-- Core Javascript - via CDN -->
    <script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
    <script>

        $.ajax({
            url: "${baseurl}/findMajorByDeptId?deptId=407",
            type: "post",
            //定义回调响应的数据格式为JSON字符串,该属性可以省略
            dataType: "json",
            //成功响应的结果
            success: function (result) {
                $.each(result, function (i, item) {
                    $("#majorId").append("<option value=" + item.majorId + ">" + item.majorName + "</option>");
                })
            }
        });

        $.ajax({
            url: "${basePath}/findTeacherByRole",
            type: "post",
            //定义回调响应的数据格式为JSON字符串,该属性可以省略
            dataType: "json",
            //成功响应的结果
            success: function (result) {
                $.each(result.tutors,function (i,item) {
                    $("#tutorId").append("<option value="+item.jobId+">"+item.teacherName+"</option>");
                })
                $.each(result.instructors,function (i,item) {
                    $("#instructorId").append("<option value="+item.jobId+">"+item.teacherName+"</option>");
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
                <li class="active">编辑班级</li>
            </ol>
        </div>
        <div class="container">

            <div class="row">
                <div class="col-md-10 col-lg-11 center-column">
                    <form action="${basePath}/officer/updateClass" method="post" class="cmxform">
                        <div class="panel">
                            <div class="panel-heading">
                                <div class="panel-title">编辑班级</div>
                                <div class="panel-btns pull-right margin-left">
                                    <a href="${basePath}/officer/findAllClasses" class="btn btn-default btn-gradient dropdown-toggle"><span class="glyphicon glyphicon-chevron-left"></span></a>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="col-md-7">
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">班级ID</span>
                                            <input type="text" name="classId" readonly value="${c.classId}" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">班级名称</span>
                                            <input type="text" name="className" value="${c.className}" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">班级人数</span>
                                            <input type="text" name="classSize" value="${c.classSize}" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">班级剩余人数</span>
                                            <input type="text" name="classSurplus" value="${c.classSurplus}" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"><span class="input-group-addon">所属专业</span>
                                            <select id="majorId" name="major_id">
                                                <option value="${c.majorId}">${c.majorId}</option>
                                                <option>请选择专业</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"><span class="input-group-addon">学习导师</span>
                                            <select name="tutor_id" id="tutor_id" style="height:34px;">
                                                <option value="${c.tutorId}">${c.tutorId}</option>
                                                <option>请选择学习导师</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"><span class="input-group-addon">辅导员</span>
                                            <select name="instructor_id"  id="instructor_id" onchange="findInstructor()" style="height:34px;">
                                                <option value="${c.instructorId}">${c.instructorId}</option>
                                                <option>请选择辅导员</option>
                                            </select>
                                        </div>
                                    </div>

                                    <%--<div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">学习导师</span>
                                            <input type="text" name="tutorId" value="${c.tutorId}" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">辅导员</span>
                                            <input type="text" name="instructorId" value="${c.instructorId}" class="form-control">
                                        </div>
                                    </div>--%>
                                    <div class="form-group">
                                        <div class="input-group"><span class="input-group-addon">备注</span>
                                            <input type="text" name="bz" value="${c.bz}" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <%--<div class="form-group col-md-12">
                                    <textarea style="width:100%;height:150px;"></textarea>
                                </div>--%>
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
        </div>
    </section>
    <!-- End: Content -->
</div>

</body>

</html>