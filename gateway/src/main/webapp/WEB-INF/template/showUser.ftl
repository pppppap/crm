<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>查看用户信息</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/employee.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="/index">首页</a></li>
        <li><a href="/show_user">用户列表</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>用户信息</span></div>

    <table class="career_table">
        <tr>
            <th width="100">用户名</th>
            <th width="100">用户密码</th>
            <th width="50">员工ID</th>
        </tr>

        <#list page.list as i>

        <tr>
            <td>${i.username!}</td>
            <td>${i.password!}</td>
            <td>${i.employeeId!}</td>
            <td>
                <div class="toolbar2" onclick="get_id(${i.id!})">
                    <li><span><img src="images/t02.png"></span>修改</li>
                </div>
                <div class="toolbar2" onclick="delete_user(${i.id!})">
                    <li><span><img src="images/t03.png"></span>删除</li>
                </div>
            </td>
        </tr>

        </#list>

    </table>

    <div class="pagin">
        <div class="message">共<i class="blue">${page.totalCount}</i>条记录，当前显示第&nbsp;<i class="blue">${page.currentPage}
            &nbsp;</i>页，共<i class="blue">${page.totalPage}</i>页
            <ul class="paginList">
                <li class="paginItem"><a href="javascript:;" onclick=""><span class="pagepre"></span></a></li>
                <li class="paginItem"><a href="javascript:;" onclick=""><span class="pagenxt"></span></a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
<script language="JavaScript" src="js/jquery.js"></script>
<script>
    function get_id(id1) {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/get_id",
            data: {
                id: id1
            }
        })
        window.open("/updateUser", "_self")
    }

    function delete_user(id2) {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/delete_user",
            data: {
                id: id2
            },
            success: function (result) {
                if (result.code === 200) {
                    alert("删除成功")
                } else {
                    alert("删除失败")
                }
                window.location.reload();
            }
        })
    }

    function beforePage(now_page) {
        if ( now_page - 1 > 0) {
            getUserPage(now_page - 1);//拉取数据的方法
        }
        else {
            alert("已经是第一页！");
        }
    }

    function afterPage(now_page,total_page) {
        if (now_page >= total_page) {
            alert("已经是最后一页！");
        }
        else {
            getUserPage(now_page + 1);//拉取数据的方法
        }
    }

    function getUserPage(page) {
        $.ajax({
            type: "get",
            dataType: "json",
            url: "/show_user",
            data: {
                page: page
            }
        })
    }
</script>