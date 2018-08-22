<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增员工信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/employee.css" rel="stylesheet" type="text/css"/>
    <link href="/css/page.css" rel="stylesheet" type="text/css"/>
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

        <div>
            <select name="search_type">
                <option value="1">姓名</option>
                <option value="2">身份证</option>
                <option value="2">手机</option>
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
                <option value="0">审批进度</option>
                <option>进件中</option>
                <option value="">初审中</option>
                <option value="">审核未通过</option>
                <option value="">放款中</option>
                <option value="">审核未通过</option>
                <option value="">已放款</option>
            </select>
        </div>
        <div style="margin-left: 10px;">
            <select style="">
                <option value="0">放款机构</option>
                <option value="">xx银行</option>
                <option value="">yy银行</option>
                <option value="">zz银行</option>
            </select>
        </div>
        <div style="margin-left: 10px;">
            <select>
                <option value="0">客户等级</option>
                <option value="">优</option>
            </select>
        </div>
        <div style="margin-left: 10px;">
            <select>
                <option value="0">客户关注等级</option>
                <option value="">A</option>
            </select>
        </div>
        <div class="common_button">
            <li class="click"><span><img src="/images/ico06.png"></span>筛选</li>
        </div>
    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th>姓名</th>
            <th>电话</th>
            <th width="100">客户关注等级</th>
            <th width="70">客户等级</th>
            <th>身份证</th>
            <th>贷款进度</th>
            <th>贷款机构</th>
            <th>业务员</th>
            <th>办理时间</th>
            <th width="150">操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        <tr>
            <td>张三</td>
            <td>15876656366</td>
            <td>A</td>
            <td>优</td>
            <td>511027372778338272</td>
            <td>进件中</td>
            <td>平安银行</td>
            <td>xxx</td>
            <td>2018-01-02 09:51:47</td>
            <td><a href="#" class="tablelink">详情</a><a href="#" class="tablelink">修改</a><a class="tablelink">删除</a></td>
        </tr>
        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
            <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
            <li class="paginItem"><a href="javascript:;">1</a></li>
            <li class="paginItem current"><a href="javascript:;">2</a></li>
            <li class="paginItem"><a href="javascript:;">3</a></li>
            <li class="paginItem"><a href="javascript:;">4</a></li>
            <li class="paginItem"><a href="javascript:;">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="javascript:;">10</a></li>
            <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>


</div>
</body>
</html>
<script language="JavaScript" src="/js/jquery.js"></script>
<script>
  function delete_employee(id) {
    $.ajax({
      dataType: "json",
      url: "/delete_employee",
      data: {
        id: id
      },
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
