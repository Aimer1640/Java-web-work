<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/2
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="toAddMajor">专业列表页</a>
<table>
    <tr>
        <td>专业ID</td>
        <td>专业名称</td>
        <td>学费</td>
        <td>系别ID</td>
        <td>系别名称</td>
        <td>编辑</td>
    </tr>
<%--    2040706101 杨艾琳--%>
    <c:forEach items="${majorList}" var="major">
        <tr>
            <td>${major.majorId}</td>
            <td>${major.majorName}</td>
            <td>${major.tuition}</td>
            <td>${major.deptId}</td>
            <td><a href="updateMajor?majorId=${major.majorId}">编辑</a> <a href="deleteMajor?majorId=${major.majorId}">删除</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
