<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>修改员工信息</title>
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
    <form action="/employee/do_update" method="post" id="update_employee">
        <#escape x as x!"">
            <ul class="forminfo">
                <li><label>员工编号</label><input name="id" type="text" class="dfinput" value="${employee.id!?c}" readonly/>
                </li>
                <li><label>员工姓名</label><input name="name" type="text" class="dfinput" value="${employee.name!}"/><i
                        class="required">*</i></li>
                <li>
                    <label>部门</label>
                    <select name="depId">
                        <#list departments! as i>
                            <#if employee.department.id=i.id>
                                <option value="${i.id?c}" selected>${i.depName}</option>
                            <#else >
                                <option value="${i.id?c}">${i.depName}</option>
                            </#if>
                        </#list>
                    </select>
                    <i style="color: red;">*</i>
                </li>
                <li>
                    <label>职位</label>
                    <select name="careeId">
                        <#list careers as i>
                            <#if employee.career.id=i.id>
                       <option value="${i.id?c}" selected>${i.careerName!}</option>
                            <#else >
                       <option value="${i.id?c}">${i.careerName!}</option>
                            </#if>
                        </#list>
                    </select>
                    <i class="required">*</i>
                </li>
                <li>
                    <label>性别</label>
                    <select name="sex">
                         <#if sex?? && sex=='男'>
                             <option value="男" selected>&nbsp;&nbsp;男&nbsp;</option>
                             <option value="女">&nbsp;&nbsp;女&nbsp;</option>
                         <#else>
                            <option value="男">&nbsp;&nbsp;男&nbsp;</option>
                            <option value="女" selected>&nbsp;&nbsp;女&nbsp;</option>
                         </#if>
                    </select>
                    <i class="required">*</i>
                </li>
                <li><label>年龄</label><input name="age" type="text" class="dfinput" value="${employee.age}"/><i>输入整数</i>
                </li>
                <li><label>电话</label><input name="tel" type="text" class="dfinput" value="${employee.tel}"/></li>
                <li><label>邮箱</label><input name="email" type="text" class="dfinput" value="${employee.email}"/></li>
                <li><label>住址</label><input name="address" type="text" class="dfinput" value="${employee.address}"/>
                </li>
                <li>
                    <label>&nbsp;</label>
                    <input type="button" class="btn" value="修改" onclick="update_employee()"/>
                    <input type="button" class="btn" value="返回" onclick="window.open('${back_uri}','_self')"/>
                </li>
            </ul>
        </#escape>
    </form>
</div>
</body>
</html>
<script language="JavaScript" src="/js/jquery.js"></script>
<script>
    function update_employee() {
        $.ajax({
            dataType: "json",
            url: "/employee/do_update",
            data: $('#update_employee').serialize(),
            type: "post",
            success: function (result) {
                if (result.code === 200) {
                    alert("修改成功！")
                    window.open("${back_uri}", "_self");
                } else {
                    alert("修改失败！")
                }
            }
        })
    }
</script>
