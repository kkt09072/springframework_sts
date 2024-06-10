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
    <title>Ajax Test8</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
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
    <h2>08_Post + Parameter/Object + List 전송</h2>
    <hr>
    <ul>
        <li><a href="${path2}/ajax2/">Home</a></li>
    </ul>
    <input type="text" name="num" id="num" placeholder="연번 입력" value="12" required><br><br>
    <input type="text" name="title" id="title" placeholder="제목 입력" required><br><br>
    <input type="text" name="res" id="res" placeholder="작성일 입력" value="2024-05-10" readonly><br><br>
    <button id="btn8" type="button">Post 전송</button>
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
	var btn8 = document.getElementById("btn8");
	var tbody = document.getElementById("tbody");
	var empty = document.getElementById("empty");
	btn8.addEventListener("click", function(){
        var sample = { 
        		num:document.getElementById("num").value,
        		title:document.getElementById("title").value,
        		res:document.getElementById("res").value
        		};
        var txt = "";
        console.log(sample);
    	axios.post("${path2}/ajax2/ajax8pro.do", sample).then(res => {
			alert("ajax8pro 전송 완료");
            console.log("성공", res.data);
            var rds = res.data;
            console.log("성공", rds[0]);
            for(let i in rds){
                console.log(rds[i]);
                txt = txt + "<tr><td>"+rds[i].num+"</td><td>"+rds[i].title +"</td><td>"+rds[i].res+"</td></tr>";
            }
            document.getElementById("num").value = rds[0].num;
            document.getElementById("title").value = rds[0].title;
            document.getElementById("res").value = rds[0].res;
            tbody.innerHTML = txt;
        });
    });
    empty.addEventListener("click", function(){
    	tbody.innerHTML = "";
    });
    </script>
</nav>
</body>
</html>