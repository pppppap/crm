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
        <li><a href="/index">首页</a></li>
        <li><a href="/career/show_career">职业信息</a></li>
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
                        <li><span><img src="/images/t02.png"></span>修改</li>
                    </div>
                    <div class="toolbar2" onclick="delete_career(${i.id!})">
                        <li><span><img src="/images/t03.png"></span>删除</li>
                    </div>
                </td>
            </tr>
        </#list>
    </table>

    <#--分页-->
    <div class="pagin">
    <div class="message">共<i class="blue">${page.totalCount}</i>条记录，当前显示第&nbsp;<i class="blue">${page.currentPage}
        &nbsp;</i>页
    </div>
    <ul class="paginList">
            <#if page.currentPage==1>
            <li class="paginItem unavaliable"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <#else>
            <li class="paginItem" onclick="beforepage(${page.currentPage})"><a href="javascript:;"><span class="pagepre"></span></a></li>
            </#if>

            <#if page.totalPage &gt; 7 >
            <li class="paginItem"><a href="javascript:;" onclick="go('/career/career?page=1')">1</a></li>
            <li class="paginItem current"><a href="javascript:;" onclick="go('/career/career?page=2')">2</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/career/career?page=3')">3</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/career/career?page=4')">4</a></li>
            <li class="paginItem"><a href="javascript:;" onclick="go('/career/career?page=5')">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;"
                                     onclick="go('/career/career?page=${page.totalPage}')">${page.totalPage}</a></li>
            <#else>
                <#list 1..page.totalPage as i>
                    <#if (i==page.currentPage)>
                    <li class="paginItem"><a href="javascript:;" onclick="go('/career/career?page=${i}')">${i}</a></li>
                    <#else>
                    <li class="paginItem current" ><a href="javascript:;" onclick="go('/career/career?page=${i}')">${i}</a></li>
                    </#if>
                </#list>
            </#if>

            <#if page.currentPage==page.totalPage>
            <li class="paginItem unavaliable"><a href="javascript:;"><span class="pagenxt"></span></a></li>
            <#else >
            <li class="paginItem" onclick="nextpage(${page.currentPage})" ><a href="javascript:;"><span class="pagenxt"></span></a></li>
            </#if>
    </ul>
</div>

</div>
</body>
</html>
<script language="JavaScript" src="/js/jquery.js"></script>
    <script>
        function delete_career(id){
            $.ajax({
                dataType:"json",
                url:"/career/delete_career",
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
                url:"/career/careerId",
                data:{careerId:id},
                type:"post",
            })
            window.open("/career/updateCareer","_self")
        }

        //分页
        function go(url) {
            window.open(url, "_self")
        }
         //上一页
        function beforepage(now_page) {
        go("/career/career?page="+(now_page-1))
        }
        //下一页
        function nextpage(now_page) {
            go("/career/career?page="+(now_page+1))
        }
    </script>