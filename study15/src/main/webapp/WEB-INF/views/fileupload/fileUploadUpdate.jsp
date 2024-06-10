<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path0" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 정보 및 이미지 변경</title>
</head>
<body>
    <h2>상품 정보 및 이미지 변경</h2>
    <form action="${path0}/fileupload/updatePro" method="post" enctype="multipart/form-data">
        <input type="hidden" name="productId" value="${product.id}">
        <label for="productName">상품명:</label>
        <input type="text" id="productName" name="productName" value="${product.name}"><br><br>
        <label for="description">설명:</label>
        <textarea id="description" name="description">${product.description}</textarea><br><br>
        <label for="price">가격:</label>
        <input type="number" id="price" name="price" value="${product.price}"><br><br>
        <label for="files">새로운 이미지 선택:</label>
        <input type="file" id="files" name="files" multiple><br><br>
        <h3>기존 이미지:</h3>
        <c:forEach var="image" items="${product.images}">
            <div>
                <img src="${path0}/resources/upload/${image.uuidName}" alt="${image.name}" style="width: 100px;">
                <input type="checkbox" name="deleteFiles" value="${image.uuidName}"> 삭제
            </div>
        </c:forEach>
        <button type="submit">업로드</button>
    </form>
    <hr>
    <a href="${path0}">홈으로</a>
</body>
</html>