<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增员工信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/employee.css" rel="stylesheet" type="text/css"/>
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

    <div class="formtitle"><span>员工列表</span></div>
    <div class="search_box" style="float: left;">

        <div>
            <select name="search_type">
                <option value="1">姓名</option>
                <option value="2">工号</option>
            </select>
        </div>
        <div style="margin-left: 10px;margin-right: 5px;">
            <input class="input_border" name="key" type="text" placeholder="请输入搜素信息">
        </div>
        <div class="common_button">
            <li class="click"><span><img src="/images/ico06.png"></span>搜索</li>
        </div>
    </div>
    <div class="search_box" style="float: right;">
        <div>
            <select>
                <option value="0">性别</option>
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
        <div style="margin-left: 10px;">
            <select style="">
                <option value="0">所有部门</option>
                <option value="2">人事部</option>
                <option value="3">销售部</option>
                <option value="4">财务部</option>
                <option value="4">技术部</option>
            </select>
        </div>
        <div style="margin-left: 10px;">
            <select>
                <option value="0">年龄</option>
                <option value="1">20</option>
                <option value="2">21</option>
                <option value="3">22</option>
                <option value="4">23</option>
            </select>-
            <select>
                <option value="0">年龄</option>
                <option value="1">20</option>
                <option value="2">21</option>
                <option value="3">22</option>
                <option value="4">23</option>
            </select>
        </div>
        <div class="common_button">
            <li class="click"><span><img src="/images/ico06.png"></span>筛选</li>
        </div>
    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th>编号<i class="sort"><img src="/images/px.gif"/></i></th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>部门</th>
            <th>职位</th>
            <th>电话</th>
            <th>邮箱</th>
            <th>住址</th>
            <th width="100">操作</th>
        </tr>
        </thead>
        <tbody>
        <#list page.list as i>

        <tr>
            <td>${i.id!}</td>
            <td>${i.name!}</td>
            <td>${i.sex!}</td>
            <td>${i.age!}</td>
            <td>${i.department.depName!}</td>
            <td>${i.career.careerName!}</td>
            <td>${i.tel!}</td>
            <td>${i.email!}</td>
            <td>${i.address!}</td>
            <td>
                <div class="toolbar2">
                    <li class="click"><span><img src="images/t02.png"></span>修改</li>
                </div>
                <div class="toolbar2" onclick="delete_employee(${i.id!})">
                    <li><span><img src="images/t03.png"></span>删除</li>
                </div>
            </td>
            <td><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>

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
            <li class="paginItem"><a href="javascript:;" onclick="go('/search?page=1')">1</a></li>
            <li class="paginItem current"><a href="javascript:;" onclick="go('/search?page=2')">2</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/search?page=3')">3</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/search?page=4')">4</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/search?page=5')">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;"
                                     onclick="go('/search?page=${page.totalPage}')">${page.totalPage}</a></li>
            <#else>
                <#list 1..page.totalPage as i>
                    <#if (i==page.currentPage)>
                    <li class="paginItem"><a href="javascript:;" onclick="go('/search?page=${i}')">${i}</a></li>
                    <#else>
                    <li class="paginItem current"><a href="javascript:;" onclick="go('/search?page=${i}')">${i}</a></li>
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
    function go(url) {
        window.open(url, "_self")
    }

    function delete_employee(id) {
        $.ajax({
            dataType: "json",
            url: "/delete_employee",
            data: {
                id: id
            },

            type:"post",
            success: function (result) {
                if (result.code === 200) {
                    alert("删除成功")
                } else {
                    alert("删除失败")

            type: "POST",
            success: function (result) {
                if (result.code === 200) {
                    alert(result.msg)
                } else {
                    alert(result.msg)
                }
            }
        })
    }
</script>