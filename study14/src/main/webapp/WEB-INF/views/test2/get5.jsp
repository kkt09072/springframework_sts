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
<title>Get 테스트5</title>
</head>
<body>
	<h2>Get 테스트 - ModelAndView</h2>
	<hr>
	<div class="test">
		<p>번호 : ${num }</p>
		<p>제목 : ${title }</p>
	</div>
	<hr><br>
	<a href="${path2 }">홈으로</a><br>
</body>
</html>