<%@ page language="java" pageEncoding="UTF-8"%>
		<aside id="sidebar" class="affix">
			<div id="sidebar-search"></div>
			<div id="sidebar-menu">
				<ul class="nav sidebar-nav">
					<li><a href="${baseurl}"><span
							class="glyphicons glyphicon-home"></span><span
							class="sidebar-title">后台首页</span></a></li>
					<li><a href="${baseurl}/freshman/freshmanUpdate?ticketNumber=${USER_SESSION.getAccount()}"><span
							class="glyphicons glyphicon-home"></span><span
							class="sidebar-title">查看和修改个人信息</span></a></li>
					<li><a href="news_list.html"><span
							class="glyphicons glyphicon-file"></span><span
							class="sidebar-title">查看宿舍分配情况</span></a></li>
					<li><a href="${baseurl}/toMajorAll"><span
							class="glyphicons glyphicon-paperclip"></span><span
							class="sidebar-title">查看缴费情况</span></a></li>
					<li><a href="${baseurl}/freshman/toUpload"><span
<%--					<li><a href="${baseurl}/freshman/toUpload?ticketNumber=${USER_SESSION.getAccount()}"><span--%>
							class="glyphicons glyphicon-credit-card"></span><span
							class="sidebar-title">新生证件上传</span></a></li>

					<li><a href="${baseurl}/freshman/toDownloadReport"><span
							class="glyphicons glyphicon-credit-card"></span><span
							class="sidebar-title">新生报道单</span></a></li>
<%--					<li><a href="${baseurl}/toAllUsers"><span--%>
<%--							class="glyphicons glyphicon-paperclip"></span><span--%>
<%--							class="sidebar-title">用户管理</span></a></li>--%>
				</ul>
			</div>
		</aside>