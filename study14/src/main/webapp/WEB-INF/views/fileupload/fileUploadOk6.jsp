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
    <title>파일 업로드 성공2</title>
</head>
<body>
    <h2>파일 업로드 성공2</h2>

    <c:choose>
        <c:when test="${not empty datas}">
            <c:forEach var="data" items="${datas}">
                <div class="item">
                    <ul>
                        <li>${data.name}</li>
                        <li>${data.size} Byte</li>
                    </ul>
                    <hr>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>업로드된 파일이 없습니다.</p>
        </c:otherwise>
    </c:choose>
	<a href="${path0 }">홈으로</a>
</body>
</html>