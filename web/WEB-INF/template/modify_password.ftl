<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>密码修改</title>
    <script type="text/javascript" src="${ctxPath}/js/jquery-1.6.js"></script>
    <script type="text/javascript" src="${ctxPath}/js/index.js"></script>
</head>
<body>
<h1>
    修改用户密码
</h1>
<form action="modify-password" method="post">
    用户ID:<input type="text" name="id" value="${user.id}" readonly="true"/><br>
    用户名:<input type="text" name="name" id="name" value="${user.name}" readonly><br>
    <input type="password" name="oldPassword" placeholder="请输入旧密码"><br>
    <input type="password" name="newPassword" placeholder="请输入新密码"><br>
    <input type="password" name="confirmPassword" placeholder="请再次输入新密码"><br>
    <input type="submit" value="修改" style="margin-left: 50px;">
    <input type="button" value="返回" style="margin-left: 0px;" onClick="location.href='main_menu'">
</form>
</body>
</html>