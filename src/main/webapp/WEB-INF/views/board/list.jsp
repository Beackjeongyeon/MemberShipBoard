<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-19
  Time: 오후 3:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- CSS only -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        .container {
            max-width: 700px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<br><br><br><br><br>
<h2>list.jsp</h2>
<div class="container">
    <table class="table">
        <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>내용</th>
            <th>조회수</th>
            <th>날짜</th>
            <th>사진</th>

        </tr>
        <c:forEach items="${boardList}" var="board">

            <tr>
                <td>${board.id}</td>
                <td>${board.boardTitle}</td>
                <td>${board.boardWriter}</td>
                <td>${board.boardContents}</td>
                <td>${board.boardHits}</td>
                <td>${board.boardCreatedDate}</td>
                <td>${board.boardFile}</td>
                <td><a href="/detail?id=${board.id}">조회</a></td>
                <td><a href="/delete?id=${board.id}">삭제</a></td>
                    <%-- 클릭한 회원의 정보를 DB에서 가져와서 detail.jsp에 출력 --%>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
