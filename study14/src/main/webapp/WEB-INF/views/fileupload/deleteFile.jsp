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
    <title>이미지 삭제</title>
</head>
<body>
    <h3>기존 이미지:</h3>
    <hr>
	<c:forEach var="image" items="${product.images}">
	    <div>
	        <img src="${path0}/resources/uploads/${image.uuidName}" alt="${image.name}" style="width: 100px;">
	        <a href="${path0}/fileupload/deleteFile?fileName=${image.uuidName}">삭제</a>
	    </div>
	</c:forEach>
    <hr>
    <a href="${path0}">홈으로</a>
</body>
</html>