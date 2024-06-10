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
    <title>Ajax Test4</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
<nav>
    <h2>04_Post + Parameter + @RequestBody</h2>
    <hr>
    <ul>
        <li><a href="${path2}/ajax2/">Home</a></li>
    </ul>
    <input type="text" name="msg" id="msg" placeholder="메시지 입력">
    <button id="btn4" type="button">Post 전송</button>
    <script>
    document.getElementById("btn4").addEventListener("click", function(){
        var msgData = document.getElementById("msg").value;
        console.log("원본 데이터 : "+msgData);
        if(msgData==""){ msgData = "Post Parameter 전송"; }
        var msg = { "msg": msgData };
    	axios.post("${path2}/ajax2/ajax4pro.do", msg).then(res => {
			alert("ajax4pro 전송 완료");
        });
    });
    </script>
</nav>
</body>
</html>