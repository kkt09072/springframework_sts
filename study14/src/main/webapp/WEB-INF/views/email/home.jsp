<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 보내기 실습</title>
</head>
<body>
<div id="contents">
	<section class="page" id="page1">
		<div style="width:1400px; margin:0 auto;">
			<h3 class="page_title">이메일 보내기 실습</h3>
			<ul>
				<li><h3>네이버 이메일 보내기</h3></li>
				<li><a href="${path2 }/email/email1">1. MimeMessage 객체 메일 발송</a></li>
				<li><a href="${path2 }/email/email2">2. MimeMessagePreparator 이용하여 메일 발송</a></li>
				<li><a href="${path2 }/email/email3">3. 이미지를 내장하여 이메일 발송</a></li>
				<li><a href="${path2 }/email/email4">4. 파일을 첨부하여 이메일 발송</a></li>
				<li><a href="${path2 }/email/email5">5. 이메일 인증번호 보내기</a></li>
				<li><hr></li>
				<li><h3>지메일 보내기</h3></li>
				<li><a href="${path2 }/email/email11">1. MimeMessage 객체 메일 발송</a></li>
				<li><a href="${path2 }/email/email12">2. MimeMessagePreparator 이용하여 메일 발송</a></li>
				<li><a href="${path2 }/email/email13">3. 이미지를 내장하여 이메일 발송</a></li>
				<li><a href="${path2 }/email/email14">4. 파일을 첨부하여 이메일 발송</a></li>
				<li><a href="${path2 }/email/email15">5. 이메일 인증번호 보내기</a></li>
				<li><hr></li>
				<li><h3>다음 이메일 보내기</h3></li>
				<li><a href="${path2 }/email/email21">1. MimeMessage 객체 메일 발송</a></li>
				<li><a href="${path2 }/email/email22">2. MimeMessagePreparator 이용하여 메일 발송</a></li>
				<li><a href="${path2 }/email/email23">3. 이미지를 내장하여 이메일 발송</a></li>
				<li><a href="${path2 }/email/email24">4. 파일을 첨부하여 이메일 발송</a></li>
				<li><a href="${path2 }/email/email25">5. 이메일 인증번호 보내기</a></li>
				<li><hr></li>
			</ul>
			<hr>
			<a href="${path2 }">홈으로</a>
		</div>
	</section>
</div>
</body>
</html>