<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>查看用户信息</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/employee.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="/index">首页</a></li>
        <li><a href="/show_user">用户列表</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>用户信息</span></div>

    <table class="career_table">
        <tr>
            <th width="100">用户名</th>
            <th width="100">用户密码</th>
            <th width="50">员工ID</th>
        </tr>

        <#list page.list as i>

        <tr>
            <td>${i.username!}</td>
            <td>${i.password!}</td>
            <td>${i.employeeId!}</td>
            <td>
                <div class="toolbar2">
                    <li><span><img src="images/t02.png"></span>修改</li>
                </div>
                <div class="toolbar2">
                    <li><span><img src="images/t03.png"></span>删除</li>
                </div>
            </td>
        </tr>

        </#list>

    </table>

</div>
</body>
</html>