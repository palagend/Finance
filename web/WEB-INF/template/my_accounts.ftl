<!doctype html>
<html lang="cn">
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

</head>
<body>
<h2>欢迎<font color="green" size="8px">${user.name}</font>账户列表:</h2><br>
<a href="to-openAccount"><font size="5px">增加账户</font></a> <a href="${ctxPath}/loginOut" style="margin-left: 140px">退出系统</a><br>

<#--使用framemaker模板语言输出-->
<table border="2">
    <tr>
        <td>账户ID</td><td>账户名</td><td>账户余额</td><td>操作</td>
    </tr>
<#list accounts as account>
    <tr>
        <td>${account.id}</td><td>${account.name}</td><td>${account.value}</td><td><a href="${ctxPath}/viewAccount?id=${account.id}">查看</a>||<a href="${ctxPath}/getUpdateAccount?id=${account.id}">修改</a>||<a href="${ctxPath}/delAccount?id=${account.id}">删除</a></td>
    </tr>
</#list>
</table>
<div class="pagenavigation">
<#if (pageInfo.currentPage>1)>
    <a href="${ctxPath}/accounts/${pageInfo.currentPage - 1} " class="left">上一页</a>
</#if>

<#assign forbegin=pageInfo.currentPage-5>
<#assign forend=pageInfo.currentPage+5>

<#list forbegin..forend as i>
    <#if (i>=1) && (i<=pageInfo.totalPage)>
        <a href="${ctxPath}/accounts/${i}" <#if pageInfo.currentPage==i>class="current"</#if>>${i}</a>
    </#if>
</#list>

<#if (pageInfo.currentPage<pageInfo.totalPage)>
    <a href="${ctxPath}/accounts/${pageInfo.currentPage + 1}" class="right">下一页</a>
</#if>
</div>
当前页：${pageInfo.currentPage}<br>
总记录数：${pageInfo.totalRows}<br>
总页数:${pageInfo.totalPage}<br>
每页大小:${pageInfo.pageSize}
<br>

</body>
</html>