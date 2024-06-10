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
<title>상점 등록</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<div class="form">
		<input type="number" name="storeNum" id="num" placeholder="번호 입력" /><br><br>
		<input type="text" name="storeName" id="name" placeholder="상점명 입력" /><br><br>
		<button type="button" id="btn1">등록</button>
	</div>
	<table>
		<thead>
			<th>번호</th><th>상점명</th>
		</thead>
		<tbody id="tbody">
			
		</tbody>
	</table>
	<script>
	$(document).ready(function(){
		$("#btn1").click(function(){
			var store = {storeNum:parseInt($("#num").val()), storeName:$("#name").val() };
			$.ajax({
				type:"post",
				url:"${path2}/api/api5.do",
				data:JSON.stringify(store),
				dataType:"json",
			    contentType: 'application/json; charset=utf-8', 
				success:function(data) { 
					console.log(data);
					var tbody = $("#tbody").html();
					var conData = "<tr><td>"+data.storeNum+"</td><td>"+data.storeName+"</td></tr>";
					$("#tbody").html(tbody+conData);
				}
			});
		});
	});
	</script>
</body>
</html>