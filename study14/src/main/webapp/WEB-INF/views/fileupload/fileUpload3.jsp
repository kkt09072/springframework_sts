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
    <title>파일 및 글 업로드</title>
</head>
<body>
    <h2>파일 및 글 업로드</h2>
	
	<!-- 파일 두 개이상 붙히는거 -->
	<h2>파일 및 글 업로드</h2>
    <form action="${path0}/fileupload/uploadPro3" method="post" enctype="multipart/form-data">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title"><br><br>
        <label for="content">내용:</label>
        <textarea id="content" name="content"></textarea><br><br>
        <label for="file">파일 선택:</label>
        <input type="file" id="file" name="file"><br><br>
        <button type="submit">업로드</button>
    </form>
	
	<a href="${path0 }">홈으로</a>
</body>
</html>