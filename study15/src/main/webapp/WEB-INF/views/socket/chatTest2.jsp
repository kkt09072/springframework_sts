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
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1.5.1/dist/sockjs.min.js"></script>
</head>
<body>
    <div>
        <input type="text" id="messageinput" placeholder="메시지 입력" />
        <button onclick="sendMessage()">Send</button>
    </div>
    <div id="messages"></div>

    <script type="text/javascript">
        var sock = new SockJS('/spring1/socket2.do');
        var messages = document.getElementById("messages");

        sock.onopen = function() {
            console.log('연결 성공');
        };

        sock.onmessage = function(e) {
            console.log('메시지 수신: ' + e.data);
            showMessage(e.data);
        };

        sock.onclose = function() {
            console.log('연결 종료');
        };

        function sendMessage() {
            var text = document.getElementById('messageinput').value;
            sock.send(text);
        }

        function showMessage(message) {
            var messageElement = document.createElement('div');
            messageElement.appendChild(document.createTextNode(message));
            messages.appendChild(messageElement);
        }
    </script>
</body>
</html>
