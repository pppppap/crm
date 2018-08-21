<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增用户信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="/index">首页</a></li>
        <li><a href="/user/addUser">新增用户</a></li>
    </ul>
</div>

<div class="formbody">
    <div class="formtitle"><span>用户信息</span></div>
    <ul class="forminfo">
        <form id="addUser" action="##" method="post">
            <li><label>用户名</label><input id="username" name="username" type="text" class="dfinput"/><i class="required">*</i></li>
            <li><label>用户密码</label><input id="password" name="password" type="text" class="dfinput"/><i class="required">*</i></li>
            <li><label>员工姓名</label><input id="empName" name="empName" type="text" class="dfinput"/><i class="required">*</i></li>
            <li><label>&nbsp;</label><input type="button" class="btn" value="确认新增" onclick="add_user()"/></li>
        </form>
    </ul>
</div>
</body>
</html>
<script language="JavaScript" src="/js/jquery.js"></script>
<script>
    function add_user() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/user/add_user",
            data: $('#addUser').serialize(),
            success: function (result) {
                if (result.code === 200) {
                    alert(result.msg)
                    window.location.reload();
                } else {
                    alert(result.msg)
                }
            }
        })
    }
</script>