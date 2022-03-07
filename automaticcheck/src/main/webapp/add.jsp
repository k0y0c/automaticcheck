<%--
  Created by IntelliJ IDEA.
  User: yucha
  Date: 2022/3/5
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="user/add" method="post">
        <tr>
            身份证号：<input type="text" name="mobile" id="mobile">
        </tr><br>
        <tr>
            姓名：<input type="text" name="username" >
        </tr><br>
        <tr>
            省份：<input type="text" name="province" value="XX省">
        </tr><br>
        <tr>
            城市：<input type="text" name="city" value="XX市">
        </tr><br>
        <tr>
            区/县：<input type="text" name="district" value="XX区/县">
        </tr><br>
        <tr>
            详细地址：<input type="text" name="address" value="XX省XX市XX区/县XXX">
        </tr><br>
        <tr>
            体温：<input type="text" name="title" >
        </tr><br>
        <input type="submit" id="button" value="提交">

    </form>
</body>
</html>
