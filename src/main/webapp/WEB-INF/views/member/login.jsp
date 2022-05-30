<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인페이지입니다.</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        .container {
            max-width: 500px;
        }
    </style>
</head>
<body>
<form action="/member/login1" method="post">
    <input type="text" name="memberId" placeholder="아이디"><br>
    <input type="text" name="memberPassword" placeholder="비밀번호"><br>
    <input type="submit" value="로그인">


</form>
</body>
</html>
