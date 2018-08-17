<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>修改用户信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="/index">首页</a></li>
        <li><a>修改用户</a></li>
    </ul>
</div>

<div class="formbody">
    <div class="formtitle"><span>用户信息</span></div>
    <ul class="forminfo">
        <form id="updateUser" action="##" method="post">
            <li><label>用户ID</label><input id="id" name="id" type="text" class="dfinput" value="${userId}" readonly="readonly"/></li>
            <li><label>用户名</label><input id="username" name="username" type="text" class="dfinput" value="${username}" readonly="readonly"/></li>
            <li><label>用户密码</label><input id="password" name="password" type="text" class="dfinput"/></li>
            <li><label>员工ID</label><input id="empId" name="empId" type="text" class="dfinput"/></li>
            <li><label>&nbsp;</label><input type="button" class="btn" value="确认修改" onclick="update_user()"/></li>
        </form>
    </ul>
</div>
</body>
</html>
<script language="JavaScript" src="/js/jquery.js"></script>
<script>
    function update_user() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/user/update_user",
            data: $('#updateUser').serialize(),
        success: function (result) {
            if (result.code === 200) {
                alert("修改成功")
            } else {
                alert("修改失败")
            }
            window.open("/user/show_user", "_self")
        }
    })
    }
</script>