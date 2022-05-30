<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-19
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<div class="container">
  <table class="table">
    <tr>
      <th>글번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>내용</th>
      <th>조회수</th>
      <th>작성일자</th>
      <th>사진</th>
    </tr>
<c:forEach items="${boardList}" var="board">
    <tr>
      <th>${board.id}</th>
      <th>${board.boardTitle}</th>
      <th>${board.boardWriter}</th>
      <th>${board.boardContents}</th>
      <th>${board.boardHits}</th>
      <th>${board.boardCreatedDate}</th>
      <th>${board.boardFile}</th>
    </tr>
    </c:forEach>


</body>
</html>
