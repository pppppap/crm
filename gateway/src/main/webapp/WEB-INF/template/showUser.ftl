<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>查看用户信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/employee.css" rel="stylesheet" type="text/css"/>
    <link href="/css/panel.css" rel="stylesheet" type="text/css"/>
</head>
<style>
    .panel .formbody {
        position: absolute;
        top: 50%;
        left: 50%;
        width: 450px;
        height: 300px;
        margin-top: -225px;
        margin-left: -150px;
        background: #FFF;
    }
</style>
<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="/index">首页</a></li>
        <li><a href="/user/show_user">用户列表</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="search_box" style="float: left;">
        <div>
            <select name="search_type">
                <option value="1">用户名</option>
                <option value="2">员工ID</option>
            </select>
        </div>
        <div style="margin-left: 10px;margin-right: 5px;">
            <input class="input_border" name="key" type="text" placeholder="请输入搜素信息">
        </div>
        <div class="common_button" onclick="">
            <li class="click"><span><img src="/images/ico06.png"></span>搜索</li>
        </div>
        <div class="tools" style="display: inline-block;float: none;">
            <ul class="toolbar">
                <li onclick="$('.panel').show();"><span><img src="/images/t01.png"/></span>添加</li>
            </ul>
        </div>
    </div>

    <table class="tablelist">
        <tr>
            <th width="80">用户ID</th>
            <th>用户名</th>
            <th>用户密码</th>
            <th>员工ID</th>
            <th width="100">操作</th>
        </tr>

        <#list page.list as i>

        <tr>
            <td>${i.id!?c}</td>
            <td>${i.username!}</td>
            <td>${i.password!}</td>
            <td>${i.employeeId!?c}</td>

            <td>
                <a href="/user/updateUser?id=${i.id?c}&username=${i.username}" class="tablelink">修改</a>
                <a class="tablelink" href="javascript:" onclick="delete_user(${i.id!?c})">删除</a>
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
            <li class="paginItem"><a href="javascript:;"><span class="pagepre2"></span></a></li>
            <#else>
            <li class="paginItem"><a href="/user/userPage?page=${page.currentPage-1}"><span
                    class="pagepre"></span></a></li>
            </#if>

            <#if page.totalPage &gt; 7 >
            <li class="paginItem"><a href="/user/userPage?page=1">1</a></li>
            <li class="paginItem current"><a href="/user/userPage?page=2">2</a></li>
            <li class="paginItem"><a href="/user/userPage?page=3">3</a></li>
            <li class="paginItem"><a href="/user/userPage?page=4">4</a></li>
            <li class="paginItem"><a href="/user/userPage?page=5">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="/user/userPage?page=${page.totalPage}">${page.totalPage}</a></li>
            <#else>
                <#list 1..page.totalPage as i>
                    <#if (i==page.currentPage)>
                    <li class="paginItem current"><a href="/user/userPage?page=${i}">${i}</a>
                    </li>
                    <#else>
                    <li class="paginItem "><a href="/user/userPage?page=${i}">${i}</a></li>
                    </#if>
                </#list>
            </#if>

            <#if page.currentPage==page.totalPage>
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt2"></span></a></li>
            <#else >
            <li class="paginItem"><a href="/user/userPage?page=${page.currentPage+1}"><span
                    class="pagenxt"></span></a></li>
            </#if>
        </ul>
    </div>

</div>

<div class="panel" style="display: none;">
    <div class="formbody">
        <div class="formtitle"><span>用户信息</span></div>
        <ul class="forminfo">
            <form id="addUser">
                <li><label>用户名</label><input name="username" type="text" class="dfinput"/><i class="required">*</i></li>
                <li><label>用户密码</label><input name="password" type="text" class="dfinput"/><i class="required">*</i>
                </li>
                <li><label>员工ID</label><input name="empId" type="text" class="dfinput"/><i class="required">*</i></li>
                <li>
                    <label>&nbsp;</label>
                    <input type="button" class="btn" value="确认新增" onclick="add_user()"/>
                    <input type="button" class="btn" value="关闭" onclick="$('.panel').hide();"/>
                </li>
            </form>
        </ul>
    </div>
</div>
</body>
</html>
<script language="JavaScript" src="/js/jquery.js"></script>
<script>

    var delete_id = -1;
    $(document).ready(function () {
        $("#delete_click").click(function () {
            $(".tip").fadeIn(200);
        });

        $(".tiptop a").click(function () {
            $(".tip").fadeOut(200);
        });

        $(".sure").click(function () {
            do_delete()
            $(".tip").fadeOut(100);
        });

        $(".cancel").click(function () {
            $(".tip").fadeOut(100);
        });

    });

    function add_user() {
        $.ajax({
            type: "post",
            dataType: "json",
            url: "/user/add_user",
            data: $('#addUser').serialize(),
            success: function (result) {
                if (result.code === 200) {
                    alert("新增成功")
                    window.location.reload();
                } else {
                    alert("新增失败")
                }
            }
        })
    }

    function delete_user(id2) {
        delete_id = id2
        $(".tip").fadeIn(200);
    }

    function do_delete() {
        if (delete_id !== -1) {
            $.ajax({
                type: "post",
                dataType: "json",
                url: "/user/delete_user",
                data: {
                    id: delete_id
                },
                success: function (result) {
                    if (result.code === 200) {
                        alert("删除成功")
                        window.location.reload();
                    } else {
                        alert("删除失败")
                    }
                }
            })
            delete_id = -1
        }
    }
</script>