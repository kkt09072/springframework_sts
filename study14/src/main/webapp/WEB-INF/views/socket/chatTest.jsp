<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>채팅 테스트</title>
	<script src="https://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
    $(function(){
        var ws = new WebSocket("ws://localhost:8091/spring1/socket.do");

        ws.onopen = function(e){ // 연결 시 실행
            console.log("info : connection opened.");
        }

        ws.onmessage = function(e){ // 서버로부터 메세지를 받았을 때 실행
            console.log(e.data); // 전달 받은 메세지 = e.data
            $("#msg").append("<p>"+e.data+"</p>");
        }

        ws.onclose = function(e){ // 연결 종료 시 실행
            console.log("info : connection closed");
        };

        ws.onerror = function(e){
            console.log("error");
        };

        $("#btn").on("click", function(e){
            e.preventDefault();
            if (ws.readyState === WebSocket.OPEN) {
                ws.send($("#testInput").val());
            } else {
                console.log("WebSocket is not open: readyState=" + ws.readyState);
            }
        });
    });
</script>
</head>
<body>
<div class="wrap">
	<h2>Socket Test Page</h2>
	<hr>
	<input type="text" id="testInput">
	<button type="button" id="btn">전송</button>
	<div id="msg">
	</div>
</div>	
</body>
</html>
