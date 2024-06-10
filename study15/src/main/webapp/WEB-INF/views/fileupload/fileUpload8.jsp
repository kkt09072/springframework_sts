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
    <title>상품 정보 및 이미지 업로드</title>
</head>
<body>
    <h2>상품 정보 및 이미지 업로드</h2>
    <form action="${path0 }/fileupload/uploadPro8" method="post" enctype="multipart/form-data">
        <label for="productName">상품명:</label>
        <input type="text" id="productName" name="productName"><br><br>
        <label for="description">설명:</label>
        <textarea id="description" name="description"></textarea><br><br>
        <label for="price">가격:</label>
        <input type="number" id="price" name="price"><br><br>
        <label for="files">이미지 선택:</label>
        <input type="file" id="files" name="files" multiple><br><br>
        <button type="submit">업로드</button>
    </form>
    <hr>
    <a href="${path0}">홈으로</a>
</body>
</html>