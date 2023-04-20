<%@ page language="java" pageEncoding="UTF-8" %>
<section id="content">
        <div id="topbar" class="affix">
            <ol class="breadcrumb">
                <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            </ol>
        </div>
        <div class="container">


            <div class="col-md-11">
                <div id="docs-content">
                    <h2 class="page-header margin-top-none">个人信息-管理员</h2>
                    <table class="table">
                        <tr>
                            <td colspan="2">您好，管理员${USER_SESSION.getAccount()}</td>
                        </tr>
                        <tr>
                            <td width="120">最后登录时间:</td>
                            <td>2021-04-15 13：20</td>
                        </tr>
                        <tr>
                            <td>最后登录IP:</td>
                            <td>127.0.0.1</td>
                        </tr>
                    </table>

                    <h2 class="page-header margin-top-none">系统信息</h2>
                    <table class="table">
                        <tr>
                            <td width="100">操作系统：</td>
                            <td>Windows 10</td>
                        </tr>
                        <tr>
                            <td>IDEA版本:</td>
                            <td>2020.2.1</td>
                        </tr>
                        <tr>
                            <td>MySQL 版本:</td>
                            <td>5.1.49</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </section>
