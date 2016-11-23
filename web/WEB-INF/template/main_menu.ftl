<!doctype html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${user.name}的主页</title>
</head>
<body>
<h1>您好,${user.name}!这里是您的理财主页</h1>
<ul>
    <li><a href="${ctxPath}/loginOut">安全退出</a></li>
    <li><a href="${ctxPath}/to-modify-password">密码修改</a></li>
    <hr>
    <li><a href="${ctxPath}/to-write">记一笔</a></li>
    <li><a href="${ctxPath}/accounts">我的账户</a></li>
    <hr>
    <li><a href="${ctxPath}/income-cost?date=${.now?string("yyyy-MM")}">收支详情</a></li>
    <#--<li><a href="${ctxPath}/borrow-lend">借贷详情</a></li>-->
    <li><a href="${ctxPath}/finance-log">财务日志</a></li>
</ul>
</body>
</html>