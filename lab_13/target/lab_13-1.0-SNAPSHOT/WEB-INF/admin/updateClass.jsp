<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 引入核心标签库 -->

<c:set var="baseurl" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    <%--to record pronect Name (contextPath=/jwxt)--%>
    contextPath = "${pageContext.request.contextPath}";
</script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>修改班级页面</title>
    <link href="${baseurl}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${baseurl}/js/jquery.min.js"></script>
    <script src="${baseurl}/js/bootstrap.min.js"></script>
</head>
<body>
<h2 align="center">后台管理-班级修改</h2>
<hr/>
<form name="updateClass" action="updateClass" method="post">
    <div id="table_div">
        <table align="center">
            <tr>
                <%-- 2040706101 杨艾琳--%>
                <td>班级ID：</td>
                <td><input type="text" id="classId" name="classId" value="${classes.classId}"></td>
            </tr>
            <tr>
                <td>班级名称：</td>
                <td><input type="text" name="className"></td>
            </tr>
            <tr >
                <td>班级容量：</td>
                <td><input type="text" name="classSize"></td>
            </tr>
            <tr >
                <td>剩余人数：</td>
                <td><input type="text" name="classSurplus"></td>
            </tr>
            <tr >
                <td>专业ID：</td>
                <td><input type="text" name="majorId"></td>
            </tr>
            <tr align="center">
                <td colspan="2"><input id="btn_submit" type="submit" value="提交" />
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="btn_reset" type="reset" value="取消" /></td>
            </tr>
        </table>
    </div>
</form>

</body>
</html>