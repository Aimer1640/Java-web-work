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
    <link href="${baseurl}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${baseurl}/js/jquery.min.js"></script>
    <script src="${baseurl}/js/bootstrap.min.js"></script>
</head>
<body>

<h2 align="center">后台管理-班级管理</h2>
<hr/>
<a href=''><img src="${baseurl}/img/add.png"></a>
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
        <!-- 显示所有班级信息 -->
        <c:forEach items="${classList}" varStatus="c" var="class">
            <tr>
                <td>${c.index+1}</td>
                <td>${class.classId}</td>
                <td>${class.className}</td>
                <td>${class.classSize}</td>
                <td>${class.classSurplus}</td>
                <td>${class.majorId}</td>
                <td>
                    <a href="updateClass?classId=${class.classId}">编辑</a>
                    <a href="deleteClassById?classId=${class.classId}">删除</a>
                </td>
            </tr>
        </c:forEach>


    </tbody>
</table>
</body>
</html>