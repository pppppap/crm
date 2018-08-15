<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增员工信息</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/career.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="index.html">首页</a></li>
        <li><a href="addjob.html">新增员工</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>员工信息</span></div>

    <table class="career_table">
        <tr>
            <th width="110">姓名</th>
            <th width="50">性别</th>
            <th width="50">年龄</th>
            <th width="200">部门</th>
            <th width="200">职位</th>
            <th width="150">电话</th>
            <th>邮箱</th>
            <th>住址</th>
            <th width="148"></th>
        </tr>

        <#list page.list as i>

        <tr>
            <td>${i.name!}</td>
            <td>${i.sex!}</td>
            <td>${i.age!}</td>
            <td>${i.depId!}</td>
            <td>${i.careerId!}</td>
            <td>${i.tel!}</td>
            <td>${i.email!}</td>
            <td>${i.address!}</td>
            <td>
                <div class="toolbar2">
                    <li class="click"><span><img src="images/t02.png"></span>修改</li>
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
