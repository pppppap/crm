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
        <li><a href="/addjob.html">职位修改</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>职位修改</span></div>

    <ul class="forminfo">
        <form id="update_career" action="##" method="post" >
            <#--<li><label>职位编号</label><input id="career_id" name="career_id" type="text" class="dfinput"/><i class="required">*</i></li>-->
            <li><label>职位名称</label><input id="career_name"name="career_name" type="text" class="dfinput"/></li>
            <li><label>职位描述</label><input id="career_desc" name="career_desc" type="text" class="dfinput"/></li>
            <li><label>&nbsp;</label><input   onclick="updatecareer()" name="" type="button" class="btn" value="确认修改"/></li>
        </form>
    </ul>
</div>
</body>
</html>
<script language="JavaScript" src="/js/jquery.js"></script>
<script>
    function updatecareer() {
        $.ajax({
            dataType:"json",
            url:"/career/update_career",
            data:$('#update_career').serialize(),
            type: "post",
            success: function (result) {
                if (result.code === 200) {
                    alert("修改成功！")
                } else {
                    alert("修改失败！")
                }
                window.open("/career/show_career","_self");
            }
        })
    }
</script>