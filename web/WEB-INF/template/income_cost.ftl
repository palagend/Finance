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
月份：${date?date}<br>
收入：#{income;M2}<br>
支出：#{cost;M2}<br>
结余：#{income-cost;M2}
<hr>
历史总收入：#{history_income;M2}
历史总支出：#{history_cost;M2}
历史总结余：#{history_income-history_cost;M2}
</body>
</html>