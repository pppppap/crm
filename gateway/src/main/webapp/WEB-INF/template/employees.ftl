<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8"/>
    <title>新增员工信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/employee.css" rel="stylesheet" type="text/css"/>
    <link href="/css/panel.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="index.html">首页</a></li>
        <li><a href="addjob.html">员工列表</a></li>
    </ul>
</div>

<div class="formbody ">

    <div class="search_box" style="float: left;">
        <form id="search_form" action="/employee/search" method="get">
            <div>
                <select name="search_type">
                    <option value="1">姓名</option>
                    <option value="2">工号</option>
                </select>
            </div>
            <div style="margin-left: 10px;margin-right: 5px;">
                <input class="input_border" name="key" type="text" placeholder="请输入搜索信息">
            </div>
            <div class="common_button" onclick="$('#search_form').submit()">
                <li><span><img src="/images/ico06.png"></span>搜索</li>
            </div>
            <div class="tools" style="display: inline-block;float: none;">
                <ul class="toolbar">
                    <li onclick="$('.panel').show();"><span><img src="/images/t01.png"/></span>添加</li>
                </ul>
            </div>
        </form>
    </div>
    <div class="search_box" style="float: right;">
        <form id="filter_form" action="/employee/filter" method="get">
            <div>
                <select name="sex">
                    <option value="0">性别</option>
                    <#if sex?? && sex=='男'>
                        <option value="男" selected>男</option>
                        <option value="女">女</option>
                    <#elseif sex?? && sex=='男'>
                        <option value="男">男</option>
                        <option value="女" selected>女</option>
                    <#else>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </#if>

                </select>
            </div>
            <div style="margin-left: 10px;">
                <select name="dep_id">
                    <option value="0">所有部门</option>
                    <#list departments as i>
                        <#if dep_id?? && dep_id?number==i.id>
                            <option value="${i.id?c}" selected>${i.depName}</option>
                        <#else >
                            <option value="${i.id?c}">${i.depName}</option>
                        </#if>

                    </#list>
                </select>
            </div>
            <div style="margin-left: 10px;">
                <select name="age1">
                    <option value="0">年龄</option>
                    <#list 18..60 as i>
                        <#if age1?? && age1?number==i >
                            <option value="${i}" selected>${i}</option>
                        <#else>
                            <option value="${i}">${i}</option>
                        </#if>
                    </#list>
                </select>-
                <select name="age2">
                    <option value="0">年龄</option>
                    <#list 18..60 as i>
                        <#if age2?? && age2?number==i >
                            <option value="${i}" selected>${i}</option>
                        <#else>
                            <option value="${i}">${i}</option>
                        </#if>
                    </#list>
                </select>
            </div>
            <div class="common_button" onclick="$('#filter_form').submit()">
                <li><span><img src="/images/ico06.png"></span>筛选</li>
            </div>
        </form>
    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th width="50">编号<i class="sort"><img src="/images/px.gif"/></i></th>
            <th>姓名</th>
            <th width="40">性别</th>
            <th width="40">年龄</th>
            <th>部门</th>
            <th>职位</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>住址</th>
            <th>入职时间</th>
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
            <td>${i.name!}</td>
            <td>${i.sex!}</td>
            <td>${i.age!}</td>
            <td>${i.department.depName!}</td>
            <td>${i.career.careerName!}</td>
            <td>${i.tel!}</td>
            <td>${i.email!}</td>
            <td>${i.address!}</td>
            <td><#if i.inDate??>${i.inDate?string('yyyy-MM-dd')}</#if></td>
            <td><a href="/employee/update?id=${i.id?c}" class="tablelink">修改</a>
                <a class="tablelink" href="javascript:" onclick="delete_employee(${i.id?c})">删除</a>
            </td>

        </tr>
        </#list>

        </tbody>
    </table>


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
            <li class="paginItem"><a href="/employee/filter?page=${page.currentPage-1}&${page.url}"><span
                    class="pagepre"></span></a></li>
            </#if>

            <#if page.totalPage &gt; 7 >
            <li class="paginItem"><a href="/employee/filter?page=1&${page.url}">1</a></li>
            <li class="paginItem current"><a href="/employee/filter?page=2&${page.url}">2</a></li>
            <li class="paginItem"><a href="/employee/search?page=3&${page.url}&${page.url}">3</a></li>
            <li class="paginItem"><a href="/employee/search?page=4">4</a></li>
            <li class="paginItem"><a href="/employee/search?page=5">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="/employee/filter?page=${page.totalPage}&${page.url}">${page.totalPage}</a>
            </li>
            <#else>
                <#list 1..page.totalPage as i>
                    <#if (i==page.currentPage)>
                    <li class="paginItem current"><a href="/employee/filter?page=${i}&${page.url}">${i}</a>
                    </li>
                    <#else>
                    <li class="paginItem "><a href="/employee/filter?page=${i}&${page.url}">${i}</a></li>
                    </#if>
                </#list>
            </#if>

            <#if page.currentPage==page.totalPage>
            <li class="paginItem"><a href="javascript:"><span class="pagenxt2"></a></span></li>
            <#else >
            <li class="paginItem"><a href="/employee/filter?page=${page.currentPage+1}&${page.url}"><span
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
            <input name="" type="button" class="sure" value="确定"/>&nbsp;
            <input name="" type="button" class="cancel" value="取消"/>
        </div>

    </div>
