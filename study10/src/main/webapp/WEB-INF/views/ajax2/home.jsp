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
<title>Ajax2 메인 페이지</title>
</head>
<body>
	<h2>Ajax2 메인</h2>
	<hr>
	<ul>
		<li><a href="${path2 }/ajax2/ajax1.do">API1 테스트</a></li>
		<li><a href="${path2 }/ajax2/ajax2.do">API2 테스트</a></li>
		<li><a href="${path2 }/ajax2/ajax3.do">API3 테스트</a></li>
		<li><a href="${path2 }/ajax2/ajax4.do">API4 테스트</a></li>
		<li><a href="${path2 }/ajax2/ajax5.do">API5 테스트</a></li>
		<li><a href="${path2 }/ajax2/ajax6.do">API6 테스트</a></li>
		<li><a href="${path2 }/ajax2/ajax7.do">API7 테스트</a></li>
		<li><a href="${path2 }/ajax2/ajax8.do">API8 테스트</a></li>
		<li><a href="${path2 }/ajax2/ajax9.do">API9 테스트</a></li>
		<li><a href="${path2 }/ajax2/ajax10.do">API10 테스트</a></li>
	</ul>
	<hr>	
</body>
</html>