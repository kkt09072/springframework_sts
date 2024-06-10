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
        <title>상품 정보 업로드 성공</title>
</head>
<body>
    <h2>상품 정보 업로드 성공</h2>
    <p>상품명: ${product.name}</p>
    <p>설명: ${product.description}</p>
    <p>가격: ${product.price}</p>
    <h3>이미지 목록:</h3>
    <c:forEach var="image" items="${product.images}">
        <div class="item">
            <ul>
                <li>파일명: ${image.name}</li>
                <li>파일 크기: ${image.size} bytes</li>
            </ul>
            <hr>
        </div>
    </c:forEach>
    <a href="${path0}">홈으로</a>
</body>
</html>