</div>
<div class="panel" style="display: none;">
    <div class="formbody">
        <div class="formtitle"><span>员工信息</span></div>
        <form id="add_form" method="post">
            <ul class="forminfo">
                <li><label>员工姓名</label><input name="name" type="text" class="dfinput""/><i
                        class="required">*</i></li>
                <li>
                    <label>部门</label>
                    <select name="depId">
                    <#list departments as i>
                        <option value="${i.id?c}">${i.depName}</option>
                    </#list>
                    </select>
                    <i style="color: red;">*</i>
                </li>
                <li>
                    <label>职位</label>
                    <select name="careerId">
                    <#list careers as i>
                        <option value="${i.id?c}">${i.careerName!}</option>
                    </#list>
                    </select>
                    <i class="required">*</i>
                </li>
                <li>
                    <label>性别</label>
                    <select name="sex">
                        <option value="男" selected>&nbsp;&nbsp;男&nbsp;</option>
                        <option value="女">&nbsp;&nbsp;女&nbsp;</option>
                    </select>
                    <i class="required">*</i>
                </li>
                <li><label>年龄</label><input name="age" type="text" class="dfinput" style="width: 100px;"/><i>输入整数</i>
                </li>
                <li><label>电话</label><input name="tel" type="text" class="dfinput"/></li>
                <li><label>邮箱</label><input name="email" type="text" class="dfinput"/></li>
                <li><label>住址</label><input name="address" type="text" class="dfinput"/></li>
                <li>
                    <label>&nbsp;</label><input type="button" class="btn" value="添加" onclick="add_employee()"/>
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


    function delete_employee(id) {
        delete_id = id;
        $(".tip").fadeIn(200);
    }

    function do_delete() {
        if (delete_id !== -1) {
            $.ajax({
                dataType: "json",
                url: "/employee/delete",
                data: {
                    id: delete_id
                },
                type: "post",
                success: function (result) {
                    if (result.code === 200) {
                        window.location.reload(true)
                    } else {
                        alert("删除失败")
                    }
                }
            })
            delete_id = -1
        }
    }

    function add_employee() {
        $.ajax({
            dataType: "json",
            type: "post",
            url: "/employee/do_add",
            data: $("#add_form").serialize(),
            success: function (result) {
                if (result.code === 200) {
                    alert("保存成功")
                    window.location.reload(true);
                } else {
                    alert("保存失败")
                }
            }
        })
    }
</script>