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

<%--        $.ajax({--%>
<%--            url: "${baseurl}/findMajorByDeptId?deptId=407",--%>
<%--            type: "post",--%>
<%--            //定义回调响应的数据格式为JSON字符串,该属性可以省略--%>
<%--            dataType: "json",--%>
<%--            //成功响应的结果--%>
<%--            success: function (result) {--%>
<%--                $.each(result, function (i, item) {--%>
<%--                    $("#majorId").append("<option value=" + item.majorId + ">" + item.majorName + "</option>");--%>
<%--                })--%>
<%--            }--%>
<%--        });--%>

<%--        $.ajax({--%>
<%--            url: "${basePath}/findTeacherByRole",--%>
<%--            type: "post",--%>
<%--            //定义回调响应的数据格式为JSON字符串,该属性可以省略--%>
<%--            dataType: "json",--%>
<%--            //成功响应的结果--%>
<%--            success: function (result) {--%>
<%--                $.each(result.tutors,function (i,item) {--%>
<%--                    $("#tutorId").append("<option value="+item.jobId+">"+item.teacherName+"</option>");--%>
<%--                })--%>
<%--                $.each(result.instructors,function (i,item) {--%>
<%--                    $("#instructorId").append("<option value="+item.jobId+">"+item.teacherName+"</option>");--%>
<%--                })--%>
<%--            }--%>
<%--        });--%>
    </script>
</head>

<body>
<div id="main">

    <section id="content">
        <div id="topbar" class="affix">
            <ol class="breadcrumb">
                <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
                <li class="active">编辑学生</li>
            </ol>
        </div>
        <div class="container">

            <div class="row">
                <div class="col-md-10 col-lg-11 center-column">
                    <form action="${basePath}/student/updateStudent" method="post" class="cmxform">
                        <div class="panel">
                            <div class="panel-heading">
                                <div class="panel-title">编辑学生</div>
                                <div class="panel-btns pull-right margin-left">
                                    <a href="${basePath}/student/findStudentByStudentId" class="btn btn-default btn-gradient dropdown-toggle"><span class="glyphicon glyphicon-chevron-left"></span></a>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="col-md-7">
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">学生ID</span>
                                            <input type="text" name="studentId" readonly value="${s.studentId}" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">学生姓名</span>
                                            <input type="text" name="studentName" value="${s.studentName}" class="form-control">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">专业ID</span>
                                            <input type="text" name="majorId" value="${s.majorId }" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">系别ID</span>
                                            <input type="text" name="deptId" value="${s.deptId }" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group"> <span class="input-group-addon">缺勤次数</span>
                                            <input type="text" name="absence" value="${s.absence }" class="form-control">
                                        </div>
                                    </div>


<%--                                    <div class="form-group">--%>
<%--                                        <div class="input-group"> <span class="input-group-addon">辅导员</span>--%>
<%--                                            <input type="text" name="instructorId" value="${c.instructorId}" class="form-control">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                    <div class="form-group">--%>
<%--                                        <div class="input-group"><span class="input-group-addon">备注</span>--%>
<%--                                            <input type="text" name="bz" value="${c.bz}" class="form-control">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
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