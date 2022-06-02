<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 페이지입니다.</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <script src="/resources/js/jquery.js"></script>
    <style>
        .container {
            max-width: 500px;
        }
    </style>
</head>
<body>
<jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
<br><br><br><br><br>

<div class="container">
    <h2 class="display-4 fw-normal">회원가입</h2>
    <div class="py-5 text-center">
<form action="/member/save1" method="post" enctype="multipart/form-data">
    <input class="form-control mb-2" name="memberId" onblur="duplicateCheck()" placeholder="아이디"><br>
    <div id ="dup-check-result"></div>
    <input class="form-control mb-2" name="memberPassword" placeholder="비밀번호"><br>
    <input class="form-control mb-2" name="memberName" placeholder="이름"><br>
    <input class="form-control mb-2" name="memberEmail" placeholder="이메일"><br>
    <input class="form-control mb-2" name="memberMobile" placeholder="전화번호"><br>
    <input type="file" name="memberProfile"><br>
    <input type="submit" class="btn btn-primary" value="회원가입">
</form>
    </div>
</div>

</body>
<script>
    const duplicateCheck=()=>{
        const memberId=document.getElementById("memberId").value;
        const checkResult=document.getElementById("dup-check-result");
        $.ajax({
            type: "post",
            url: "/member/duplicate-check",
            data: {"memberId": memberId},
            dataType: "json",

            success:function (result){
                if(result == "ok"){
                    alert("성공")
                    checkResult.innerHTML="사용가능한아이디입니다."
                    checkResult.style.color="green";
                }else{
                    alert("실패")
                    checkResult.innerHTML="중복된아이디입니다."
                    checkResult.style.color="red";
                }
            }
        });

    }
</script>
</html>
