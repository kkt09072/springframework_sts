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
<title>지메일 보내기2</title>
</head>
<body>
<div id="contents">
	<section class="page" id="page1">
		<div style="width:1400px; margin:0 auto;">
			<h3 class="page_title">지메일 보내기2</h3>
			<form action="${path2 }/email/sendEmail12" method="post">
				<table class="table">
					<tbody>
						<tr>
							<th><label for="author">작성자 아이디</label></th>
							<td>
								<input type="text" name="author" id="author" class="form-control" maxlength="100" required>
							</td>
						</tr>
						<tr>
							<th><label for="name">작성자 이름</label></th>
							<td>
								<input type="text" name="name" id="name" class="form-control" maxlength="100" required>
							</td>
						</tr>
						<tr>
							<th><label for="from">작성자 이메일</label></th>
							<td>
								<input type="email" name="from" id="from" class="form-control" maxlength="100" required>
							</td>
						</tr>
						<tr>
							<th><label for="to">받는 사람 이메일</label></th>
							<td>
								<input type="email" name="to" id="to" class="form-control" value="kkt09072@naver.com" maxlength="100" readonly>
							</td>
						</tr>
						<tr>
							<th><label for="tel">연락처</label></th>
							<td>
								<input type="tel" name="tel" id="tel" class="form-control" maxlength="100" required>
							</td>
						</tr>
						<tr>
							<th><label for="subject">이메일 제목</label></th>
							<td>
								<input type="text" name="subject" id="subject" class="form-control" maxlength="100" required>
							</td>
						</tr>
						<tr>
							<th><label for="content">이메일 내용</label></th>
							<td>
								<textarea name="content" id="content" rows="8" cols="80" class="form-control"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<hr>
				<div class="btn-group">
				  <button type="submit" class="btn btn-secondary">이메일 발송</button>
				</div>
			</form>
		</div>
	</section>
</div>
</body>
</html>