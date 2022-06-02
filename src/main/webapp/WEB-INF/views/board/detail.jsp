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
<br><br><br><br><br>
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
        <tr>
            <td>${board.id}</td>
            <td>${board.boardTitle}</td>
            <td>${board.boardWriter}</td>
            <td>${board.boardContents}</td>
            <td>${board.boardHits}</td>
            <td>${board.boardCreateDate}</td>
            <td><img src="${pageContext.request.contextPath}/upload/${board.boardFileName}" alt="" height="100"
                     width="100"></td>
        </tr>
    </table>
</div>
<c:if test="${sessionScope.memberId !=null}">
<form class="form-control">
    <input type="text" id="commentWriter" name="commentWriter"  value="${sessionScope.memberId}" readonly width="100px">
    <input type="text" id="commentContents" name="commentContents" placeholder="내용을 입력해주세요" width="100px">
            <button type="button" class="btn btn-primary" onclick="saveComment()">댓글작성</button>
            <button type="button" onclick="boardUpdate()">수정</button>
            <button type="button" onclick="boardDelete()">삭제</button>

</form>
    </c:if>
<div id="asd"></div>


<script>
    function saveComment() {
        const commentWriter ='${sessionScope.memberId}'
        const commentContents = document.getElementById("commentContents").value;

        $.ajax({
            type: 'get',
            url: '/comment/save',
            data: {
                "commentWriter": commentWriter,
                "commentContents": commentContents,
                "boardId": ${board.id},
            },
            dataType: 'json',


            success: function (result) {
                let output = "<table class='table'>";
                output += "<tr><th>id</th>";
                output += "<th>boardId</th>";
                output += "<th>commentContents</th>";
                output += "<th>commentWriter</th>";
                output += "<th>commentCreatedDate</th></tr>";
                for (let i in result) {
                 output += "<tr>";
                 output += "<td>"+ result[i].id +"</td>";
                 output += "<td>"+ result[i].boardId +"</td>";
                 output += "<td>"+ result[i].commentContents +"</td>";
                 output += "<td>"+ result[i].commentWriter +"</td>";
                 output += "<td>"+ result[i].commentCreatedDate +"</td>";
                 output += "<tr>";

                }
                document.getElementById("asd").innerHTML = output;
                document.getElementById("commentContents").value = '';


            },
            error: function (request, status, error) {
                alert("에러");
            },
        })

    }

    function login() {
        location.href = "/member/login";
    }
</script>

</body>

</html>




