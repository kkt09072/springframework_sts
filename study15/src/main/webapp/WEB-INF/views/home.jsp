<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h2>${serverTime }</h2>
	<h2>${author }</h2>
	<h2>${company }</h2>
	<p>${msg }</p>	
	<hr>
	<ul>
		<li><a href="${path2 }/slang/form">비속어 필터링</a></li>
		<li><a href="${path2 }/slang/form2">비속어 필터링2</a></li>
		<li><a href="${path2 }/img/upload">이미지 업로드 스케일링</a></li>
		<li><a href="${path2 }/img/upload2">이미지 편집 업로드</a></li>
		<li><a href="${path2 }/crawl">웹크롤링</a></li>
		<li><a href="${path2 }/chart/charts">구글 차트</a></li>
		<li><a href="${path2 }/pdf/">PDF 생성 실습</a></li>
		<li><a href="${path2 }/weather/home">날씨 예보</a></li>
	</ul>
</body>
</html>