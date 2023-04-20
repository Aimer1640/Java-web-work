<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript">
	<%--to record pronect Name (contextPath=/jwxt)--%>
	contextPath = "${pageContext.request.contextPath}";
</script>
<!DOCTYPE html>
<html>
<head>
	<!-- Meta, title, CSS, favicons, etc. -->
	<meta charset="utf-8">
	<title>登录</title>
	<meta name="keywords" content="Admin">
	<meta name="description" content="Admin">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- Core CSS  -->
	<link rel="stylesheet" type="text/css" href="${baseurl}/css/bootstrap.css">

	<!-- Theme CSS -->
	<link rel="stylesheet" type="text/css" href="${baseurl}/css/theme.css">
	<link rel="stylesheet" type="text/css" href="${baseurl}/css/pages.css">
	<link rel="stylesheet" type="text/css" href="${baseurl}/css/responsive.css">

</head>
<body class="login-page">

<!-- Start: Main -->
<div id="main">
	<div class="container">
		<div class="row">
			<div id="page-logo"></div>
		</div>
		<div class="row">
			<div class="panel">
				<div class="panel-heading">
					<div class="panel-title"><h2>系统登录入口</h2></div>
				</div>

				<form action="${baseurl}/login" class="cmxform" id="altForm" method="post">
					<div class="panel-body">
						<div class="form-group">
							<div class="input-group"> <span class="input-group-addon">用户名</span>
								<input type="text" name="account" class="form-control" autocomplete="off"  placeholder="请输入您的用户名">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group"> <span class="input-group-addon">密&nbsp;&nbsp;&nbsp;码</span>
								<input type="password" name="password" class="form-control"  placeholder="请输入您的密码">
							</div>
						</div>
						<div class="form-group">
							<div class="input-group"> <span class="input-group-addon">验证码</span>
								<input type="text" name="code" placeholder="验证码" style="height:34px;"/><img name="imgValidate"  src="${baseurl}/code.jsp"/>
							</div>
						</div>
						<div class="form-group">
							<div class="input-group"> <span class="input-group-addon">角&nbsp;&nbsp;&nbsp;色</span>
								<select name="roleId"  style="height:34px;">
									<option value="0">管理员</option>
									<option value="1">教务员</option>
									<option value="2">财务处</option>
									<option value="3">宿舍管理员</option>
									<option value="4">系书记</option>
									<option value="5">新生</option>
								</select>
							</div>
						</div>
						<div class="form-group" style="font-size:18px;color: #fe561f">
							${msg}
						</div>
					</div>

					<div class="panel-footer"> <span class="panel-title-sm pull-left" style="padding-top: 7px;"></span>
						<div class="form-group margin-bottom-none">
							<input type="hidden" value="login" name="action-mark" />
							<input class="btn btn-primary pull-center" type="submit" value="登 录" />
							<input class="btn btn-primary pull-center" type="reset" value="取 消" />
							<div class="clearfix"></div>
						</div>
					</div>

				</form>

			</div>
		</div>
	</div>
</div>
<!-- End: Main -->

</body>

</html>