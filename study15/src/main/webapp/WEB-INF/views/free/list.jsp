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
    <title>자유게시판 목록</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<div class="full-wrap">
    <main id="contents" class="contents">
        <div id="breadcrumb" class="container breadcrumb-wrap clr-fix" style="height:60px; line-height:60px;">
            <nav class="breadcrumb" aria-label="breadcrumbs">
                <ul>
                    <li><a href="${path2}">Home</a></li>
                    <li><a href="${path2}/free/list.do">Notice</a></li>
                    <li class="is-active"><a href="#" aria-current="page">List</a></li>
                </ul>
            </nav>
        </div>
        <section class="page" id="page1">
            <h2 class="page-title">자유게시판 목록</h2>
            <div class="page-wrap">
                <div class="clr-fix">
                    <br>
                    <table class="table" id="tb1">
                        <thead>
                            <tr>
                                <th class="item1">번호</th>
                                <th class="item2">제목</th>
                                <th class="item3">작성일</th>
                                <th class="item4">조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${not empty list}">
                                <c:forEach var="dto" items="${list}">
                                    <tr>
                                        <td>${dto.no}</td>
                                        <td>
                                            <c:if test="${empty cus}">
                                                <strong>${dto.title}</strong>
                                            </c:if>
                                            <c:if test="${not empty cus}">
                                                <a href="${path2}/free/detail.do?no=${dto.no}">${dto.title}</a>
                                            </c:if>
                                        </td>
                                        <td>${dto.resdate}</td>
                                        <td>${dto.hits}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty list}">
                                <tr>
                                    <td colspan="4"><strong>자유게시판 글이 존재하지 않습니다.</strong></td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                    <hr>
                    <c:if test="${not empty cus.id}">
                        <div class="buttons">
                            <a href="${path2}/free/insert.do" class="button is-danger">글 등록</a>
                        </div>
                    </c:if>
                    <div class="pagination">
                        <c:forEach var="i" begin="1" end="${totalPage}">
                            <a href="${path2}/free/list.do?page=${i}"
                               class="${currentPage == i ? 'active' : ''}">${i}</a>
                        </c:forEach>
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