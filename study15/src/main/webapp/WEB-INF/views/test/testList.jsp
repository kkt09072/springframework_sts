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
<title>테스트 목록</title>
</head>
<body>
	<h2>${mapper }</h2>
	<c:forEach var="test" items="${list}">
		<p>번호 : ${test.num }</p>
		<p>제목 : <a href="${path2}/test/getTest.do?num=${test.num }">${test.title }</a></p>
		<p>일시 : ${test.res }</p>
		<hr>
	</c:forEach>
	<br><hr><br>
	<a href="${path2 }/test/insTest.do">테스트 추가</a>
</body>
</html>