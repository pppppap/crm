<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>修改部门信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="/index">首页</a></li>
        <li><a href="/department/adddepartment">新增部门</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>部门信息</span></div>
    <form action="/department/submitupdation">
        <ul class="forminfo">
            <li><label>部门编号</label><input name="id" type="text" class="dfinput" value="${department.id!}"
                                          readonly="true"/>
                <i class="required">*</i>
            </li>
            <li>
            <li><label>部门</label><input name="depName" type="text" class="dfinput" value="${department.depName!}"/>

                <i style="color: red;">*</i>
            </li>

            <li><label>部门描述</label><input name="depDesc" type="text" class="dfinput" value="${department.depDesc!}"/>

                <i style="color: red;">*</i>
            </li>

            <li>
                <label>&nbsp;</label>
                <input name="" type="submit" class="btn" value="修改" "/>
                <a href="/department/show">
                    <input type="button" class="btn" value="返回" "/>
                </a>
            </li>
        </ul>
    </form>

</div>
</body>
</html>


