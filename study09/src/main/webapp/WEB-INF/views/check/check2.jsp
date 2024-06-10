<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>자바스크립트에서 유효성 검사 - check2.jsp</title>
</head>
<body>
    <div class="container">
        <h2>javascript를 이용한 폼 유효성 검증</h2>
        <hr>
        <form action="./check2pro.do" method="post" onsubmit="return loginCheck(this)">
            <!-- 영문 소문자와 숫자 조합 글자 길이 5~12 글자 사이의 유효성 패턴 -->
            id : <input type="text" name="id" id="id" /><br><br>
            <!-- 영문 소문자 대문자, 숫자 조합 8~12 글자 사이의 유효성 패턴 -->
            pw : <input type="password" name="pw" id="pw" /><br><br>
            <button type="submit">확인</button>
        </form>
        <script>
        var loginCheck = function(f){
            var id = f.id.value;
            var pw = f.pw.value;
            if(id=="" || pw==""){
                alert("아이디 또는 비밀번호 입력 칸이 비어 있습니다.");
                return false;
            }
            if(id.length<5 || id.length>12){
                alert("아이디의 글자 수가 맞지 않습니다. 5~12글자 사이로 입력하시기 바랍니다.");
                return false;
            }
            if(pw.length<8 || pw.length>12){
                alert("비밀번호의 글자 수가 맞지 않습니다. 8~12글자 사이로 입력하시기 바랍니다.");
                return false;
            }   //써큠플렉스(circumflex) = ^ = 위꺽쇠
            var idReg = /^[a-z0-9]{5,12}$/g;    //정규표현식(유효성검증식)
            if(!idReg.test(id)){
                alert("아이디 입력 형식이 맞지 않습니다.");
                return;
            }
            var pwReg = /^[a-zA-Z0-9]{8,12}$/g;
            if(!pwReg.test(pw)){
                alert("비밀번호 입력 형식이 맞지 않습니다.");
                return;
            }
        }
        </script>
    </div>
</body>
</html>
