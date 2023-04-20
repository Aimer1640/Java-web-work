<%@ page language="java" pageEncoding="UTF-8" %>
<!-- 引入核心标签库 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript">
    <%--to record pronect Name (contextPath=/jwxt)--%>
    contextPath = "${pageContext.request.contextPath}";
</script>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>后台管理-班级管理</title>
    <link href="/WEB-INF/css/bootstrap.min.css" rel="stylesheet">
    <script src="/WEB-INF/js/jquery.min.js"></script>
    <script src="/WEB-INF/js/bootstrap.min.js"></script>
</head>
<body>

<h2 align="center">后台管理-班级管理</h2>
<hr/>
<a href="toAddClass">添加新班级</a>
<div id="logout" align="right"><a href="logout">注销</a></div>
<table class="table  table-bordered" align="center" valign="middle">
    <thead>
    <tr>
        <th scope="col">序号</th>
        <th scope="col">班级ID</th>
        <th scope="col">班级名称</th>
        <th scope="col">班级容量</th>
        <th scope="col">剩余人数</th>
        <th scope="col">专业ID</th>
        <th scope="col">操作</th>
    </tr>
    </thead>
    <tbody>
    <%-- 2040706101 杨艾琳--%>
        <c:forEach items="${classList}" varStatus="c" var="classes">
            <tr>
                <td>${c.index+1}</td>
                <td>${classes.classId}</td>
                <td>${classes.className}</td>
                <td>${classes.classSize}</td>
                <td>${classes.classSurplus}</td>
                <td>${classes.majorId}</td>
                <td>
                    <a href="updateClass?classId=${classes.classId}">编辑</a>
                    <a href="deleteClassById?classId=${classes.classId}">删除</a>
                </td>
            </tr>
        </c:forEach>


    </tbody>
</table>
</body>
</html>