<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <title>Upload Result</title>
</head>
<body>
    <h2>${message}</h2>
    <c:if test="${not empty originalFile}">
        <p>Original File: <a href="${path2}/resources/upload/${originalFile}">${originalFile}</a></p>
        <p>Resized File: <a href="${path2}/resources/upload/${resizedFile}">${resizedFile}</a></p>
    </c:if>
</body>
</html>