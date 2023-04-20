<%--
  Created by IntelliJ IDEA.
  User: DSY
  Date: 4/11/2021
  Time: 8:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息页面</title>
</head>
<body>
<%--2040706101 杨艾琳--%>
<h2 align="center">后台管理-专业修改</h2>
<hr/>
<form action="updateMajor" method="post">
<table align="center">
    <%--    2040706101 杨艾琳--%>
    <tr>
        <td>专业编号:</td>
        <td><input type="text" id="majorId" name="majorId" value="${major.majorId}" tabindex="1"></td>
    </tr>
    <tr>
        <td>专业名称:</td>
        <td><input type="text" id="majorName" name="majorName" tabindex="2"></td>
    </tr>
    <tr>
        <td>学费:</td>
        <td><input type="text" id="tuition" name="tuition" tabindex="3"></td>
    </tr>
    <tr>
        <td>系部ID:</td>
        <td><input type="text" id="deptId" name="deptId" tabindex="3"></td>
    </tr>
    <tr>
        <td><input id="reset" type="reset" tabindex="4"></td>
        <td><input id="submit" type="submit" tabindex="5"
                   value="修改专业"></td>
    </tr>
</table>
</form>
</body>
</html>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<c:set var="baseurl" value="${pageContext.request.contextPath}"/>--%>
<%--<script type="text/javascript">--%>
<%--    &lt;%&ndash;to record pronect Name (contextPath=/jwxt)&ndash;%&gt;--%>
<%--    contextPath = "${pageContext.request.contextPath}";--%>
<%--</script>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="utf-8"/>--%>
<%--    <title>修改专业页面</title>--%>
<%--    <link href="${baseurl}/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <script src="${baseurl}/js/jquery.min.js"></script>--%>
<%--    <script src="${baseurl}/js/bootstrap.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2 align="center">后台管理-专业添加</h2>--%>
<%--<hr/>--%>
<%--<form name="allMajor" action="allMajor" method="post">--%>
<%--    <div id="table_div">--%>
<%--        <table align="center">--%>
<%--            <tr>--%>
<%--                <td>系别ID：</td>--%>
<%--                <td><input type="text" name="deptId" value="${major.majorId}" readonly/></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>系别名称：</td>--%>
<%--                <td><input type="text" name="deptName" placeholder="专业ID" readonly/></td>--%>
<%--            </tr>--%>
<%--            <tr >--%>
<%--                <td>专业ID：</td>--%>
<%--                <td><input type="text" name="majorId" placeholder="专业ID" /></td>--%>
<%--            </tr>--%>
<%--            <tr >--%>
<%--                <td>专业名称：</td>--%>
<%--                <td>--%>
<%--                    <input type="text" name="majorName" placeholder="专业名称" /></td>--%>
<%--            </tr>--%>
<%--            <tr >--%>
<%--                <td>专业学费：</td>--%>
<%--                <td>--%>
<%--                    <input type="text" name="tuition" placeholder="专业学费" /></td>--%>
<%--            </tr>--%>
<%--            <tr align="center">--%>
<%--                <td colspan="2"><input id="btn_submit" type="submit" value="提交" />--%>
<%--                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="btn_reset" type="reset" value="取消" /></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </div>--%>
<%--</form>--%>

<%--</body>--%>
<%--</html>--%>