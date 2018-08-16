<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增员工信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/employee.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="index.html">首页</a></li>
        <li><a href="addjob.html">修改员工信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>员工信息</span></div>
    <form id="update_form" method="post">
        <ul class="forminfo">
            <input type="hidden" value="${(employee.id)}" name="id">
            <li><label>员工姓名</label><input name="name" type="text" class="dfinput" value="${(employee.name)!}"/><i
                    class="required">*</i></li>
            <li>
                <label>部门</label>
                <select name="depId">
                    <#list departments as i>
                        <#if i.id==(employee.department.id)!>
                            <option value="${i.id}" selected>${i.depName}</option>
                        <#else >
                            <option value="${i.id}">${i.depName}</option>
                        </#if>
                    </#list>
                </select>
                <i style="color: red;">*</i>
            </li>
            <li>
                <label>职位</label>
                <select name="careerId">
                    <#list careers as i>
                        <#if employee.career.id==i.id>
                            <option value="${i.id}" selected>${i.careerName}</option>
                        <#else >
                            <option value="${i.id}">${i.careerName}</option>
                        </#if>
                    </#list>
                </select>
                <i class="required">*</i>
            </li>
            <li>
                <label>性别</label>
                <select name="sex">
                    <#if '男'==(employee.sex)!>
                        <option value="男" selected>&nbsp;&nbsp;男&nbsp;</option>
                        <option value="女">&nbsp;&nbsp;女&nbsp;</option>
                    <#else >
                        <option value="男">&nbsp;&nbsp;男&nbsp;</option>
                        <option value="女" selected>&nbsp;&nbsp;女&nbsp;</option>
                    </#if>

                </select>
                <i class="required">*</i>
            </li>
            <li><label>年龄</label><input name="age" type="text" class="dfinput" style="width: 100px;"
                                        value="${(employee.age)!}"/><i>输入整数</i>
            </li>
            <li><label>电话</label><input name="tel" type="text" class="dfinput" value="${(employee.tel)!}"/></li>
            <li><label>邮箱</label><input name="email" type="text" class="dfinput" value="${(employee.email)!}"/></li>
            <li><label>住址</label><input name="address" type="text" class="dfinput" value="${(employee.address)!}"/></li>
            <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认修改" onclick="mysubmit()"/></li>
        </ul>
    </form>

</div>
</body>
</html>
<script language="JavaScript" src="/js/jquery.js"></script>
<script>
    function mysubmit() {
        $.ajax({
            dataType: "json",
            type: "post",
            url: "/employee/do_update",
            data: $("#update_form").serialize(),
            success: function (result) {
                if (result.code === 200) {
                    alert("保存成功")
                    window.open("/employee/show","_self")
                } else {
                    alert("保存失败")
                }
            }
        })
    }
</script>
