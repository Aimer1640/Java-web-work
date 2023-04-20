<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
    <%--to record pronect Name (contextPath=/jwxt)--%>
    contextPath = "${pageContext.request.contextPath}";
</script>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>添加专业页面</title>
    <link href="${baseurl}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${baseurl}/js/jquery.min.js"></script>
    <script src="${baseurl}/js/bootstrap.min.js"></script>
</head>
<body>
<h2 align="center">后台管理-添加</h2>
<hr/>
<form name="allMajor" action="allMajor" method="post">
    <div id="table_div">
        <table align="center">
            <tr>
                <td>系别ID：</td>
                <td><input type="text" name="deptId" value="407" readonly/></td>
            </tr>
            <tr>
                <td>系别名称：</td>
                <td><input type="text" name="deptName" value="计算机系" readonly/></td>
            </tr>
            <tr >
                <td>专业ID：</td>
                <td><input type="text" name="majorId" placeholder="专业ID" /></td>
            </tr>
            <tr >
                <td>专业名称：</td>
                <td>
                    <input type="text" name="majorName" placeholder="专业名称" /></td>
            </tr>
            <tr >
                <td>专业学费：</td>
                <td>
                    <input type="text" name="tuition" placeholder="专业学费" /></td>
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