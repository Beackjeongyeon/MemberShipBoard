<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-23
  Time: 오후 1:54
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
      <th>작성자</th>
      <th>제목</th>
      <th>작성시간</th>
      <th>조회수</th>
    </tr>
    <c:forEach items="${boardList}" var="board">
      <tr>
        <td>${board.id}</td>
        <td>${board.boardWriter}</td>
        <td><a href="/board/list?id=${board.id}">${board.boardTitle}</a></td>
        <td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
                            value="${board.boardCreatedDate}"></fmt:formatDate></td>
        <td>${board.boardHits}</td>
      </tr>
    </c:forEach>
  </table>
</div>
<div class="container">
  <ul class="pagination justify-content-center">
    <c:choose>
      <c:when test="${paging.page<=1}">
        <li class="page-item disabled">
          <a class="page-link">[이전]</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item">
          <a class="page-link" href="/board/paging?page=${paging.page-1}">[이전]</a>
        </li>
      </c:otherwise>
    </c:choose>
    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i" step="1">
      <c:choose>
        <c:when test="${i eq paging.page}">
          <li class="page-item active">
            <a class="page-link">${i}</a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="page-item">
            <a class="page-link" href="/board/paging?page=${i}">${i}</a>
          </li>
        </c:otherwise>
      </c:choose>
    </c:forEach>
    <c:choose>
      <c:when test="${paging.page>=paging.maxPage}">
        <li class="page-item disabled">
          <a class="page-link">[다음]</a>
        </li>
      </c:when>
      <c:otherwise>
        <li class="page-item">
          <a class="page-link" href="/board/paging?page=${paging.page+1}">[다음]</a>
        </li>
      </c:otherwise>
    </c:choose>
  </ul>
</div>


</body>
</html>