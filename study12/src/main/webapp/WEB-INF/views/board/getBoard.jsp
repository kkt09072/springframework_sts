<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="path0" value="<%=request.getContextPath() %>" />    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>게시판 글 상세보기</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <link rel="stylesheet" href="resources/css/normalize.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/motion-ui/1.2.3/motion-ui.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/css/foundation-prototype.min.css">
    <link href='https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css' rel='stylesheet' type='text/css'>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.4.3/js/foundation.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/motion-ui/1.2.3/motion-ui.min.js"></script>
</head>
<body>
<header id="header">
	<a href="${path0 }">메인으로</a>
</header>
<div id="contents">
	<section class="page" id="page1">
		<div style="width:1400px; margin:0 auto;">
			<h3 class="page_title">게시판 글 상세보기</h3>
			<div>
				<table class="table">
					<tbody>
						<tr>
							<th>글 번호</th>
							<td></td>
						</tr>
						<tr>
							<th>글 제목</th>
							<td></td>
						</tr>
						<tr>
							<th>글 내용</th>
							<td></td>
						</tr>
						<tr>
							<th>작성일시</th>		
							<td></td>
						</tr>
						<tr>
							<th>조회수</th>
							<td></td>
						</tr>
					</tbody>
				</table>
				<hr>
				<div class="btn-group">
				  <c:if test="${cus.id.equals('admin') }">
				  <a href="${path0 }/board/insBoard.do" class="btn btn-secondary">글 등록</a>
				  <a href="${path0 }/board/editBoard.do?bno=${board.bno }" class="btn btn-secondary">글 수정</a>
				  <a href="${path0 }/board/delBoard.do?bno=${board.bno }" class="btn btn-secondary">글 삭제</a>
				  </c:if>
				  <a href="${path0 }/board/boardList.do" class="btn btn-secondary">글 목록</a>
				</div>
			</div>
		</div>
	</section>	
</div>
<footer id="footer" class="footer-nav row expanded collapse">

</footer>
</body>
</html>