<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增部门信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/employee.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="index.html">首页</a></li>
        <li><a href="addjob.html">部门列表</a></li>
    </ul>
</div>

<div class="formbody ">

    <div class="formtitle"><span>部门列表</span></div>
    <div class="search_box" style="float: left;">

        <div>
            <select name="search_type">
                <option value="1">部门</option>
                <option value="2">部门编号</option>
            </select>
        </div>
        <div style="margin-left: 10px;margin-right: 5px;">
            <input class="input_border" name="key" type="text" placeholder="请输入搜素信息">
        </div>
        <div class="common_button">
            <li class="click"><span><img src="/images/ico06.png"></span>搜索</li>
        </div>
    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th>部门编号<i class="sort"><img src="/images/px.gif"/></i></th>
            <th>部门</th>
            <th>部门描述</th>
            <th width="200">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list page.list as dept>
        <tr>
            <td>${dept.id!}</td>
            <td>${dept.depName!}</td>
            <td>${dept.depDesc!}</td>
            <td><a href="/department/updatedepartment?id=${dept.id}" class="tablelink">修改</a>
                <a class="tablelink" a href="javascript:;" onclick="delete_department(${dept.id})">
                    删除</a></td>
        </tr>
        </#list>
        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue">${page.totalCount}</i>条记录，当前显示第&nbsp;<i class="blue">${page.currentPage}
            &nbsp;</i>页
        </div>
        <ul class="paginList">
            <#if page.currentPage==1>
            <li class="paginItem unavaliable"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <#else>
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
            </#if>

            <#if page.totalPage &gt; 7 >
            <li class="paginItem"><a href="javascript:;" onclick="go('/department/show?page=1')">1</a></li>
            <li class="paginItem current"><a href="javascript:;" onclick="go('/department/show?page=2')">2</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/department/show?page=3')">3</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('//department/show?page=4')">4</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/department/show?page=5')">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;"
                                     onclick="go('/department/show?page=${page.totalPage}')">${page.totalPage}</a></li>
            <#else>
                <#list 1..page.totalPage as i>
                    <#if (i==page.currentPage)>
                    <li class="paginItem"><a href="javascript:;" onclick="go('/department/show?page=${i}')">${i}</a></li>
                    <#else>
                    <li class="paginItem current"><a href="javascript:;" onclick="go('/department/show?page=${i}')">${i}</a></li>
                    </#if>
                </#list>
            </#if>

            <#if page.currentPage==page.totalPage>
            <li class="paginItem unavaliable"><a href="javascript:;"><span class="pagenxt"></span></a></li>
            <#else >
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
            </#if>
        </ul>
    </div>


</div>
</body>
</html>
<script language="JavaScript" src="/js/jquery.js"></script>
<script>
    function delete_department(id) {
        $.ajax({
            dataType: "json",
            url: "/department/delete",
            data: {
                id: id
            },
            type: "POST",
            success: function (result) {
                if (result.code === 200) {
                    window.location.reload(true)
                } else {
                    alert(result.msg)
                }
            }
        })
    }
    function go(url) {
        window.open(url, "_self")
    }
</script>
