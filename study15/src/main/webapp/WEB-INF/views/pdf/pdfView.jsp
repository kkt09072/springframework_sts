<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <title>PDF Generated</title>
</head>
<body>
    <h1>PDF Generated Successfully</h1>
    <hr>
    <p>Your PDF has been generated and saved at: <c:out value="${pdfPath}"/></p>
    <a href="${path2}/pdf/">Go Back</a>
</body>
</html>