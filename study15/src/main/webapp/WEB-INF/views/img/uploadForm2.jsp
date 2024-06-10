<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <title>Image Upload2</title>
</head>
<body>
    <h2>Upload an Image</h2>
    <form method="post" enctype="multipart/form-data" action="${path2}/img/uploadPro2">
        <label for="file">File:</label>
        <input type="file" name="file" id="file" /><br/>
        
        <label for="brightness">Brightness:</label>
        <input type="range" name="brightness" id="brightness" min="-1.0" max="1.0" step="0.1" value="0.0" /><br/>
        
        <label for="saturation">Saturation:</label>
        <input type="range" name="saturation" id="saturation" min="-1.0" max="1.0" step="0.1" value="0.0" /><br/>
        
        <label for="hue">Hue:</label>
        <input type="range" name="hue" id="hue" min="-1.0" max="1.0" step="0.1" value="0.0" /><br/>
        
        <input type="submit" value="Upload and Edit" />
    </form>
</body>
</html>