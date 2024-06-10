<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SockJS Chat</title>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script>
        var sock;
        function connect() {
            if (sock !== undefined && sock.readyState !== SockJS.CLOSED) {
                console.log("SockJS is already opened.");
                return;
            }

            sock = new SockJS('http://localhost:8091/spring1/sockjs/chat');

            sock.onopen = function() {
                document.getElementById('messages').innerHTML += '<br/>SockJS: 대화방에 연결되었습니다.';
            };

            sock.onmessage = function(event) {
                document.getElementById('messages').innerHTML += '<br/>' + event.data;
            };

            sock.onclose = function() {
                document.getElementById('messages').innerHTML += '<br/>SockJS connection closed';
            };
        }

        function send() {
            var message = document.getElementById('message').value;
            sock.send(message);
            document.getElementById('message').value = '';
        }
    </script>
</head>
<body onload="connect()">
    <div>
        <input type="text" id="message">
        <button onclick="send()">Send</button>
    </div>
    <div id="messages"></div>
</body>
</html>
