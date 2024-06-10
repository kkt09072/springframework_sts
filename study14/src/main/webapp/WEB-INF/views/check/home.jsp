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
	<h2>Form 검증</h2>
	<hr>
	<ul>
		<li><a href="${path2 }/check/check1.do">Check 폼 검증 테스트1</a></li>
		<li><a href="${path2 }/check/check2.do">Check 폼 검증 테스트2</a></li>
		<li><a href="${path2 }/check/check3.do">Check 폼 검증 테스트3</a></li>
		<li><a href="${path2 }/check/check4.do">Check 폼 검증 테스트4</a></li>
		<li><a href="${path2 }/check/check5.do">Check 폼 검증 테스트5</a></li>
		<li><a href="${path2 }/check/check6.do">Check 폼 검증 테스트6</a></li>
	</ul>
	<hr>	
</body>
</html>