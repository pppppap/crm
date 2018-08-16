<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增部门信息</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/department.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li>首页</li>
        <li><a href="/show_department">部门列表</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>部门信息</span></div>

    <table class="department_table">
        <tr>
            <th width="200">部门编号</th>
            <th width="200">部门</th>
            <th width="200">部门描述</th>
            <th width="148"></th>
        </tr>
        <#list page.list as dept>
        <tr>
            <td>${dept.id!}</td>
            <td>${dept.depName!}</td>
            <td>${dept.depDesc!}</td>
            <td>
                <div class="toolbar2">
                    <li class="click"><span><img src="images/t02.png"></span>修改</li>
                </div>
                <div class="toolbar2" onclick="delete_department(${dept.id}) ">
                    <li><span><img src="images/t03.png"></span>删除</li>
                </div>
            </td>
        </tr>
        </#list>
    </table>


</div>
</body>
</html>
<script language="JavaScript" src="js/jquery.js"></script>
<script>
    function delete_department(id) {
        $.ajax({
          dataType:"json",
            url:"/delete_department",
            data:{id: id},
            type:"POST",
            success: function (result) {
                if (result.code === 200) {
                   window.location.reload(true);
                } else {
                    alert(result.msg)
                }
            }
        })
    }

</script>