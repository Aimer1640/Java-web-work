<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>

<header class="navbar navbar-fixed-top" style="background-image: none; background-color: rgb(240, 240, 240);">
    <div class="pull-left">
    <a class="navbar-brand" href="#">
        <div class="navbar-logo">
            <img src="${basePath}/images/logo.png" alt="logo">
        </div>
    </a>
    </div>
    <div class="pull-right header-btns">
        <a class="user"><span class="glyphicons glyphicon-user"></span>${USER_SESSION.account}</a>
        <a href="${basePath}/logout" class="btn btn-default btn-gradient" type="button"><span
                class="glyphicons glyphicon-log-out"></span> 退出</a>
    </div>
</header>