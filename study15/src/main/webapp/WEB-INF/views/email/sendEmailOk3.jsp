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
<title>이메일 보내기3 결과</title>
</head>
<body>
<div id="contents">
	<section class="page" id="page1">
		<div style="width:1400px; margin:0 auto;">
			<h3 class="page_title">이메일 보내기3 결과</h3>
				<table class="table">
					<tbody>
						<c:if test="${ps }">
						<tr>
							<th><label for="name">작성자 이름</label></th>
							<td>
								${name }
							</td>
						</tr>
						<tr>
							<th><label for="from">작성자 이메일</label></th>
							<td>
								${from }
							</td>
						</tr>
						<tr>
							<th><label for="to">받는 사람 이메일</label></th>
							<td>
								${to }
							</td>
						</tr>
						<tr>
							<th><label for="subject">이메일 제목</label></th>
							<td>
								${subject }
							</td>
						</tr>
						<tr>
							<th><label for="content">이메일 내용</label></th>
							<td>
								${content }
							</td>
						</tr>
						<tr>
							<th><label for="filename">파일 이름</label></th>
							<td>
								${filename }
							</td>
						</tr>
						<tr>
							<th><label for="size">파일 크기</label></th>
							<td>
								${size } Byte
							</td>
						</tr>
						</c:if>
						<c:if test="${not ps }">
							<tr>
								<td colspan="2">이메일 보내기 실패</td>
							</tr>
						</c:if>
					</tbody>
				</table>
				
				<hr>
				<div class="btn-group">
				  <a href="${path2 }/email/email3" class="btn btn-secondary">이메일 폼으로 가기</a>
				  <a href="${path2 }" class="btn btn-secondary">홈으로</a>
				</div>
		</div>
	</section>
</div>
</body>
</html>