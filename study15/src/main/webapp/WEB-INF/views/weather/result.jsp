<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 결과</title>
</head>
<body>
    <h1>날씨 예보 결과</h1>
    <ul>
        <li>기온(℃) : ${weather.t1h}</li>
        <li>1시간 강수량 : ${weather.rn1}</li>
        <li>습도(%) : ${weather.reh}</li>
        <li>풍향(deg) : ${weather.vec}</li>
        <li>풍속(m/s) : ${weather.wsd}</li>
    </ul>
    <a href="${path2}">홈으로</a>
</body>
</html>