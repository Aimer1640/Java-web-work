<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <meta charset="UTF-8">
    <title>显示所有班级</title>
    <!-- Core CSS  -->
    <link rel="stylesheet" type="text/css" href="${basePath}/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/glyphicons.min.css">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="${basePath}/css/theme.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/pages.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/plugins.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/responsive.css">

    <!-- Boxed-Layout CSS -->
    <%--<link rel="stylesheet" type="text/css" href="${basePath}/css/boxed.css">
--%>

    <!-- Core Javascript - via CDN -->
    <script type="text/javascript" src="${basePath}/js/jquery.min.js"></script>
    <script>
        function checkAll(obj){
            //获取name=id的复选框
            var boxs = document.getElementsByName("id");
            alert(obj.checked);
            for(var i = 0; i < boxs.length; i++) {
                boxs[i].checked = obj.checked;
            }
        }
    </script>
</head>

<body>
<%@include file="header.jsp" %>

<!-- Start: Main -->
<div id="main">
    <%@include file="sidebar.jsp" %>

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
                            <a href="${basePath}/officer/addClass"
                               class="btn btn-info btn-gradient pull-right"><span
                                    class="glyphicons glyphicon-plus"></span> 添加新班级</a>
                        </div>
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-hover dataTable">
                                <tr class="active">
                                    <th class="text-center">
                                        <input type="Checkbox" onclick="checkAll(this)" id="all" />全选
                                    </th>
                                    <th>序号</th>
                                    <th>班级ID</th>
                                    <th>班级名称</th>
                                    <th>班级人数</th>
                                    <th>班级剩余人数</th>
                                    <th>学习导师</th>
                                    <th>辅导员</th>
                                    <th width="100">操作</th>
                                </tr>
                                <form action="${basePath}/officer/deleteClassesByIds" method="post">
                                    <c:forEach items="${classList}" var="c" varStatus="s">
                                        <tr class="success">
                                            <td class="text-center"><input type="checkbox" value="${c.classId}"
                                                                           name="id" class="cbox"></td>
                                            <td>${s.index+1}</td>
                                            <td>${c.classId}</td>
                                            <td>${c.className}</td>
                                            <td>${c.classSize}</td>
                                            <td>${c.classSurplus}</td>
                                            <td>${c.tutorId}</td>
                                            <td>${c.instructorId}</td>
                                            <td>
                                                <div class="btn-group">
                                                    <%--<a href="findClassByClassId?classId=${class1.classId}"
                                                       class="btn btn-default btn-gradient"><span
                                                            class="glyphicons glyphicon-pencil"></span></a>--%>
                                                    <%-- Restful风格提交请求 --%>
                                                    <a href="${basePath}/officer/findClassByClassId/${c.classId}"
                                                           class="btn btn-default btn-gradient"><span
                                                                class="glyphicons glyphicon-pencil"></span></a>
                                                   <%-- <a onclick="return confirm('确定要删除吗？');"
                                                       href="deleteClassByClassId?classId=${class1.classId}"
                                                       class="btn btn-default btn-gradient dropdown-toggle"><span
                                                            class="glyphicons glyphicon-trash"></span></a>--%>
                                                    <a onclick="return confirm('确定要删除吗？');"
                                                       href="${basePath}/officer/deleteClassByClassId/${c.classId}"
                                                       class="btn btn-default btn-gradient dropdown-toggle"><span
                                                            class="glyphicons glyphicon-trash"></span></a>
                                                </div>

                                            </td>
                                        </tr>
                                    </c:forEach>
                                    <div class="pull-left">
                                        <button type="submit" class="btn btn-default btn-gradient pull-right delall">
                                            <span class="glyphicons glyphicon-trash"></span></button>
                                    </div>
                                </form>
                            </table>


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
    </section>
    <!-- End: Content -->
</div>
<!-- End: Main -->
</body>
</html>