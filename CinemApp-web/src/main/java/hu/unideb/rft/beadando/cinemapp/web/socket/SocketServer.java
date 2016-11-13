package hu.unideb.rft.beadando.cinemapp.web.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/cinemappWS") 
public class SocketServer {
	
	private static List<Session> connections = new ArrayList<>();
    
    @OnOpen
    public void onOpen(Session session){
    	connections.add(session);
        System.out.println(session.getId() + " has opened a connection"); 
        try {
            session.getBasicRemote().sendText("Connection Established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("Message from " + session.getId() + ": " + message);
        try {
        	// az illető kilépne
        	if( message.equals("OUT") ) {
        		session.getBasicRemote().sendText("OK");
        	}
        	for( Session conn : connections ){
        		// ha jön egy üzenet, akkor küldjük mindenki másnak
        		if( !conn.equals(session) ){
        			conn.getBasicRemote().sendText("UP");	
        		}
        	}
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    @OnClose
    public void onClose(Session session){
    	connections.remove(session);
        System.out.println("Session " +session.getId()+" has ended");
    }
}