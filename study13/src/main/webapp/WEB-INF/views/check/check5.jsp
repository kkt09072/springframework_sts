<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path1" value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Springframework Validator에서 @initBinder+@Valid 유효성 검사 - check5.jsp</title>
</head>
<body>
<div class="container">
    <h2>Springframework Validator에서 @initBinder+@Valid 유효성 검사</h2>
    <hr>
    <p>입력값을 다시 확인해주세요.</p>
    <form:form action="${path1}/check/check5pro.do" method="post" modelAttribute="check">
        아이디 : <form:input path="id" /><br>
        <form:errors path="id" element="div" /><br>
        비밀번호 : <form:password path="pw" /><br>
        <form:errors path="pw" element="div" /><br>
        <button type="submit" id="submit-btn">확인</button>
    </form:form>
</div>
</body>
</html>
