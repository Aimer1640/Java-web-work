<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseurl" value="${pageContext.request.contextPath}"/>
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <title>CMS内容管理系统</title>
  <meta name="keywords" content="Admin">
  <meta name="description" content="Admin">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Core CSS  -->
  <link rel="stylesheet" type="text/css" href="${baseurl}/css/bootstrap.css">
  <%--    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">--%>
  <link rel="stylesheet" type="text/css" href="${baseurl}/css/glyphicons.min.css">

  <!-- Theme CSS -->
  <link rel="stylesheet" type="text/css" href="${baseurl}/css/theme.css">
  <link rel="stylesheet" type="text/css" href="${baseurl}/css/pages.css">
  <link rel="stylesheet" type="text/css" href="${baseurl}/css/plugins.css">
  <link rel="stylesheet" type="text/css" href="${baseurl}/css/responsive.css">


  <!-- Your Custom CSS -->
  <link rel="stylesheet" type="text/css" href="${baseurl}/css/custom.css">

  <!-- Core Javascript - via CDN -->
  <script type="text/javascript" src="${baseurl}/js/jquery.min.js"></script>

  <script>
    function findClass() {
      // 获取输入的查询关键词、图书名称、ISBN、出版社名称
      var classId = $("#classId").val();
      var className = $("#className").val();
      var classSize = $("#classSize").val();
      var classSurplus = $("#classSurplus").val();
      var majorId = $("#majorId").val();
      var instructorId = $("#instructorId").val();
      var tutorId = $("#tutorId").val();
      $.ajax({
        url:"${baseurl}/findClassByClassId",
        type:"post",
        // 定义发送请求的数据格式为JSON字符串
        contentType:"application/json;charset=UTF-8",
        // data表示发送的数据
        data:JSON.stringify({
          classId :classId,
          className:className,
          classSize:classSize,
          classSurplus : classSurplus,
          majorId:majorId,
          instructorId:instructorId,
          tutorId:tutorId,
        }),
        //定义回调响应的数据格式为JSON字符串,该属性可以省略
        dataType : "json",
        //成功响应的结果
        success : function(result) {
          if (result != null) {
            //alert("查询图书列表：<br>" + result[0].bookName);
            alert("修改成功");
          }
        }
      });
    }
  </script>

</head>

<body>
<!-- Start: Header -->
<header class="navbar navbar-fixed-top" style="background-image: none; background-color: rgb(240, 240, 240);">
  <div class="pull-left"> <a class="navbar-brand" href="#">
    <div class="navbar-logo"><img src="images/logo.png" alt="logo"></div>
  </a> </div>
  <div class="pull-right header-btns">
    <a class="user"><span class="glyphicons glyphicon-user"></span> admin</a>
    <a href="login.html" class="btn btn-default btn-gradient" type="button"><span class="glyphicons glyphicon-log-out"></span> 退出</a>
  </div>
</header>
<!-- End: Header -->

<!-- Start: Main -->
<div id="main">
  <!-- Start: Sidebar -->
  <aside id="sidebar" class="affix">
    <div id="sidebar-search">

    </div>
    <div id="sidebar-menu">
      <ul class="nav sidebar-nav">
        <li>
          <a href="toIndex"><span class="glyphicons glyphicon-home"></span><span class="sidebar-title">后台首页</span></a>
        </li>
        <li>
          <a href="showAllDepts"><span class="glyphicons glyphicon-file"></span><span class="sidebar-title">系别管理</span></a>
        </li>
        <li>
          <a href="showAllMajors"><span class="glyphicons glyphicon-paperclip"></span><span class="sidebar-title">专业管理</span></a>
        </li>
        <li>
          <a href="showAllClasses"><span class="glyphicons glyphicon-credit-card"></span><span class="sidebar-title">班级管理</span></a>
        </li>
        <li>
          <a href="showAllUsers"><span class="glyphicons glyphicon-paperclip"></span><span class="sidebar-title">用户管理</span></a>
        </li>
      </ul>
    </div>
  </aside>
  <!-- End: Sidebar -->

  <!-- Start: Content -->
  <section id="content">
    <div id="topbar" class="affix">
      <ol class="breadcrumb">
        <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
        <li class="active">班级管理</li>
      </ol>
    </div>
    <div class="container">

      <div class="row">
        <div class="col-md-12">
          <div class="panel">
            <div class="panel-heading">
              <div class="panel-title">班级列表</div>
              <a href="addClass" class="btn btn-info btn-gradient pull-right"><span class="glyphicons glyphicon-plus"></span> 添加班级</a>
            </div>
            <form action="deleteClassById" method="post">
              <div class="panel-body">
                <table class="table table-striped table-bordered table-hover dataTable">
                  <tr class="active">
                    <th class="text-center">
                      <a class="btn btn-gray btn-sm" id="selectAll">全选</a>
                    </th>
                    <th>班级ID</th>
                    <th>班级名称</th>
                    <th>班级人数</th>
                    <th>班级剩余人数</th>
                    <th>学习导师</th>
                    <th>辅导员</th>
                    <th width="200">操作</th>
                  </tr>
                  <c:forEach items="${classList}" var="c">
                    <tr class="success">
                      <td class="text-center"><input type="checkbox" value="${c.classId}" name="id" class="cbox"></td>
                      <td>${c.classId}</td>
                      <td>${c.className}</td>
                      <td>${c.classSize}</td>
                      <td>${c.classSurplus}</td>
                      <td>${c.tutorId}</td>
                      <td>${c.instructorId}</td>
                      <td><a href="findClassByClassId?classId=${c.classId}">编辑</a> <a href="deleteClassById/${c.classId}">删除</a> </td>
                    </tr>
                  </c:forEach>
                </table>

                <div class="pull-left">
                  <%--                                    <button type="submit" class="btn btn-default btn-gradient pull-right delall"><span class="glyphicons glyphicon-trash"></span></button>--%>
                  <button type="submit" class="btn btn-default btn-gradient pull-right delall">批量删除</button>
                </div>

                <div class="pull-right">
                  <ul class="pagination" id="paginator-example">
                    <li><a href="#">&lt;</a></li>
                    <li><a href="#">&lt;&lt;</a></li>
                    <li><a href="#">1</a></li>
                    <li class="active"><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">&gt;</a></li>
                    <li><a href="#">&gt;&gt;</a></li>
                  </ul>
                </div>

              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>ix
  <!-- End: Content -->
</div>
<!-- End: Main -->
</body>
</html>