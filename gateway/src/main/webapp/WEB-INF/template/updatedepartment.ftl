<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>修改部门信息</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="/index">首页</a></li>
        <li><a href="/add_department">新增部门</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>部门信息</span></div>

    <ul class="forminfo">
        <li><label>部门编号</label><input name="dep_id" type="text" class="dfinput" value="${department.id!}"/>
            <i class="required">*</i>
        </li>
        <li>
        <li><label>部门</label><input name="dep_name" type="text" class="dfinput" value="${department.depName!}"/>

            <i style="color: red;">*</i>
        </li>

        <li><label>部门描述</label><input name="dep_desc" type="text" class="dfinput" value="${department.depDesc!}"/>

            <i style="color: red;">*</i>
        </li>

        <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认修改"/></li>
    </ul>


</div>
</body>
</html>
