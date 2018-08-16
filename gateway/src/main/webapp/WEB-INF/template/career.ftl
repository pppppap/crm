<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增员工信息</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/employee.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="index.html">首页</a></li>
        <li><a href="addjob.html">职业信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>职业信息</span></div>

    <table class="career_table">
        <tr>
            <th width="100">职位编号</th>
            <th width="100">职位名称</th>
            <th width="500">职位描述</th>
            <th width="100"></th>
        </tr>
        <#list page.list as i>
            <tr>
                <td>${i.id!}</td>
                <td>${i.careerName!}</td>
                <td>${i.careerDesc!}</td>
                <td>
                    <div class="toolbar2" onclick="careerId(${i.id!})">
                        <li><span><img src="images/t02.png"></span>修改</li>
                    </div>
                    <div class="toolbar2" onclick="delete_career(${i.id!})">
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
        function delete_career(id){
            $.ajax({
                dataType:"json",
                url:"/delete_career",
                data:{ id:id },
                type:"post",
                success: function (result) {
                    if(result.code ===200){
                        alert("删除成功！")
                    }else{
                        alert("删除失败！")
                    }
                    window.location.reload();
                }
            })
        }
        function careerId(id) {
            $.ajax({
                dataType:"json",
                url:"/careerId",
                data:{careerId:id},
                type:"post",
            })
            window.open("/updateCareer","_self")
        }
    </script>