<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改账户</title>
</head>
<body>
<h1>
    修改账户
</h1>
<form action="updateAccount" method="post">
    账户ID:<input type="text" name="id" value="${Request['account'].id}" readonly="true"/><br>
    账户名:<input type="text" name="name" id="name" value="${Request['account'].name}"><br>
    <#if account.code??>
        账户卡号:<input type="text" name="code" id="code" value="${Request['account'].code}"><br>
    <#else >
        账户卡号:<input type="text" name="code" id="code" placeholder="请输入卡号"><br>
    </#if>
    <input type="submit" value="修改" style="margin-left: 50px;">
    <input type="reset" value="重置" style="margin-left: 0px;">
    <input type="button" value="返回" style="margin-left: 0px;" onClick="location.href='${ctxPath}/accounts'">
</form>
</body>
</html>
