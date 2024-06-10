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
    <title>결제 목록</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
    <h2>결제 목록</h2>
    <table border="1">
        <thead>
        <tr>
            <th>결제 ID</th>
            <th>사용자 ID</th>
            <th>금액</th>
            <th>상태</th>
            <th>결제일</th>
            <th>액션</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="payment" items="${payments}">
            <tr>
                <td>${payment.paymentId}</td>
                <td>${payment.userId}</td>
                <td>${payment.amount}</td>
                <td>${payment.status}</td>
                <td>${payment.createdAt}</td>
                <td>
                    <a href="${path2 }/payments/detail?paymentId=${payment.paymentId}">상세</a>
                    <a href="${path2 }/payments/delete?paymentId=${payment.paymentId}">삭제</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="${path2 }/payments/create">새 결제 추가</a>
</body>
</html>