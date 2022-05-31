<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-27
  Time: 오후 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
                <br>
                <li><a href="/board/saveFile" class="nav-link px-2 text-white">글쓰기</a></li>
                <br>


            </ul>

            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                <input type="search" class="form-control form-control-dark text-white bg-dark" placeholder="Search..."
                       aria-label="Search">
            </form>

            <div class="text-end">
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
        location.href = "member/myPage"
    }
    function save(){
        location.href = "member/save1"
    }

</script>

</body>
</html>
