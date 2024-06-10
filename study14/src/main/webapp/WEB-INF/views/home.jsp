<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h2>${serverTime }</h2>
	<h2>${author }</h2>
	<h2>${company }</h2>
	<p>${msg }</p>	
	<hr>
	<ul>
		<li><a href="${path2 }/custom/login.do">로그인</a></li>
		<li><a href="${path2 }/fileupload/main">파일 업로드 실습</a></li>
		<li><a href="${path2 }/email/main">이메일 보내기 실습</a></li>
		<li><a href="${path2 }/free/list.do">CKEditor를 활용한 자유게시판 실습</a></li>
		<li><a href="${path2 }/payments/list">결제 실습</a></li>
		<li><a href="${path2 }/socket.do">채팅 테스트</a></li>
		<li><a href="${path2 }/websocket">채팅 실습</a></li>
		<li><a href="${path2 }/sockjs">채팅 실습2</a></li>
		<li><a href="${path2 }/stomp">채팅 실습3</a></li>
	</ul>
</body>
</html>