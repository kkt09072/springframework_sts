<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="path0" value="<%=request.getContextPath() %>" />    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>게시판 글 수정</title>
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
			<h3 class="page_title">게시판 글 수정</h3>
			<form action="${path0 }/EditProNotice.do" method="post">
				<table class="table">
					<tbody>
						<tr>
							<th><label for="no">글 번호</label></th>
							<td>
								<input type="text" name="no" id="no" class="form-control" maxlength="100" value="${board.bno }" readonly>
							</td>
						</tr>
						<tr>
							<th><label for="title">제목</label></th>
							<td>
								<input type="text" name="title" id="title" class="form-control" maxlength="100" value="${board.title }" required>
							</td>
						</tr>
						<tr>
							<th><label for="content">내용</label></th>
							<td>
								<textarea name="content" id="content" rows="8" cols="80" class="form-control">${board.content }</textarea>
							</td>
						</tr>
						<tr>
							<th><label for="resdate">작성일시</label></th>
							<td>
								<input type="text" name="resdate" id="resdate" class="form-control" value="${board.resdate }" disabled>
							</td>
						</tr>
						<tr>
							<th><label for="visited">읽은횟수</label></th>
							<td>
								<input type="text" name="visited" id="visited" class="form-control" value="${board.vcnt }" disabled>
							</td>
						</tr>
					</tbody>
				</table>
				<hr>
				<div class="btn-group">
				  <button type="submit" class="btn btn-secondary">글 수정</button>
				  <a href="${path0 }/NoticeList.do" class="btn btn-secondary">글 목록</a>
				  <a href="${path0 }/GetNotice.do?no=${noti.no} " class="btn btn-secondary">글 상세보기</a>
				</div>
			</form>
		</div>
	</section>	
</div>
<footer id="footer" class="footer-nav row expanded collapse">

</footer>
</body>
</html>