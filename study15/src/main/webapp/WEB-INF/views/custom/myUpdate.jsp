<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path1" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 보기</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <link rel="stylesheet" href="resources/css/normalize.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/motion-ui/1.2.3/motion-ui.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation-prototype.min.css">
    <link href='https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css' rel='stylesheet' type='text/css'>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/js/foundation.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/motion-ui/1.2.3/motion-ui.min.js"></script>
</head>
<body>
<header id="header">
	<a href="${path1 }">메인으로</a>
</header>

<div class="content" id="con">
    <div class="row column text-center">
        <div class="container">
            <c:if test="${sid=='admin' }">
                <h2 class="page_tit">회원 정보 수정</h2>
            </c:if>
            <c:if test="${sid!='admin' }">
                <h2 class="page_tit">마이 페이지</h2>
            </c:if>
            <hr>
            <form action="${path1 }/custom/myUpdatePro.do" method="post" onsubmit="return updateCheck(this)">
                <div class="table_form_wrap">
                    <table class="table_form">
                        <tbody>
                        <tr>
                            <th><label for="id">아이디</label></th>
                            <td><input type="text" name="id" id="id" size="100" class="single100" value="${cus.id }" readonly required>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="pw">비밀번호</label></th>
                            <td><input type="password" name="pw" id="pw"  class="single100" value="" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
                                <p>(최소 8자리에서 최대 16자리까지, 숫자, 영문 대소문자, 특수문자가 각 1 문자 이상 포함되어야 함)</p>
                            </td>
                        </tr>
                        <tr>
                            <th><label for="pw2">비밀번호 확인</label></th>
                            <td><input type="password" name="pw2" id="pw2"  class="single100" value="" required></td>
                        </tr>
                        <tr>
                            <th><label for="name">이름</label></th>
                            <td><input type="text" name="name" id="name" class="single100"  value="${cus.name }" required></td>
                        </tr>
                        <tr>
                            <th><label for="email">이메일</label></th>
                            <td><input type="email" name="email" id="email" class="single100" value="${cus.email }" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required></td>
                        </tr>
                        <tr>
                            <th><label for="tel">전화번호</label></th>
                            <td><input type="tel" name="tel" id="tel" class="single100"  value="${cus.tel }" pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}" required></td>
                        </tr>
                        <tr>
                            <th><label for="" onclick="findAddr()">주소</label></th>
                            <td>
                                <input type="text" name="addr1" id="addr1" class="single100" value="${addr1 }"><br>
                                <input type="text" name="addr2" id="addr2" class="single100" value="${addr2 }"><br>
                                <input type="text" name="postcode" id="postcode"  class="single40" value="${cus.postcode }">
                                <input type="button" value="주소찾기" onclick="findAddr()" class="btn btn-primary">
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" class="button btn-writer" value="회원정보수정">
                                <a href="${path1 }/custom/myInfo.do" class="button btn-primary">취소</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>
            <script>
                function updateCheck(f){
                    if(f.userpw.value!=f.userpw2.value){
                        alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
                        return false;
                    }
                }
            </script>
            <script>
                function findAddr() {
                    new daum.Postcode({
                        oncomplete: function(data) {
                            console.log(data);
                            var roadAddr = data.roadAddress;
                            var jibunAddr = data.jibunAddress;
                            document.getElementById("postcode").value = data.zonecode;
                            if(roadAddr !== '') {
                                document.getElementById("addr1").value = roadAddr;
                            } else if(jibunAddr !== ''){
                                document.getElementById("addr1").value = jibunAddr;
                            }
                        }
                    }).open();
                }
            </script>
            <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
        </div>
    </div>
</div>
<footer id="footer" class="footer-nav row expanded collapse">

</footer>
</body>
</html>