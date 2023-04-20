<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.example.dao.MajorDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.pojo.Major" %>
<%@ page import="com.example.dao.MajorController" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP</title>
</head>
<body>
<%--2040706101 杨艾琳--%>
<%
    ApplicationContext applicationContext= WebApplicationContextUtils.getWebApplicationContext(application);
    MajorController majorController= (MajorController) applicationContext.getBean("majorController");
    List<Major> majors=majorController.findAllMajor();
    application.setAttribute("majors",majors);
%>
<table class="table  table-bordered" align="center" valign="middle">
    <thead>
    <tr>
        <th scope="col">专业编号</th>
        <th scope="col">专业名称</th>
        <th scope="col">所需学费</th>
        <th scope="col">所属系别</th>
    </tr>
    </thead>
    <tbody>
    <%--2040706101 杨艾琳--%>
    <c:forEach items="${majors}" var="m" varStatus="s">
    <form name='form' action=''>
        <tr>
            <td>${m.majorId}</td>
            <td>${m.majorName}</td>
            <td>${m.tuition}</td>
            <td>${m.deptId}</td>
        </tr>
    </form>
    </c:forEach>
    </tbody>
</table>
</body>
</html>