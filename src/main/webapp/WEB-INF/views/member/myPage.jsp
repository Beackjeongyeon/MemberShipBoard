<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-20
  Time: 오전 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        .container {
            max-width: 500px;
        }
    </style>
</head>
<body>
<div class= "input-group container">
    <h2 class="display-4 fw-normal">마이페이지</h2>
    <div class="py-5 text-center">

        <form action="/member/update" method="get" name="updateForm" id="updateForm">
            id: <input class="form-control mb-2" type="text" name="id" style="width:500px"value="${result.id}" readonly>
            <input class="form-control mb-2" type="text" name="memberId" style="width:500px" value="${result.memberId}" readonly>
            <input class="form-control mb-2" type="text" name="memberPassword" style="width:500px" id="pwConfirm" placeholder="비밀번호를 입력해주세요">
            <input class="form-control mb-2" type="text" name="memberName" style="width:500px" value="${result.memberName}"readonly>
            <input class="form-control mb-2" type="text" name="memberEmail" style="width:500px" value="${result.memberEmail}"readonly>
            <input class="form-control mb-2" type="text" name="memberMobile" style="width:500px" value="${result.memberMobile}">
            <input class="btn-btn-primary" type="button" value=정보수정 onclick="update()" value="정보수정">
        </form>
    </div>
</div>
    <button  class="btn btn-primary"  onclick="del()" >회원탈퇴</button>
</body>
<script>
    const update =() => {
        console.log("update 함수호출");
        //사용자가 입력한 비밀번호 값 가져오기
        const pwConfirm = document.getElementById("pwConfirm").value;
        //DB에서 가져온 비밀번호 가져오기
        const pwDB = '${result.memberPassword}';
        // 비밀번호 일치하면 form 태그에 입력한 내용을 컨트롤러로 요청.
        // 일치하지 않으면 alert으로 비밀번호 틀린다고 보여줌.
        if(pwConfirm ==pwDB) {
            updateForm.submit(); // 해당 폼을 submit 하는 js 함수
        }else{
            alert("비밀번호가 틀립니다.")
        }
    }
    function del(){
        location.href = "/member/delete?id=${result.id}"


    }
</script>
</html>

