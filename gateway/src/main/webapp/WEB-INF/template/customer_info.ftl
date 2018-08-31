<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>新增客户信息</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="/css/employee.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/upload/webuploader.css"/>
    <link rel="stylesheet" type="text/css" href="/upload/style.css"/>
</head>
<style>
    .dfinput {
        width: 320px;
        margin-right: 10px;
    }

    .forminfo textarea {
        margin-right: 5px;
        width: 320px;
        border-top: solid 1px #a7b5bc;
        border-left: solid 1px #a7b5bc;
        border-right: solid 1px #ced9df;
        border-bottom: solid 1px #ced9df;
        background: url(/images/inputbg.gif) repeat-x;
        text-indent: 10px;
    }
</style>
<body>

<div class="place">
    <span>位置:</span>
    <ul class="placeul">
        <li><a href="index.html">首页</a></li>
        <li><a href="addjob.html">新增员工</a></li>
    </ul>
</div>
<#escape x as x!"">
<div class="formbody">

    <div class="formtitle"><span>客户信息</span></div>
    <form id="myform">
        <input type="hidden" name="id" value="${customer.id?c}">

        <ul class="forminfo">
            <li><label>姓名</label><input name="name" type="text" class="dfinput" value="${customer.name}"/></li>
            <li>
                <label>身份证</label>
                <input name="idcard" type="text" class="dfinput" value="${customer.idcard!}"/>
            </li>
            <li>
                <label>性别</label>
                <select name="sex">
                    <option value="0">性别</option>
                    <#if customer.sex=='男'>
                        <option value="男" selected>男</option>
                        <option value="女">女</option>
                    <#elseif customer.sex=='女'>
                        <option value="男">男</option>
                        <option value="女" selected>女</option>
                    <#else>
                        <option value="无">无</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </#if>
                </select>
            </li>
            <li>
                <label>电话</label>
                <#if customer.tel??>
                    <#list customer.tel?split(",") as t>
                        <input name="tel" value="${t}" type="text" class="dfinput"/>
                    </#list>
                <#else >
                    <input name="tel" type="text" class="dfinput"/>
                </#if>

                <div class="input_add" onclick="add_input(this)">
                    <div><span>&nbsp;<img src="/images/t01.png"></span>&nbsp;</div>
                </div>
            </li>
            <li><label>贷款金额</label><input name="realloan" type="text" class="dfinput"/></li>
            <li><label>放款机构</label><label><a href="#">浦发银行</a></label></li>
            <li><label>审批进度</label><label>初审中</label></li>
            <li><label>佣金</label></li>
            <li><label>退件备注</label><textarea rows="10" name="note"></textarea></li>
            <li><label>客户关注等级</label><label>A</label></li>
            <li><label>客户等级</label><label>优</label></li>
            <li><label>办理时间</label><label></label></li>
            <li><label>房产证</label>
                <a href="/evaluate/upload_house/${customer.id?c}"><input type="button" class="btn" value="房产信息"></a>
            </li>
            <li><label>汽车登记证书</label>
                <a href="/evaluate/upload_car/${customer.id?c}"><input type="button" class="btn" value="汽车信息"></a>
            </li>
            <li><label>&nbsp;</label>
                <input type="button" class="btn" value="修改" onclick="update_customer()"/>
                <input type="button" class="btn" value="返回" onclick="window.open('${back_uri}','_self')"/>
            </li>
        </ul>
    </form>
</div>
</body>
</#escape>
</html>
<script src="https://cdn.bootcss.com/jquery/3.2.0/jquery.min.js"></script>

<script>
    function add_input(ele) {
        var input = $(ele).prev();
        var _add = input.clone()

        input.after(_add.prop("outerHTML"))
        input.next('input').val('')
    }

    function update_customer() {
        $.ajax({
            url:'/evaluate/do_update',
            data:$('#myform').serialize(),
            dataType:'json',
            type:'POST',
            success:function (data) {
                if(data.code===200){
                    window.open('${back_uri}','_self')
                }
            }
        })
    }
</script>

