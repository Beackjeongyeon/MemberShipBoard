<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>시작페이지입니다.</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<br><br><br><br><br>
<div class="" style="text-align: center">
<a href="/member/save">회원가입</a>
<a href="/member/login">로그인</a>
<a href="/board/pagingList">글목록</a>
</div>
</body>
</html>
