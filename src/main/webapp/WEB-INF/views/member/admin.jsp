<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-06-03
  Time: 오전 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
<table class="table">
    <tr>
        <th>회원번호</th>
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>프로필사진</th>
    </tr>
    <c:forEach items="${memberList}" var="member">
        <tr>
            <td>${member.id}</td>
            <td>${member.memberId}</td>
            <td>${member.memberPassword}</td>
            <td>${member.memberName}</td>
            <td>${member.memberEmail}</td>
            <td>${member.memberMobile}</td>
            <td>${member.memberProfile}</td>
        </tr>
    </c:forEach>

    <button  class="btn btn-primary"  onclick="del()" >회원삭제</button>
</table>
</div>
</body>
<script>
    function del(){
        location.href = "/member/delete1?id=${result.id}"


    }
</script>
</html>
