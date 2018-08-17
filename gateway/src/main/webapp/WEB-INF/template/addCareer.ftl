<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增职位信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="/index">首页</a></li>
        <li><a href="/addjob.html">新增职位</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>职位信息</span></div>

    <ul class="forminfo">
        <form id="addcareer" action="##" method="post" >
        <li><label>职位编号</label><input id="career_id" name="career_id" type="text" class="dfinput"/><i class="required">*</i></li>
        <li><label>职位名称</label><input id="career_name"name="career_name" type="text" class="dfinput"/><i class="required">*</i></li>
        <#--<li>-->
            <#--<label>所属部门</label>-->
            <#--<select>-->
                <#--<option value="1">人事部门</option>-->
                <#--<option value="2">财务部门</option>-->
                <#--<option value="3">采购部门</option>-->
                <#--<option value="4">销售部门</option>-->
            <#--</select>-->
            <#--<i style="color: red;">*</i>-->
        <#--</li>-->
        <li><label>职位描述</label>
            <input id="career_desc" name="career_desc" type="text" class="dfinput"/>
        </li>
        <li><label>&nbsp;</label><input   onclick="add_career()" name="" type="button" class="btn" value="确认新增"/></li>
        </form>

    </ul>

</div>
</body>
</html>
<script language="JavaScript" src="/js/jquery.js"></script>
<script>
    function add_career() {

        $.ajax({
            dataType:"json",
            url:"/career/add_career",
            data:$('#addcareer').serialize(),
            type: "post",
            success: function (result) {
                    if (result.code === 200) {
                        alert("添加成功！")
                    } else {
                        alert("添加失败！")
                    }
                    window.location.href="/career/show_career.ftl";
                }
        })
    }
</script>