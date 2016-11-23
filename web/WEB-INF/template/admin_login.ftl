<!doctype html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>管理员登陆</title>
</head>
<body>
<form action="${ctxPath}/alogin" method="post">
    <input type="text" name="name" placeholder="请输入管理员用户名">
    <input type="password" name="password" placeholder="请输入管理员密码">
    <input type="submit" value="登录" style="margin-left: 50px;">
    <input type="reset" value="重置" style="margin-left: 0px;">
    <input type="button" value="注册" onclick="javascript:location.href='${ctxPath}/admin_register'">
</form>
</body>
</html>