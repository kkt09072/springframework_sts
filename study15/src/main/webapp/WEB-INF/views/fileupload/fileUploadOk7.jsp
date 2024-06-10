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
    <title>파일 글 업로드 성공</title>
</head>
<body>
    <h2>파일 글 업로드 성공</h2>
	<hr>
    <div class="item">
        <ul>
            <li>제목: ${title}</li>
		    <li>내용: ${content}</li>
		    <li>파일명: ${fileRealName}</li>
		    <li>파일 크기: ${size} bytes</li>
		    <li>저장된 파일 경로: ${uuidName}</li>
        </ul>
        <hr>
    </div>
	<a href="${path0 }">홈으로</a>
</body>
</html>