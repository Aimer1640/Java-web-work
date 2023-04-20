<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}"/>

<%@page isELIgnored="false" %>
<html>
<head>
    <title>文件下载</title>
</head>
<body>
    <a href="${baseurl}/freshman/download?filename=report.jpg">下载新生报道单
    <br>
<%--    <a href="${baseurl}/freshman/download?filename=新生报到单.jpg">下载新生报道单--%>
<%--        <br>--%>
    <a href="${baseurl}/freshman/download?filename=<%=URLEncoder.encode("新生报道单.jpg","UTF-8")%>">
        下载新生报道单
</a>
</body>
</html>
