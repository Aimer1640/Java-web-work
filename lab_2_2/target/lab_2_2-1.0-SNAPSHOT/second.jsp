<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.example.pojo.User" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/3
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Second</title>
</head>
<body>
<%
    ApplicationContext applicationContext= WebApplicationContextUtils.getWebApplicationContext(application);
    User user1= (User) applicationContext.getBean("user1");
    User user2= (User) applicationContext.getBean("user2");
    User user3= (User) applicationContext.getBean("user3");

    System.out.println("singleton:"+user1);
    System.out.println("prototype:"+user2);
    System.out.println("request:"+user3);
%>

</body>
</html>
