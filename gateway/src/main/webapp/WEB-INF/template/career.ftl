<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增员工信息</title>
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
        height: 250px;
        margin-top: -125px;
        margin-left: -225px;
        background: #FFF;
    }
</style>
<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="/index">首页</a></li>
        <li><a href="/career/show_career">职位信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="tools" style="display: inline-block;float: none;">
        <ul class="toolbar">
            <li onclick="$('.panel').show();"><span><img src="/images/t01.png"/></span>添加</li>
        </ul>
    </div>

    <table class="tablelist">
        <thead>
        <tr>
            <th width="80">职位编号</th>
            <th>职位名称</th>
            <th>职位描述</th>
            <th width="100">操作</th>
        </tr>
        </thead>
    <tbody>
        <#list page.list as i>
            <#if i_index%2==1>
                <tr class="odd">
            <#else>
                <tr>
            </#if>
            <td>${i.id!?c}</td>
            <td>${i.careerName!}</td>
            <td>${i.careerDesc!}</td>
            <td><a href="/employee/update?id=${i.id?c}" class="tablelink">修改</a>
                <a class="tablelink" href="javascript:" onclick="delete_career('${i.id?c}')">删除</a>
            </td>
        </tr>
        </tbody>
        </#list>
    </table>

<#--分页-->
    <div class="pagin">
        <#escape x as x!"">
            <div class="message">共<i class="blue">${page.totalCount}</i>条记录，当前显示第&nbsp;<i
                    class="blue">${page.currentPage}
                &nbsp;</i>页
            </div>
            <ul class="paginList">
            <#if page.currentPage==1>
            <li class="paginItem"><a href="javascript:"><span class="pagepre2"></a></span></li>
            <#else>
            <li class="paginItem"><a href="/career/show_career?page=${page.currentPage-1}"><span
                    class="pagepre"></span></a></li>
            </#if>

            <#if page.totalPage &gt; 7 >
            <li class="paginItem"><a href="/career/show_career?page=1">1</a></li>
            <li class="paginItem current"><a href="/career/show_career?page=2">2</a></li>
            <li class="paginItem"><a href="/career/show_career?page=3">3</a></li>
            <li class="paginItem"><a href="/career/show_career?page=4">4</a></li>
            <li class="paginItem"><a href="/career/show_career?page=5">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="/career/show_career?page=${page.totalPage}">${page.totalPage}</a>
            </li>
            <#else>
                <#list 1..page.totalPage as i>
                    <#if (i==page.currentPage)>
                    <li class="paginItem current"><a href="/career/show_career?page=${i}">${i}</a>
                    </li>
                    <#else>
                    <li class="paginItem "><a href="/career/show_career?page=${i}">${i}</a></li>
                    </#if>
                </#list>
            </#if>

            <#if page.currentPage==page.totalPage>
            <li class="paginItem"><a href="javascript:"><span class="pagenxt2"></a></span></li>
            <#else >
            <li class="paginItem"><a href="/career/show_career?page=${page.currentPage+1}"><span
                    class="pagenxt"></span></a></li>
            </#if>
            </ul>
        </#escape>
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
            <input type="button" class="sure" value="确定"/>&nbsp;
            <input type="button" class="cancel" value="取消"/>
        </div>

    </div>
</div>
<div class="panel" style="display: none;">
    <div class="formbody">
        <div class="formtitle"><span>职位信息</span></div>
        <ul class="forminfo">
            <form id="add_career">
                <li><label>职位名称</label><input name="careerName" type="text" class="dfinput"/></li>
                <li><label>职位描述</label><input name="careerDesc" type="text" class="dfinput"/></li>
                <li>
                    <label>&nbsp;</label>
                    <input onclick="add_career()" type="button" class="btn" value="添加"/>
                    <input onclick="$('.panel').hide()" type="button" class="btn" value="关闭"/>
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


    function delete_career(id) {
        delete_id = id
        $(".tip").fadeIn(200);
    }

    function do_delete() {
        if (delete_id !== -1) {
            $.ajax({
                dataType: "json",
                url: "/career/do_delete",
                data: {id: delete_id},
                type: "post",
                success: function (result) {
                    if (result.code === 200) {
                        window.location.reload(true);
                        alert("删除成功！")
                    } else {
                        alert("删除失败！")
                    }
                }
            })
            delete_id = -1
        }
    }

    function add_career() {
        $.ajax({
            dataType: "json",
            url: "/career/do_add",
            data: $('#add_career').serialize(),
            type: "post",
            success: function (result) {
                if (result.code === 200) {
                    window.location.reload(true);
                    alert("添加成功！")
                } else {
                    alert("添加失败！")
                }
            }
        })
    }
</script>