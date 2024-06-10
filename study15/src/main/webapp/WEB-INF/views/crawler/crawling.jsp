<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <title>Crawling Result</title>
</head>
<body>
    <h2>Crawling Result</h2>
    <c:choose>
        <c:when test="${not empty jsonData}">
            <p>JSON Data:</p>
            <pre>${jsonData}</pre>
        </c:when>
        <c:otherwise>
            <p>No data found.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>