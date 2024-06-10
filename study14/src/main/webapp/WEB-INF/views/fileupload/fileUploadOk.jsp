<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="path0" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>파일 업로드 성공</title>
</head>
<body>
    <h2>파일 업로드 성공</h2>

	<div>
		<ul>
			<li>${fileRealName }</li>
			<li>${size }</li>
			<li>${uuid }</li>
			<li>${uuidName }</li>
		</ul>
	</div>
	<a href="${path0 }">홈으로</a>
</body>
</html>