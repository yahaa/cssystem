<%--
  Created by IntelliJ IDEA.
  User: zihua
  Date: 17-1-23
  Time: 下午6:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生选课系统</title>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <link rel="stylesheet" href="../statics/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../statics/css/style.css" type="text/css">
</head>
<style>
    body {
        background: url("../statics/img/cssbg.jpg") 70% 75% no-repeat;
    }
</style>
<body background="">
<div class="container">
    <div class="row">
        <div class="navbar  navbar-fixed-top nav-color"
             style="background-color: rgba(253, 253, 253, 0.21);border-color: rgba(126, 174, 129, 0.39);">
            <div class="nav-center">
                <ul class="nav navbar-nav">
                    <li>
                        <div class="logo">
                            <a href="#">
                                <img alt="Logo" id="logo-header" src="../statics/img/logo.jpg"/>
                            </a>
                        </div>
                    </li>
                    <li>
                        <a href="#">
                            <span class="glyphicon glyphicon-education"></span>
                            选课中心
                        </a>
                    </li>
                </ul>

                <ul class="pull-right nav navbar-nav">
                    <li>
                        <a class="login-btn" href="#">
                            <span class="glyphicon glyphicon-user"></span>
                             登录
                        </a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
    <div class="empty-block" style="height: 60px;"></div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div style="margin: 120px">
                <div class="row">
                    <div class="col-md-12" style="color: Red; font-size: 26px; text-align: center;">
                        <span class="glyphicon glyphicon-education"/> 2016-2017 学年冬季学期选课中心
                    </div>
                </div>
                <div class="row" style="margin-top: 60px">

                    <div class="col-md-10 col-md-offset-2">
                        <form class="form-horizontal" action="/login" method="post">
                            <div class="form-group">
                                <label for="inputname" class="col-md-2 control-label">
                                    <span class="glyphicon glyphicon-user" style="font-size: 20px"/></label>
                                <div class="col-md-7">
                                    <input type="text" class="form-control" id="inputname" placeholder="学号（工号）"
                                           name="userId">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-md-2 control-label">
                                    <span class="glyphicon glyphicon-send" style="font-size: 20px"/>
                                </label>
                                <div class="col-md-7">
                                    <input type="password" class="form-control" id="inputPassword3"
                                           placeholder="密码" name="password">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-2 col-md-offset-7">
                                    <button type="submit" class="btn btn-success btn-sm"> 登录</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div style="text-align: center; margin-top: 50px">
                <hr>
                    <p>版权所有 &copy 上海大学@<a href="#"> 袁子华</a></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script src="../statics/js/jquery-3.1.1.min.js"></script>
<script src="../statics/js/bootstrap.min.js"></script>


