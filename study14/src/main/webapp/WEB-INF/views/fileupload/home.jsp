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
<title>파일 업로드 실습</title>
</head>
<body>
<div id="contents">
	<section class="page" id="page1">
		<div style="width:1400px; margin:0 auto;">
			<h3 class="page_title">파일 업로드 실습</h3>
			<ul>
				<li><h3>로컬 시스템에 업로드</h3></li>
				<li><a href="${path2 }/fileupload/upload">파일 업로드 테스트1 - 하나의 파일</a></li>
				<li><a href="${path2 }/fileupload/upload2">파일 업로드 테스트2 - 여러 파일</a></li>
				<li><a href="${path2 }/fileupload/upload3">파일 업로드 테스트3 - 자료실 파일 첨부</a></li>
				<li><a href="${path2 }/fileupload/upload4">파일 업로드 테스트4 - 상품 정보 여러 파일 첨부</a></li>
				<li><hr></li>
				<li><h3>서버 시스템에 업로드</h3></li>
				<li><a href="${path2 }/fileupload/upload5">파일 업로드 테스트5 - 하나의 파일</a></li>
				<li><a href="${path2 }/fileupload/upload6">파일 업로드 테스트6 - 여러 파일</a></li>
				<li><a href="${path2 }/fileupload/upload7">파일 업로드 테스트7 - 자료실 파일 첨부</a></li>
				<li><a href="${path2 }/fileupload/upload8">파일 업로드 테스트8 - 상품 정보 여러 파일 첨부</a></li>
				<li><hr></li>
				<li><h3>서버 시스템에 파일 변경/삭제</h3></li>
				<li><a href="${path2 }/fileupload/update">파일 업로드 테스트9 - 상품 정보 파일 변경</a></li>
				<li><a href="${path2 }/fileupload/delete">파일 업로드 테스트10 - 상품 이미지 삭제</a></li>
			</ul>
			<hr>
			<a href="${path2 }">홈으로</a>
		</div>
	</section>
</div>
</body>
</html>