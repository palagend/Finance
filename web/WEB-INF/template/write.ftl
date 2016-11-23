<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>记一笔</title>
</head>
<body>
<form action="${ctxPath}/write" method="post">
    <select name="type" id="">
        <option value="3">收入</option>
        <option value="1">支出</option>
        <option value="5" selected>转账</option>
    </select>
    <input type="text" name="value" placeholder="请输入金额"><br>
    <select name="from" id="">
    <#list accounts as account>
        <option value="${account.id}">${account.name}(${account.value})</option>
    </#list>
    </select>
    -->
    <select name="to" id="">
    <#list accounts as account>
        <option value="${account.id}">${account.name}(${account.value})</option>
    </#list>
    </select>
    <input type="text" name="description" placeholder="请输入备注">
    <input type="submit" value="确认">
    <a href="${ctxPath}/mainMenu">返回</a>
</form>
</body>
</html>