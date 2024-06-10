<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <title>PDF Generator</title>
</head>
<body>
    <h1>Generate PDF</h1>
    <hr>
    <form action="generatePdf" method="post">
        <label for="text">Text to add to PDF:</label><br>
        <textarea id="text" name="text" rows="8" cols="80"></textarea><br>
        <button type="submit">Generate PDF</button>
    </form>
</body>
</html>