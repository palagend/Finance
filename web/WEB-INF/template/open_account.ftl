<!doctype html>
<html lang="cn" >
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="openAccount" method="post">

    <input type="text" placeholder="请输入账户名" name="name">
    <input type="text" placeholder="请输入账户号" name="code">
    <input type="text" placeholder="请输入账户余额" name="value">
    <input type="hidden" name="currency" value="1">
    <input type="hidden" name="userId" value="${user.id}">
    <input type="hidden" name="type" value="1">

    <input type="submit" value="确认添加">
    <input type="reset" value="重置">
</form>
<p><a href="mainMenu">返回主页</a></p>
</body>
</html>