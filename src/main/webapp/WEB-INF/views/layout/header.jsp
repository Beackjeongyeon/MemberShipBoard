<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-27
  Time: 오후 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<header class="p-3 bg-dark text-white">
    <div class="">
        <ul class="nav  mb-2 input-group justify-content-center">
            <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
            <br>
            <c:if test="${sessionScope.memberId != null}">
                <%--                <c:choose>--%>
                <%--                <c:when test="${sessionScope.memberId != null}">--%>

                <li><a href="/board/saveFile" class="nav-link px-2 text-white">글쓰기</a></li>
                <br>
                <%--                </c:when>--%>
                <%--                </c:choose>--%>
            </c:if>

        </ul>


            <c:if test="${sessionScope.memberId eq 'admin'}">
                <a href="/member/admin" class="btn btn-secondary">관리자페이지</a>
            </c:if>



        <div class="" style="text-align: right">
            <c:choose>
                <c:when test="${sessionScope.memberId == null}">
                    <button type="button" class="btn btn-outline-light me-2" onclick="login()">Login</button>
                </c:when>
                <c:otherwise>
                    <button type="button" class="btn btn-outline-light me-2" onclick="logout()">Logout</button>
                </c:otherwise>
            </c:choose>

            <%--    if(로그인 == 완료){--%>
            <%--    마이페이지(sign-up)
            <%--    }else{--%>
            <%--    로그인 x sign-up x --%>



            <%--                <button type="button" class="btn btn-warning" onclick="save()">Sign-up</button>--%>
            <c:choose>
                <c:when test="${sessionScope.memberId != null}">
                    <button type="button" class="btn btn-warning" onclick="mypage()">마이페이지</button>
                </c:when>
                <c:otherwise>
                    <button type="button" class="btn btn-warning" onclick="save()">회원가입</button>
                </c:otherwise>

            </c:choose>



        </div>
    </div>
</header>

<script>
    function login() {
        location.href = "/member/login"
    }
    function logout() {
        location.href = "/member/logout"
    }
    function mypage(){
        location.href = "/member/myPage"
    }
    function save(){
        location.href = "/member/save1"
    }
    function adminlogin(){
        location.href = "/member/admin"
    }
</script>

</body>
</html>