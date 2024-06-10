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
	<hr>
	<ul>
		<li><a href="${path2 }/api/api1.do">API1 테스트</a></li>
		<li><a href="${path2 }/api/api2.do">API2 테스트</a></li>
		<li><a href="${path2 }/api/api3.do">API3 테스트</a></li>
		<li><a href="${path2 }/api/api4.do">API4 테스트</a></li>
		<li><a href="${path2 }/api/sub/api5">API5 테스트</a></li>
		<li><a href="${path2 }/api/sub/api6">API6 테스트</a></li>
		<li><a href="${path2 }/api/sub/api7">API7 테스트</a></li>
		<li><a href="${path2 }/api/sub/api8">API8 테스트</a></li>
		<li><a href="${path2 }/api/sub/api9">API9 테스트</a></li>
		<li><a href="${path2 }/api/sub/api10">API10 테스트</a></li>
		<li><a href="${path2 }/api/sub/api11">API11 테스트</a></li>
		<li><a href="${path2 }/api/sub/api12">API12 테스트</a></li>
		<li><a href="${path2 }/api/sub/api13">API13 테스트</a></li>
		<li><a href="${path2 }/api/sub/api14">API14 테스트</a></li>
		<li><a href="${path2 }/api/sub/api15">API15 테스트</a></li>
	</ul>
	<hr>	
</body>
</html>