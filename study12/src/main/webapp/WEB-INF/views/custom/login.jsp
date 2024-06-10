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
    <title>로그인</title>
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

</header>

<div class="content" id="con">
    <div class="row column text-center">
        <h2 class="h1">로그인</h2>
        <hr>
        <div class="container">
            <form action="${path1 }/custom/loginPro.do" method="post" name="loginForm">
                <div class="table_form_wrap">
                    <table class="table_form">
                        <tbody>
                        <tr>
                            <th><label for="id">아이디</label></th>
                            <td><input type="text" name="id" id="id" size="100" class="single100" placeholder="아이디 입력" required>
                                <!--  pattern="^[a-z0-9]+$"  -->
                            </td>
                        </tr>
                        <tr>
                            <th><label for="pw">비밀번호</label></th>
                            <td><input type="password" name="pw" id="pw"  class="single100" placeholder="비밀번호 입력" required>
                                <!--  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"  -->
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" class="button" value="로그인">
                                <input type="reset" class="button" value="취소">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>
            <script>
                function loginFaiure() {
                    alert("로그인 실패");
                }
            </script>
        </div>
    </div>
</div>
<footer id="footer" class="footer-nav row expanded collapse">

</footer>
</body>
</html>