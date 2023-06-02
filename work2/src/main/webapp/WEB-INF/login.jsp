<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/12/28
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript">
  <%--to record pronect Name (contextPath=/jwxt)--%>
  contextPath = "${pageContext.request.contextPath}";
</script>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <style>
    body {
      background: url('https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547_1280.jpg') no-repeat;
      background-size: 100% 130%;
    }

    #login_box {
      width: 40%;
      height: 400px;
      background-color: #00000060;
      margin: auto;
      margin-top: 10%;
      text-align: center;
      border-radius: 10px;
      padding: 50px 50px;
    }

    h2 {
      color: #ffffff90;
      margin-top: 5%;
    }

    #input-box {
      margin-top: 5%;
    }

    span {
      color: #fff;
    }

    input {
      border: 0;
      width: 60%;
      font-size: 15px;
      color: #fff;
      background: transparent;
      border-bottom: 2px solid #fff;
      padding: 5px 10px;
      outline: none;
      margin-top: 10px;
    }

    button {
      margin-top: 50px;
      width: 60%;
      height: 30px;
      border-radius: 10px;
      border: 0;
      color: #fff;
      text-align: center;
      line-height: 30px;
      font-size: 15px;
      background-image: linear-gradient(to right, #30cfd0, #330867);
    }
    #btn_submit{
      width: 350px;
      height: 45px;
      margin: 0px 4px;
      border-radius: 8px; /*圆角矩形*/
      text-indent: 5px; /*里面隐形的字体首行缩进*/
      margin: 5px auto;
    }



    #sign_up {
      margin-top: 45%;
      margin-left: 60%;
    }

    a {
      color: #b94648;
    }
  </style>
  <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript">
    //刷新验证码
    function refresh(){
      loginForm.imgValidate.src =encodeURI("code.jsp?id="+new Date());
    }
  </script>
</head>

<body>
<form action="${baseurl}/login" method="post" id="altForm" method="post">
  <div id="login_box">
    <h2>LOGIN</h2>
    <div id="input_box">
      <input class="inputinfo" name="account" type="text" placeholder="请输入用户名">
    </div>
    <div class="input_box">
      <input class="inputinfo" name="password" type="password" placeholder="请输入密码">
    </div>
<%--    <div class="input_box">--%>
<%--      <input type="text" name="code" placeholder="请输入验证码" style="width: 280px;">--%>
<%--      <img name="imgValidate" src="code.jsp" onclick="refresh()">--%>

<%--    </div>--%>
      <div class="input-input_box">
        <input class="inputinfo" placeholder="角色" style="width:200px">
        <select name="roleId"  style="height:34px;">
          <option value="0">管理员</option>
          <option value="1">教师</option>
          <option value="2">学生</option>
        </select>
      </div>
    <input id="btn_submit" type="submit" value="登录"/>

    <div><a href="register.jsp">还没有账号？点我注册</a> </div>


  </div>
</form>

</body>
</html>
