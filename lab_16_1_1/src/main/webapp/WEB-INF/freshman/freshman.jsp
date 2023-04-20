<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>后台首页</title>
    <meta name="keywords" content="Admin">
    <meta name="description" content="Admin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Core CSS  -->
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/glyphicons.min.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/responsive.css">

    <%--				//2040706101 杨艾琳--%>
    <!-- Your Custom CSS -->
    <link rel="stylesheet" type="text/css" href="${baseurl}/css/custom.css">

    <!-- Core Javascript - via CDN -->
    <script type="text/javascript" src="${baseurl}/js/jquery.min.js"></script>
</head>
<body>
    <%@include file="header.jsp" %>
    <div id="main">
    <%@include file="sidebar.jsp" %>
    <%@include file="content.jsp" %>
    </div>
</body>
</html>