<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增部门信息</title>
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
        <li><a href="index.html">首页</a></li>
        <li><a href="addjob.html">部门列表</a></li>
    </ul>
</div>

<div class="formbody ">
    <div class="tools" style="display: inline-block;float: none;">
        <ul class="toolbar">
            <li onclick="$('.panel').show();"><span><img src="/images/t01.png"/></span>添加</li>
        </ul>
    </div>

    <table class="tablelist">
        <thead>
        <tr>
            <th>部门编号<i class="sort"><img src="/images/px.gif"/></i></th>
            <th>部门名称</th>
            <th>部门描述</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list page.list as dept>
            <#if dept_index%2==1>
                    <tr class="odd">
            <#else>
                    <tr>
            </#if>
            <td>${dept.id!}</td>
            <td>${dept.depName!}</td>
            <td>${dept.depDesc!}</td>
            <td><a href="/department/updatedepartment?id=${dept.id}" class="tablelink">修改</a>
                <a class="tablelink" href="javascript:" onclick="delete_department(${dept.id})">
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
            <li class="paginItem"><a href="javascript:;"><span class="pagepre2"></span></a></li>
            <#else>
            <li class="paginItem"><a href="/department/show?page=${page.currentPage-1}"><span
                    class="pagepre"></span></a></li>
            </#if>

            <#if page.totalPage &gt; 7 >
            <li class="paginItem"><a href="/department/show?page=1">1</a></li>
            <li class="paginItem current"><a href="/department/show?page=2">2</a></li>
            <li class="paginItem"><a href="/department/show?page=3">3</a></li>
            <li class="paginItem"><a href="department/show?page=4">4</a></li>
            <li class="paginItem"><a href="/department/show?page=5">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="/department/show?page=${page.totalPage}">${page.totalPage}</a></li>
            <#else>
                <#list 1..page.totalPage as i>
                    <#if (i==page.currentPage)>
                    <li class="paginItem current"><a href="/department/show?page=${i}">${i}</a>
                    </li>
                    <#else>
                    <li class="paginItem "><a href="/department/show?page=${i}">${i}</a></li>
                    </#if>
                </#list>
            </#if>

            <#if page.currentPage==page.totalPage>
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt2"></span></a></li>
            <#else >
            <li class="paginItem"><a href="/department/show?page=${page.currentPage+1}"><span
                    class="pagenxt"></span></a></li>
            </#if>
        </ul>
    </div>
    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="/images/ticon.png"/></span>
            <div class="tipright">
                <p>是否确认删除 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button" class="sure" value="确定"/>&nbsp;
            <input name="" type="button" class="cancel" value="取消"/>
        </div>
    </div>

</div>
<div class="panel" style="display: none;">
    <div class="formbody">
        <div class="formtitle"><span>部门信息</span></div>
        <form action="/department/add" method="post">
            <ul class="forminfo">
                <li><label>部门编号</label><input name="id" type="text" class="dfinput"/>
                    <i class="required">*</i>
                </li>
                <li><label>部门</label><input name="depName" type="text" class="dfinput"/>
                    <i class="required">*</i>
                </li>
                <li><label>部门描述</label><input name="depDesc" type="text" class="dfinput"/>
                </li>

                <li>
                    <label>&nbsp;</label>
                    <input type="submit" class="btn" value="新增"/>
                    <input type="button" class="btn" value="关闭" onclick="$('.panel').hide();"/>
                </li>
            </ul>
        </form>
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

    function delete_department(id) {
        delete_id = id
        $(".tip").fadeIn(200);
    }

    function do_delete() {
        if (delete_id !== -1) {
            $.ajax({
                dataType: "json",
                url: "/department/delete",
                data: {
                    id: delete_id
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
            delete_id = -1
        }
    }
</script>
