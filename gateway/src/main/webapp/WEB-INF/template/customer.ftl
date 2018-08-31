<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增员工信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/employee.css" rel="stylesheet" type="text/css"/>
</head>
<#escape x as x!"">
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
        <form id="search_form" action="/evaluate/filter" method="get">
            <div>
                <select name="searchType">
                    <#if (queryDTO.searchType)??>
                        <option value="1" ${(queryDTO.searchType=='1')?string('selected','')}>姓名</option>
                        <option value="2" ${(queryDTO.searchType=='2')?string('selected','')}>身份证</option>
                        <option value="3" ${(queryDTO.searchType=='3')?string('selected','')}>手机</option>
                    <#else >
                        <option value="1">姓名</option>
                        <option value="2">身份证</option>
                        <option value="3">手机</option>
                    </#if>
                </select>
            </div>
            <div style="margin-left: 10px;margin-right: 5px;">
                <input class="input_border" name="key" type="text" placeholder="请输入搜素信息" value="${key!}">
            </div>
            <div class="common_button">
                <li class="click" onclick="$('#search_form').submit()"><span><img src="/images/ico06.png"></span>搜索</li>
            </div>
        </form>
    </div>
    <div class="search_box" style="float: right;">
        <form action="/evaluate/filter" method="get" id="filter_form">
            <div>
                <select name="process">
                    <option value="0">审批进度</option>
                    <#if (queryDTO.process)??>
                        <option value="进件中" ${(queryDTO.process=='进件中')?string('selected','')}>进件中</option>
                        <option value="初审中" ${(queryDTO.process=='初审中')?string('selected','')}>初审中</option>
                        <option value="审核未通过" ${(queryDTO.process=='审核未通过')?string('selected','')}>审核未通过</option>
                        <option value="审核通过" ${(queryDTO.process=='审核通过')?string('selected','')}>审核通过</option>
                        <option value="放款中" ${(queryDTO.process=='放款中')?string('selected','')}>放款中</option>
                        <option value="已放款" ${(queryDTO.process=='已放款')?string('selected','')}>已放款</option>
                    <#else >
                        <option value="进件中">进件中</option>
                        <option value="初审中">初审中</option>
                        <option value="审核未通过">审核未通过</option>
                        <option value="审核通过">审核通过</option>
                        <option value="放款中">放款中</option>
                        <option value="已放款">已放款</option>
                    </#if>
                </select>
            </div>
            <div style="margin-left: 10px;">
                <select name="bankId">
                    <option value="0">放款机构</option>
                <#list banks as i>
                    <#if (queryDTO.bankId)??>
                        <option value="${i.id}" ${(queryDTO.bankId==i.id)?string('selected','')}>${i.name}</option>
                    <#else>
                        <option value="${i.id}">${i.name}</option>
                    </#if>
                </#list>
                </select>
            </div>
            <div style="margin-left: 10px;">
                <select name="customerLevel">
                    <option value="0">客户等级</option>
                    <#if (queryDTO.customerLevel)??>
                        <option value="高" ${(queryDTO.customerLevel=='高')?string('selected','')}>高</option>
                        <option value="中" ${(queryDTO.customerLevel=='中')?string('selected','')}>中</option>
                        <option value="低" ${(queryDTO.customerLevel=='低')?string('selected','')}>低</option>
                    <#else >
                        <option value="高">高</option>
                        <option value="中">中</option>
                        <option value="低">低</option>
                    </#if>
                </select>
            </div>
            <div style="margin-left: 10px;">
                <select name="attentionLevel">
                    <option value="0">客户关注等级</option>
                    <#if (queryDTO.attentionLevel)??>
                    <option value="A" ${(queryDTO.attentionLevel=='A')?string('selected','')}>A</option>
                    <option value="B" ${(queryDTO.attentionLevel=='B')?string('selected','')}>B</option>
                    <option value="C" ${(queryDTO.attentionLevel=='C')?string('selected','')}>C</option>
                    <option value="D" ${(queryDTO.attentionLevel=='D')?string('selected','')}>D</option>
                    <#else >
                    <option value="A">A</option>
                    <option value="B">B</option>
                    <option value="C">C</option>
                    <option value="D">D</option>
                    </#if>
                </select>
            </div>
            <div class="common_button">
                <li class="click" onclick="$('#filter_form').submit()"><span><img src="/images/ico06.png"></span>筛选</li>
            </div>
        </form>
    </div>
    <table class="tablelist">
        <thead>
        <tr>
            <th>姓名</th>
            <th width="100">电话</th>
            <th width="100">客户关注等级</th>
            <th width="70">客户等级</th>
            <th>身份证</th>
            <th>贷款进度</th>
            <th>贷款机构</th>
            <th>业务员</th>
            <th>办理时间</th>
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
            <td>${i.name}</td>
            <td>
            <#if i.tel??>
            <#list i.tel?split(",") as t>
                <label style="float: left;">${t}</label>
            </#list>
            </#if>
            </td>
            <td>${i.attentionLevel!}</td>
            <td>${i.customerLevel!}</td>
            <td>${i.idcard!}</td>
            <td>${i.process!}</td>
            <td>${(i.bank.name)!}</td>
            <td>${(i.salesman.name)!}</td>
            <td>
            <#if i.date??>
                ${i.date?string("yyyy-MM-dd hh:mm:ss")}
            </#if>
            </td>
            <td>
                <a href="/evaluate/getOne/${i.id?c}" class="tablelink">详情</a>
                <a class="tablelink">删除</a>
            </td>
        </tr>
        </#list>

        </tbody>
    </table>


    <div class="pagin">
        <div class="message">共<i class="blue">${page.totalCount}</i>条记录，当前显示第&nbsp;<i
                class="blue">${page.currentPage}
            &nbsp;</i>页
        </div>
        <ul class="paginList">
        <#if page.currentPage==1>
            <li class="paginItem"><a href="javascript:"><span class="pagepre2"></a></span></li>
        <#else>
            <li class="paginItem"><a href="/evaluate/filter?page=${page.currentPage-1}&${page.url}"><span
                    class="pagepre"></span></a></li>
        </#if>

        <#if page.totalPage &gt; 7 >
            <li class="paginItem"><a href="/evaluate/filter?page=1&${page.url}">1</a></li>
            <li class="paginItem current"><a href="/evaluate/filter?page=2&${page.url}">2</a></li>
            <li class="paginItem"><a href="/evaluate/filter?page=3&${page.url}&${page.url}">3</a></li>
            <li class="paginItem"><a href="/evaluate/filter?page=4">4</a></li>
            <li class="paginItem"><a href="/evaluate/filter?page=5">5</a></li>
            <li class="paginItem more"><a href="javascript:;">...</a></li>
            <li class="paginItem"><a href="/evaluate/filter?page=${page.totalPage}&${page.url}">${page.totalPage}</a>
            </li>
        <#else>
            <#list 1..page.totalPage as i>
                <#if (i==page.currentPage)>
            <li class="paginItem current"><a href="/evaluate/filter?page=${i}&${page.url}">${i}</a>
            </li>
                <#else>
            <li class="paginItem "><a href="/evaluate/filter?page=${i}&${page.url}">${i}</a></li>
                </#if>
            </#list>
        </#if>

        <#if page.currentPage==page.totalPage>
            <li class="paginItem"><a href="javascript:"><span class="pagenxt2"></a></span></li>
        <#else >
            <li class="paginItem"><a href="/evaluate/filter?page=${page.currentPage+1}&${page.url}"><span
                    class="pagenxt"></span></a></li>
        </#if>
        </ul>
    </div>


</div>
</body>
</#escape>
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
