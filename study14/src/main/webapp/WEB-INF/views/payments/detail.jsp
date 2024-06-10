<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>결제 상세보기</title>
	<script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <h2>결제 상세</h2>
    <hr>
    <p>결제 ID: ${payment.paymentId}</p>
    <p>사용자 ID: ${payment.userId}</p>
    <p>금액: ${payment.amount}</p>
    <p>상태: ${payment.status}</p>
    <p>결제일: ${payment.createdAt}</p>
    <p>수정일: ${payment.updatedAt}</p>
    <a href="${path2 }/payments/list">목록으로</a>
</body>
</html>