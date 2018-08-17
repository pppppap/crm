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

    <table class="tablelist">
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
            &nbsp;</i>页
        </div>
        <ul class="paginList">
            <#if page.currentPage==1>
            <li class="paginItem unavaliable"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <#else>
            <li class="paginItem"><a href="javascript:;" onclick="beforePage(${page.currentPage})"><span class="pagepre"></span></a></li>
            </#if>

            <#if page.totalPage &gt; 7 >
            <li class="paginItem"><a href="javascript:;" onclick="go('/userPage?page=1')">1</a></li>
            <li class="paginItem current"><a href="javascript:;" onclick="go('/userPage?page=2')">2</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/userPage?page=3')">3</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/userPage?page=4')">4</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/userPage?page=5')">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;"
                                     onclick="go('/userPage?page=${page.totalPage}')">${page.totalPage}</a></li>
            <#else>
                <#list 1..page.totalPage as i>
                    <#if (i==page.currentPage)>
                    <li class="paginItem"><a href="javascript:;" onclick="go('/userPage?page=${i}')">${i}</a></li>
                    <#else>
                    <li class="paginItem current"><a href="javascript:;" onclick="go('/userPage?page=${i}')">${i}</a></li>
                    </#if>
                </#list>
            </#if>

            <#if page.currentPage==page.totalPage>
            <li class="paginItem unavaliable"><a href="javascript:;"><span class="pagenxt"></span></a></li>
            <#else >
            <li class="paginItem"><a href="javascript:;" onclick="afterPage(${page.currentPage},${page.totalPage})"><span class="pagenxt"></span></a></li>
            </#if>
        </ul>
    </div>
</div>
</body>
</html>
<script language="JavaScript" src="js/jquery.js"></script>
<script>
    function go(url) {
        window.open(url, "_self")
    }

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
            go("/userPage?page="+(now_page - 1));//拉取数据的方法
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
            go("/userPage?page="+(now_page + 1));//拉取数据的方法
        }
    }
</script>