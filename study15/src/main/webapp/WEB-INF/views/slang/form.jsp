<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비속어 필터링 입력 폼</title>
</head>
<body>
	<form name="form1" action="${path2 }/slang/submitContent" method="post">
		<h3>하고 싶은 말</h3>
		<textarea name="content" id="content" rows="6" cols="80">
		
		</textarea><br><br>
		<button type="submit">작성</button>
	</form>
</body>
</html>