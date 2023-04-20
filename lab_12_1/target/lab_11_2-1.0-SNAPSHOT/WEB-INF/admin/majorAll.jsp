<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%--<c:set var="baseurl" value="${pageContext.request.contextPath}"></c:set>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    <%--to record pronect Name (contextPath=/jwxt)--%>
    contextPath = "${pageContext.request.contextPath}";
</script>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>后台管理-专业管理</title>
    <link href="${baseurl}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${baseurl}/js/jquery.min.js"></script>
    <script src="${baseurl}/js/bootstrap.min.js"></script>
</head>
<body>

<h2 align="center">后台管理-专业管理</h2>
<hr/>
<%--<a href="toAddMajor"><img src="${baseurl}/img/add.png"></a>--%>
<a href="toAddMajor">添加专业</a>
<div id="logout" align="right"><a href="logout">注销</a></div>
<table class="table  table-bordered" align="center" valign="middle">
    <thead>
    <tr>
<%--        <th scope="col">序号</th>--%>
        <th scope="col">专业ID</th>
        <th scope="col">专业名称</th>
        <th scope="col">专业学费</th>
        <th scope="col">系别ID</th>
<%--        <th scope="col">系别名称</th>--%>
        <th scope="col">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${majorList}" var="major">
        <tr>
            <td>${major.majorId}</td>
            <td>${major.majorName}</td>
            <td>${major.tuition}</td>
            <td>${major.deptId}</td>
            <td><a href="updateMajor?majorId=${major.majorId}">编辑</a> <a href="deleteMajor?majorId=${major.majorId}">删除</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>