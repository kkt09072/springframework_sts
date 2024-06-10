package com.spring1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@ServerEndpoint("/socket.do")
public class SocketController {
	
	private static final List<Session> sessionList = new ArrayList<Session>();
	
	public SocketController(){
		System.out.println("Create Socket");
	}
	
	@GetMapping
	public String viewPage() {
		return "socket/chatTest";
	}

	@OnOpen  // socket 연결 시
	public void onOpen(Session session){
		System.out.println("open session : " + session.getId());
		String msg = session.getId() + "입장";
		try{
			final Basic basic = session.getBasicRemote();
			basic.sendText(msg);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sessionList.add(session);
		sendAllSessionToMessage(session, msg);
	}
	
	
	
	@OnMessage
	public void onMessage (String message, Session session){
		message = session.getId()+" : "+message; 
		try {
			//메세지 보낸 사람에게 표시됨
			final Basic basic = session.getBasicRemote();
			basic.sendText(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 다른 사람에게 메세지 보내기
		sendAllSessionToMessage(session, message);
	}
	
	@OnError
	public void onError(Throwable e, Session session){
		System.out.println(e.getMessage() + "by session : " + session.getId());
	}
	@OnClose
	public void onClose(Session session){
		System.out.println("Session : "+ session.getId() + " closed");
		sessionList.remove(session);
	}
	
	
	private void sendAllSessionToMessage(Session self,String msg){ // 연결된 모든 사용자에게 메세지 전달
		try {
			for(Session s : SocketController.sessionList){
				if(!self.getId().equals(s.getId())){ 
					s.getBasicRemote().sendText(msg);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
