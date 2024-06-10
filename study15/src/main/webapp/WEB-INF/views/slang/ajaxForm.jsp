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
	<title>AJAX 비속어 필터링</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>Ajax Submit Content</h1>
	
	<textarea id="content" rows="6" cols="80"></textarea>
	<br>
	<button id="submitBtn">Submit</button>
	<br>
	<div id="result"></div>
	<script>
	    $(document).ready(function () {
	        $("#submitBtn").click(function () {
	            var content = $("#content").val();
	
	            $.ajax({
	                type: "POST",
	                url: "${path2}/slang/submitContent2",
	                contentType: "text/plain; charset=UTF-8",
	                data: content,
	                dataType: "json",
	                success: function (response) {
	                    // 서버로부터 응답을 받으면 필터링된 내용을 표시
	                    console.log(response.filteredContent);
	                    $("#result").html(response.filteredContent);
	                },
	                error: function (xhr, status, error) {
	                    // 에러 처리
	                    $("#result").html("Error: " + xhr.responseText);
	                }
	            });
	        });
	    });
	</script>

</body>
</html>