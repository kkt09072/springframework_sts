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
    <title>Ajax Test7</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<nav>
    <h2>07_Post + @RequestBody + Object 전송</h2>
    <hr>
    <ul>
        <li><a href="${path2}/ajax2/">Home</a></li>
    </ul>
    <input type="text" name="num" id="num" placeholder="번호 입력" required><br>
    <input type="text" name="stdName" id="stdName" placeholder="이름 입력" required><br>
    <input type="text" name="age" id="age" placeholder="나이 입력" required><br><br>
    <button id="btn7" type="button">Post 전송</button>
    <button id="remove" type="button">결과 비우기</button>
    <hr>
    <h3>입력된 데이터</h3>
    <div id="res"></div>
    <script>
		var btn7 = document.getElementById("btn7");
		var prt = document.getElementById("res");
		var remove = document.getElementById("remove");
        btn7.addEventListener("click", function() {
            var student = { stdNumber:parseInt(document.getElementById("num").value),
            		name:document.getElementById("stdName").value,
            		age:document.getElementById("age").value};
            console.log(JSON.stringify(student));
        	axios.post("${path2}/ajax2/ajax7pro.do", student).then(res => {
    			alert("ajax7pro 전송 완료");
    			console.log(res.data);
    			var rds = res.data;
                var txt = "<span>번호 : "+rds.stdNumber +"</span><br>";
                txt += "<span>나이 : "+rds.age +"</span><br>";
                txt += "<span>이름 : "+rds.name +"</span><hr>";
           		prt.innerHTML = txt;     
            });
        });
        remove.addEventListener("click", function(){
            prt.innerHTML = "";
        });
    </script>
</nav>
</body>
</html>