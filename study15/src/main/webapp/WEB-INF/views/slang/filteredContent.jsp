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
<title>비속어 필터링 결과</title>
</head>
<body>
<body>
    <h1>비속어 필터링 결과</h1>
    <p>입력한 내용: ${filteredContent}</p>
    <a href="${path2 }/slang/form">입력 폼으로 이동</a><br>
    <a href="${path2 }">홈으로 이동</a>
</body>
</html>