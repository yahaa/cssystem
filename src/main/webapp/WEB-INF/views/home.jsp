<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课中心</title>
    <meta charset="utf-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <link rel="stylesheet" href="../statics/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../statics/css/style.css" type="text/css">

</head>
<style>
    .table th, .table td {
        text-align: center;
    }
</style>
<body>

<div class="container">
    <!--导航部分 -->
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
                            <span class="glyphicon glyphicon-log-out"></span>
                            退出
                        </a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
    <!--end-->
    <div class="empty-block" style="height: 60px;"></div>

    <!--用户信息 基本操作部分 显示部分-->
    <div class="row">
        <!--基本信息 基本操作-->
        <div class="col-md-2">
            <div class="panel panel-default" style="height: 600px">
                <div class="panel-heading">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-user"/> 个人信息</h3>
                </div>
                <div class="panel-body my-pcenter" id="my-info">
                    <!-- jQuery 成用户基本信息-->
                    <p id="user_id">账号：</p>
                    <p id="user_name">用户名：</p>
                    <p id="user_role">身份：</p>
                </div>
                <div class="panel-heading">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-wrench"/> 基本操作</h3>
                </div>
                <div class="list-group" id="my-operater">
                    <!--jquery 生成用户的操作-->
                </div>
            </div>
        </div>
        <!--end-->
        <!--主显示区-->
        <div class="col-md-10">
            <div class="panel panel-default" style="height: 600px;">
                <div class="panel-heading">
                    <h3 class="panel-title" id="my-time"><span class="glyphicon glyphicon-calendar"/></h3>
                </div>

                <!--welcom-->
                <div class="panel-body my-pcenter hidden" id="welcome">
                    <div class="jumbotron">
                        <h1>选课中心欢迎您</h1>
                        <p style="margin-left: 30px">2016-2017选课开始了！<br>请同学们尽快选课！</p>
                        <p><a class="btn btn-success btn-sm" href="#" role="button">更多</a></p>
                    </div>
                </div>
                <!--end-->

                <!--选课-->
                <div class="panel-body my-pcenter " id="student-opt1">
                    <!--课程搜索-->
                    <div class="row">
                        <div class="col-md-6">
                            <form id="query_course" method="get">
                                <table>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <label class="sr-only" for="my-input1">A</label>
                                                <div class="input-group">
                                                    <div class="input-group-addon"><span
                                                            class="glyphicon glyphicon-flash"></span>
                                                    </div>
                                                    <input type="text" class="form-control" id="my-input1"
                                                           placeholder="课程号" name="courseId">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="form-group" style="margin-left: 10px;">
                                                <label class="sr-only" for="my-input1">A</label>
                                                <div class="input-group">
                                                    <div class="input-group-addon"><span
                                                            class="glyphicon glyphicon-flash"></span>
                                                    </div>
                                                    <input type="text" class="form-control" id="my-input3"
                                                           placeholder="教师号" name="teacherId">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <label class="sr-only" for="my-input2">A</label>
                                                <div class="input-group">
                                                    <div class="input-group-addon"><span
                                                            class="glyphicon glyphicon-ok-sign"></span>
                                                    </div>
                                                    <input type="text" class="form-control" id="my-input2"
                                                           placeholder="课程名" name="courseName">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="form-group" style="margin-left: 10px">
                                                <label class="sr-only" for="my-input2">A</label>
                                                <div class="input-group">
                                                    <div class="input-group-addon"><span
                                                            class="glyphicon glyphicon-ok-sign"></span>
                                                    </div>
                                                    <input type="text" class="form-control" id="my-input4"
                                                           placeholder="教师名" name="teacherName">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <button type="submit"
                                                    class="btn btn-success btn-sm" style="margin:0px 0px 10px 10px">搜索
                                            </button>
                                        </td>
                                    </tr>

                                </table>

                            </form>
                        </div>
                    </div>
                    <!--end-->
                    <!--搜索结果显示-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">搜索结果</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <from id="select_post">
                                                <table class="table table-bordered table-condensed">
                                                    <thead>
                                                    <tr>
                                                        <th>选择</th>
                                                        <th>课程号</th>
                                                        <th>课名</th>
                                                        <th>上课时间</th>
                                                        <th>教师</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <tr>
                                                        <td>a</td>
                                                        <td>b</td>
                                                        <td>c</td>
                                                        <td>d</td>
                                                        <td>e</td>
                                                    </tr>

                                                    <tr>
                                                        <td>a</td>
                                                        <td>b</td>
                                                        <td>c</td>
                                                        <td>d</td>
                                                        <td>e</td>
                                                    </tr>
                                                    <tr>
                                                        <td>e</td>
                                                        <td>e</td>
                                                        <td>e</td>
                                                        <td>e</td>
                                                        <td>e</td>
                                                    </tr>
                                                    <tr>
                                                        <td>e</td>
                                                        <td>e</td>
                                                        <td>e</td>
                                                        <td>e</td>
                                                        <td>e</td>
                                                    </tr>
                                                    <tr>
                                                        <td>e</td>
                                                        <td>e</td>
                                                        <td>e</td>
                                                        <td>e</td>
                                                        <td>e</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </from>
                                            <nav aria-label="...">
                                                <ul class="pagination pagination-sm">
                                                    <li class="disabled">
                                                        <span>
                                                            <span aria-hidden="true">&laquo;</span>
                                                        </span>
                                                    </li>
                                                    <li class="active">
                                                        <span>1 <span class="sr-only">(current)</span></span>
                                                    </li>
                                                    <li>
                                                        <span>2<span></span></span>
                                                    </li>

                                                </ul>
                                            </nav>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--展示结束-->
                    </div>
                    <!--end-->
                </div>
                <!--end-->

                <!--退课-->
                <div class="panel-body my-pcenter hidden" id="student-opt2">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-hover table-condensed table-responsive">
                                <caption>表格说明</caption>
                                <thead id="my-thead2">
                                <tr>
                                    <th>#</th>
                                    <th>账号</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>用户管理</th>
                                    <th>学生管理</th>
                                    <th>教师管理</th>
                                    <th>权限管理</th>
                                    <th>课程管理</th>
                                    <th>选课情况</th>
                                    <th>选课</th>
                                    <th>退课</th>
                                    <th>课表查询</th>
                                </tr>
                                </thead>
                                <tbody id="my-tbody2">
                                <!--ajax 生产-->
                                </tbody>


                            </table>
                        </div>
                    </div>

                </div>
                <!--end-->

                <!--课程表查询-->
                <div class="panel-body my-pcenter hidden" id="student-opt3">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-hover table-condensed table-responsive">
                                <caption>表格说明</caption>
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>账号</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>用户管理</th>
                                    <th>学生管理</th>
                                    <th>教师管理</th>
                                    <th>权限管理</th>
                                    <th>课程管理</th>
                                    <th>选课情况</th>
                                    <th>选课</th>
                                    <th>退课</th>
                                    <th>课表查询</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!--ajax 生产-->
                                </tbody>


                            </table>
                        </div>
                    </div>

                </div>
                <!--end-->

                <!--课程管理-->
                <div class="panel-body my-pcenter hidden" id="teacher-opt1">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-hover table-condensed table-responsive">
                                <caption>表格说明</caption>
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>账号</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>用户管理</th>
                                    <th>学生管理</th>
                                    <th>教师管理</th>
                                    <th>权限管理</th>
                                    <th>课程管理</th>
                                    <th>选课情况</th>
                                    <th>选课</th>
                                    <th>退课</th>
                                    <th>课表查询</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!--ajax 生产-->
                                </tbody>


                            </table>
                        </div>
                    </div>

                </div>
                <!--end-->

                <!--选课情况-->
                <div class="panel-body my-pcenter hidden" id="teacher-opt2">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-hover table-condensed table-responsive">
                                <caption>表格说明</caption>
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>账号</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>用户管理</th>
                                    <th>学生管理</th>
                                    <th>教师管理</th>
                                    <th>权限管理</th>
                                    <th>课程管理</th>
                                    <th>选课情况</th>
                                    <th>选课</th>
                                    <th>退课</th>
                                    <th>课表查询</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!--ajax 生产-->
                                </tbody>


                            </table>
                        </div>
                    </div>

                </div>
                <!--end-->


                <!--学生管理-->
                <div class="panel-body my-pcenter hidden" id="admin-opt1">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-hover table-condensed table-responsive">
                                <caption>表格说明</caption>
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>账号</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>用户管理</th>
                                    <th>学生管理</th>
                                    <th>教师管理</th>
                                    <th>权限管理</th>
                                    <th>课程管理</th>
                                    <th>选课情况</th>
                                    <th>选课</th>
                                    <th>退课</th>
                                    <th>课表查询</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!--ajax 生产-->
                                </tbody>


                            </table>
                        </div>
                    </div>

                </div>
                <!--end-->

                <!--教师管理-->
                <div class="panel-body my-pcenter hidden" id="admin-opt2">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-hover table-condensed table-responsive">
                                <caption>表格说明</caption>
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>账号</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>用户管理</th>
                                    <th>学生管理</th>
                                    <th>教师管理</th>
                                    <th>权限管理</th>
                                    <th>课程管理</th>
                                    <th>选课情况</th>
                                    <th>选课</th>
                                    <th>退课</th>
                                    <th>课表查询</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!--ajax 生产-->
                                </tbody>


                            </table>
                        </div>
                    </div>

                </div>
                <!--end-->

                <!--用户管理-->
                <div class="panel-body my-pcenter hidden" id="admin-opt3">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-hover table-condensed table-responsive">
                                <caption>表格说明</caption>
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>账号</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>用户管理</th>
                                    <th>学生管理</th>
                                    <th>教师管理</th>
                                    <th>权限管理</th>
                                    <th>课程管理</th>
                                    <th>选课情况</th>
                                    <th>选课</th>
                                    <th>退课</th>
                                    <th>课表查询</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!--ajax 生产-->
                                </tbody>


                            </table>
                        </div>
                    </div>

                </div>
                <!--end-->

                <!--权限管理-->
                <div class="panel-body my-pcenter hidden" id="admin-opt4">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-hover table-condensed table-responsive">
                                <caption>表格说明</caption>
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>账号</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>用户管理</th>
                                    <th>学生管理</th>
                                    <th>教师管理</th>
                                    <th>权限管理</th>
                                    <th>课程管理</th>
                                    <th>选课情况</th>
                                    <th>选课</th>
                                    <th>退课</th>
                                    <th>课表查询</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!--ajax 生产-->
                                </tbody>


                            </table>
                        </div>
                    </div>

                </div>
                <!--end-->

                <!--课程管理admin-->
                <div class="panel-body my-pcenter hidden" id="admin-opt5">
                    <div class="row">
                        <div class="col-md-12">
                            <table class="table table-bordered table-hover table-condensed table-responsive">
                                <caption>表格说明</caption>
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>账号</th>
                                    <th>用户名</th>
                                    <th>角色</th>
                                    <th>用户管理</th>
                                    <th>学生管理</th>
                                    <th>教师管理</th>
                                    <th>权限管理</th>
                                    <th>课程管理</th>
                                    <th>选课情况</th>
                                    <th>选课</th>
                                    <th>退课</th>
                                    <th>课表查询</th>
                                </tr>
                                </thead>
                                <tbody id="">
                                <!--ajax 生产-->
                                </tbody>


                            </table>
                        </div>
                    </div>

                </div>
                <!--end-->


            </div>
        </div>
        <!--end-->
    </div>
    <!--end-->


    <!--版权部分 -->
    <div class="row">
        <div class="col-md-12">
            <div style="text-align: center; margin-top: 100px">
                <hr>
                <p>版权所有 &copy 上海大学@<a href="#"> 袁子华</a></p>
            </div>
        </div>
    </div>
    <!--end-->

