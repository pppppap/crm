<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="/js/jquery.js"></script>

    <script type="text/javascript">
      $(function () {
        //导航切换
        $(".menuson li").click(function () {
          $(".menuson li.active").removeClass("active")
          $(this).addClass("active");
        });

        $('.title').click(function () {
          var $ul = $(this).next('ul');
          $('dd').find('ul').slideUp();
          if ($ul.is(':visible')) {
            $(this).next('ul').slideUp();
          } else {
            $(this).next('ul').slideDown();
          }
        });
      })
    </script>


</head>

<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>功能菜单</div>

<dl class="leftmenu">
    <dd>
        <div class="title">
            <span><img src="/images/leftico02.png"/></span>员工管理
        </div>
        <ul class="menuson">

            <li><cite></cite><a href="/show_employee" target="rightFrame">员工列表</a></li>
            <li><cite></cite><a href="/addEmployees.ftl" target="rightFrame">增加员工</a></li>

            <li><cite></cite><a href="/employee/show" target="rightFrame">员工列表</a></li>
            <li><cite></cite><a href="/addemployee.ftl" target="rightFrame">增加员工</a></li>

        </ul>
    </dd>
    <dd>
        <div class="title">
            <span><img src="/images/leftico02.png"/></span>用户管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="/show_user" target="rightFrame">用户列表</a></li>
            <li><cite></cite><a href="/addUser" target="rightFrame">新增用户</a></li>
        </ul>
    </dd>
    <dd>
        <div class="title">
            <span><img src="/images/leftico02.png"/></span>职位管理
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="/career/show_career" target="rightFrame">职位列表</a></li>
            <li><cite></cite><a href="/career/addCareer" target="rightFrame">新增职位</a></li>
        </ul>
    </dd>
</dl>
</body>
</html>