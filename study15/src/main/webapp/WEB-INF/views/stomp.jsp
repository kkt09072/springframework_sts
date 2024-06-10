<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>STOMP Chat</title>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@stomp/stompjs@5/umd/stomp.min.js"></script>
    <!-- <script src="https://cdn.jsdelivr.net/npm/@stomp/stompjs@5.4.4/bundles/stomp.umd.min.js"></script> -->
    <script>
        var stompClient;
        function connect() {
            var socket = new SockJS('/spring1/stomp/chat');
            stompClient = Stomp.over(socket);

            stompClient.connect({}, function(frame) {
                document.getElementById('messages').innerHTML += '<br/>STOMP: 대화방에 연결되었습니다.';
                stompClient.subscribe('/topic/messages', function(message) {
                    document.getElementById('messages').innerHTML += '<br/>' + message.body;
                });
            });
        }

        function send() {
            var message = document.getElementById('message').value;
            stompClient.send("/app/chat", {}, message);
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
