<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理界面</title>
    <meta name="description" content="">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="../img/lysf.ico">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/bootstrap.css">
    <link rel="stylesheet" href=${basePath}/"css/amazeui.min.css" />
    <link rel="stylesheet" href="${basePath}/css/admin.css">
    <link rel="stylesheet" href="${basePath}/css/app.css">
</head>

<body data-type="index">

<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand"><strong>广软教学管理系统(教师)</strong><div class="pull-right header-btns">
        <a class="user">您好，用户 ${USER_SESSION.getAccount()}</a>
        <a href="${baseurl}/logout" class="btn btn-default btn-gradient" type="button">退出</a>
    </div></div>

</header>

<div class="tpl-page-container tpl-page-header-fixed">

    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-title">功能列表</div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item"><a href="${basePath}/student/findAllStudents"
                                                 class="nav-link active link_a" target="iframe_a"> <i class="am-icon-home"></i> <span>查看学生</span>
                </a></li>
                <li class="tpl-left-nav-item"><a href="${basePath}/student/updateStudent"
                                                 class="nav-link link_a" target="iframe_a"> <i class="am-icon-check-square-o"></i> <span>登记考勤</span>
                </a></li>
                <li class="tpl-left-nav-item"><a href="${basePath}/project/addProject"
                                                 class="nav-link link_a" target="iframe_a"> <i class="am-icon-check-square-o"></i> <span>发布作业</span>
                </a></li>
                <li class="tpl-left-nav-item"><a href="${basePath}/project/findAllProject"
                                                 class="nav-link link_a" target="iframe_a"> <i class="am-icon-check-square-o"></i> <span>查看已发布作业</span>
                </a></li>
                <li class="tpl-left-nav-item"><a href="${basePath}/coursework/findAllCourseWork"
                                                 class="nav-link link_a" target="iframe_a"> <i class="am-icon-check-square-o"></i> <span>查看已提交作业</span>
                </a></li>

                <li class="tpl-left-nav-item"><a href="logout"
                                                 class="nav-link tpl-left-nav-link-list link_a" target="iframe_a"> <i
                        class="am-icon-download"></i> <span>退出登录</span>
                </a></li>
            </ul>
        </div>
    </div>

    <!--begin  -->
    <div class="tpl-content-wrapper">
        <iframe id="iframepage" name="iframe_a" src="student/findAllStudents" style="width: 100%;height: 850px;" seamless></iframe>
    </div>
    <!--end  -->

</div>
<div>

</div>

</body>

</html>