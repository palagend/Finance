<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${cssPath}/style.css" type="text/css" rel="stylesheet" />
    <title>Insert title here</title>
<#--<script type="text/javascript" src="${ctxPath}/js/jquery-1.6.js"></script>-->
<#--<script type="text/javascript" src="${ctxPath}/js/user.js"></script>-->
</head>
<body>
<#--使用framemaker模板语言输出-->
<table border="2">
    <tr>
        <td>id</td>
        <td>日期</td>
        <td>转出账户</td>
        <td>转入账户</td>
        <td>交易额</td>
        <td>类型码</td>
        <td>备注</td>
    </tr>
<#list logs as log>
    <tr>
        <td>${log.id}</td>
        <td>${log.dateTime?string("yyyy-MM-dd HH:mm:ss")}</td>
        <td>${log.fromAccount}</td>
        <td>${log.toAccount}</td>
        <td>${log.amount}</td>
        <td>${log.type}</td>
        <td>${log.description}</td>
    </tr>
</#list>
</table>
<div class="pagenavigation">
<#if (pageInfo.currentPage>1)>
    <a href="${ctxPath}/finance-logs/${pageInfo.currentPage - 1} " class="left">上一页</a>
</#if>

<#assign forbegin=pageInfo.currentPage-5>
<#assign forend=pageInfo.currentPage+5>

<#list forbegin..forend as i>
    <#if (i>=1) && (i<=pageInfo.totalPage)>
        <a href="${ctxPath}/finance-logs/${i}" <#if pageInfo.currentPage==i>class="current"</#if>>${i}</a>
    </#if>
</#list>

<#if (pageInfo.currentPage<pageInfo.totalPage)>
    <a href="${ctxPath}/finance-logs/${pageInfo.currentPage + 1}" class="right">下一页</a>
</#if>
</div>
当前页：${pageInfo.currentPage}<br>
总记录数：${pageInfo.totalRows}<br>
总页数:${pageInfo.totalPage}<br>
每页大小:${pageInfo.pageSize}
<br>

</body>
</html>