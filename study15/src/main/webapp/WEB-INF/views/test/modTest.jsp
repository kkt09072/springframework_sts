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
<title>테스트 수정하기</title>
</head>
<body>
	<h2>테스트 수정하기</h2>
	<hr>
	<div class="test">
		<form name="modifyForm" action="${path2 }/test/modTestPro.do" method="post">
			<p>번호 : <input type="text" name="num" id="num" value="${test.num }" readonly /></p>
			<p>제목 : <input type="text" name="title" id="title" value="${test.title }" /></p>
			<p>일시 : <input type="text" name="res" id="res" value="${test.res }" readonly /></p>
			<input type="submit" value="테스트 수정">		
		</form>
	</div>
	<hr><br>
	<a href="${path2 }/test/testList.do">테스트 목록으로</a><br>
</body>
</html>