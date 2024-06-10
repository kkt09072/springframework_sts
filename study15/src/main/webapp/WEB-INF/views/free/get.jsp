<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>자유게시판 상세보기</title>
	<script src="https://code.jquery.com/jquery-latest.js"></script>
	<script src="${path2}/resources/js/ckeditor/ckeditor.js"></script>
</head>
<body>
<div class="full-wrap">
    <main id="contents" class="contents">
       	<div id="breadcrumb" class="container breadcrumb-wrap clr-fix" style="height:60px; line-height:60px;">
	    	<nav class="breadcrumb" aria-label="breadcrumbs">
			  <ul>
			    <li><a href="${path2 }">Home</a></li>
			    <li><a href="${path2 }/free/list.do">자유게시판</a></li>
			    <li class="is-active"><a href="#" aria-current="page">상세보기</a></li>
			  </ul>
			</nav>
    	</div>
 	    <section class="page" id="page1">
    		<h2 class="page-title">자유게시판 글 상세보기</h2>
    		<div class="page-wrap">
 				<div class="clr-fix">
					<table id="tb1" class="table" width="1200">
						<tbody>
							<tr>
								<th>글 번호</th>
								<td>${free.no }</td>
							</tr>
							<tr>
								<th>글 제목</th>
								<td>${free.title }</td>
							</tr>
							<tr>
								<th>글 내용</th>
								<td>${free.content }</td>
							</tr>
							<tr>
								<th>작성일시</th>		
								<td>${free.resdate }</td>
							</tr>
							<tr>
								<th>조회수</th>
								<td>${free.hits }</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${free.id } / ${free.name }</td>
							</tr>
						</tbody>
					</table>
					<hr>
					<div class="buttons">
					  <c:if test="${not empty cus.id }">
					  <a href="${path2 }/free/insert.do" class="button is-danger">글 등록</a>
					  </c:if>
					  <c:if test="${cus.id.equals('admin') or cus.id.equals(free.id)}">    
					  <a href="${path2 }/free/update.do?no=${free.no }" class="button is-warning">글 수정</a>
					  <a href="${path2 }/free/delFree.do?no=${free.no }" class="button is-danger is-dark">글 삭제</a>
					  </c:if>
					  <a href="${path2 }/free/list.do" class="button is-primary">글 목록</a>
					</div>
				</div>
    		</div>
    	</section>
    </main>
    <script>
    $(document).ready(function(){
    	$("#tb1_length, #tb1_filter").css("margin-bottom", "20px");
    });
    </script>
</div>    
</body>
</html>