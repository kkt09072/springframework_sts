<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajax Test10</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <style>
    #tb1 { border-collapse: collapse; }
    #tb1 th { border-top:2px solid #333; border-bottom:2px solid #333; background-color:gold; line-height:30px; min-width:150px;
        padding-left: 24px; padding-right: 24px; }
    #tb1 td { border-bottom:1px solid #333;  line-height: 30px; min-width:150px;  padding-left: 24px; padding-right: 24px; }
    #tb1 tbody tr:last-child td { background-color:#eee; }
    </style>
</head>
<body>
<nav>
    <h2>10_Post + Parameter + ResponseEntity Object 전송</h2>
    <hr>
    <ul>
        <li><a href="${path2}/ajax3/">Home</a></li>
    </ul>
    <input type="text" name="num" id="num" placeholder="연번 입력" readonly required><br>
    <input type="text" name="title" id="title" placeholder="제목 입력" required><br>
    <input type="text" name="res" id="res" placeholder="작성일 입력" readonly><br><br>
    <button id="btn10" type="button">Post 전송</button>
    <button id="empty" type="button">결과 비우기</button>
    <hr>
    <h3>결과 목록</h3>
    <div id="res">
        <table id="tb1">
            <thead>
                <tr><th>연번</th><th>제목</th><th>날짜</th></tr>
            </thead>
            <tbody id="tbody">

            </tbody>
        </table>
    </div>
    <script>
    var btn10 = document.getElementById("btn10");
    var tbody = document.getElementById("tbody");
    var empty = document.getElementById("empty");

    btn10.addEventListener("click", async function() {
        try {
            var sample = {
                title: document.getElementById("title").value
            };

            const response = await fetch("${path2}/ajax3/ajax10pro.do", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(sample)
            });

            if (!response.ok) {
                throw new Error('서버 응답 실패');
            }

            const data = await response.json();
            alert("ajax10pro 전송 완료");
            console.log("성공", data);
            var txt = "";
            for (let i in data) {
                console.log(data[i]);
                txt += "<tr><td>" + data[i].num + "</td><td>" + data[i].title + "</td><td>" + data[i].res + "</td></tr>";
            }
            document.getElementById("num").value = data[0].num;
            document.getElementById("title").value = data[0].title;
            document.getElementById("res").value = data[0].res;
            tbody.innerHTML = txt;
        } catch (error) {
            console.error(error);
        }
    });

    empty.addEventListener("click", function() {
        tbody.innerHTML = "";
    });
    </script>
</nav>
</body>
</html>