</div>


</body>
</html>

<script src="../statics/js/jquery-3.1.1.min.js"></script>
<script src="../statics/js/bootstrap.min.js"></script>

<script>
    $(function () {
        $.ajax({
            url: '/home/user_infos',
            type: 'get',
            success: function (data) {
                data = JSON.parse(data);
                $('#user_id').append(data['id']);
                $('#user_name').append(data['name']);
                $('#user_role').append(data['roles'][0].name)
            },
            error: function (data) {
                alert(data);
            }
        })
    });

    $(function () {
        $.ajax({
            url: '/home/user_permits',
            type: 'get',
            success: function (data) {
                var opt = $('#my-operater');
                var cs = '<a href="#" class="list-group-item my-pcenter"></a>';
                data = JSON.parse(data);
                for (var i = 0; i < data.length; i++) {
                    var a = $(cs);
                    a.attr('href', data[i].url);
                    var span = $('<span class="glyphicon glyphicon-cog"></span>');
                    a.append(span).append(' ' + data[i].name);
                    opt.append(a);
                }

            },
            error: function (data) {
                alert(data);
            }
        })

    });

    $(function () {
        $.ajax({
            url: '/m_permit',
            type: 'get',
            success: function (data) {
                data = JSON.parse(data);
                var tbody = $('#my-tbody');
                for (var i = 0; i < 30; i++) {
                    var tr = $('<tr></tr>');
                    var td1 = $('<td>' + i + '</td>');
                    var td2 = $('<td>' + '</td>');

                }
            },
            error: function (data) {
                alter('请求失败 !');
            }
        })

    });

    $(function () {
        $('#my-time').append(" " + new Date().toLocaleDateString());
    });

    $('#query_course').submit(function () {
        $.ajax({
            url: '/home/query_course',
            type: 'get',
            async: false,
            data: $('#query_course').serialize(),
            success: function (data) {
                data = JSON.parse(data);

            },
            error: function (request) {
                alert('error');
            }
        });
    })


</script>

