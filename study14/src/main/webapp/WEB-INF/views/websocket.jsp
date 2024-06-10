<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WebSocket Chat</title>
    <script>
        var ws;
        function connect() {
            if (ws !== undefined && ws.readyState !== WebSocket.CLOSED) {
                console.log("WebSocket is already opened.");
                return;
            }

            ws = new WebSocket('ws://localhost:8091/spring1/ws/chat');

            ws.onopen = function(event) {
                if (event.data === undefined) {
                    return;
                }
                document.getElementById('messages').innerHTML += '<br/>' + event.data;
            };

            ws.onmessage = function(event) {
                document.getElementById('messages').innerHTML += '<br/>' + event.data;
            };

            ws.onclose = function(event) {
                document.getElementById('messages').innerHTML += '<br/>WebSocket connection closed';
            };
        }

        function send() {
            var message = document.getElementById('message').value;
            ws.send(message);
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
