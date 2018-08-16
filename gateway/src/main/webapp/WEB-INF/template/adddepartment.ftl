<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增部门信息</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li>首页</li>
        <li><a href="/add_department">新增部门</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>部门信息</span></div>

    <ul class="forminfo">
        <li><label>部门编号</label><input name="dep_id" type="text" class="dfinput"/>
            <i class="required">*</i>
        </li>
        <li><label>部门</label><input name="dep_name" type="text" class="dfinput"/>
            <i class="required">*</i>
        </li>
        <li><label>部门描述</label><input name="dep_desc" type="text" class="dfinput"/>
            <i class="required">*</i></li>

        <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认新增"/></li>
    </ul>


</div>
</body>
</html>
