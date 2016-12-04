package hu.unideb.rft.beadando.cinemapp.web.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/cinemappWS/{movieShowId}",encoders={MessageEncoder.class}, decoders={MessageDecoder.class}) 
public class SocketServer {
	
	private static Map<Integer,List<Session>> connections = new HashMap<>();
    
    @OnOpen
    public void onOpen(@PathParam("movieShowId") String movieShowId, Session session){
    	
    	Integer parseInt = Integer.parseInt(movieShowId);
    	if( connections.get(parseInt) == null ){
    		connections.put(parseInt, new ArrayList<>());
    	}
    	connections.get(parseInt).add(session);
    	
        System.out.println("SocketServer: " + session.getId() + " has opened a connection with movieShowId: " + parseInt); 
    }
 
    @OnMessage
    public void onMessage(SeatMessage message, Session session){
    	System.out.println("SOCKET SERVER: MESSAGE RECEIVED");
   
    	System.out.println(message.getTheatreId());
    	System.out.println(message.getMovieShowId());
    	System.out.println(message.getSeatId());
    	System.out.println(message.getOccupyOrFree());
        try {
        	SeatMessage sm = new SeatMessage();
        	sm.setMovieShowId(message.getMovieShowId());
        	sm.setOccupyOrFree(message.getOccupyOrFree());
        	sm.setSeatId(message.getSeatId());
        	sm.setTheatreId(message.getTheatreId());
        	
        	List<Session> list = connections.get(message.getMovieShowId());
        	for( Session ses : list ){
        		if (!ses.equals(session)){
        			ses.getBasicRemote().sendObject(sm);
        		}
        	}
        	
//        	if( message.equals("OUT") ) {
//        		session.getBasicRemote().sendText("OK");
//        	}
//        	for( Session conn : connections ){
//        		// ha jön egy üzenet, akkor küldjük mindenki másnak
//        		if( !conn.equals(session) ){
//        			conn.getBasicRemote().sendText("UP");	
//        		}
//        	}
//            
        } catch (EncodeException | IOException ex) {
            ex.printStackTrace();
        }
    }
 
    @OnClose
    public void onClose(Session session){
    	Iterator<Entry<Integer, List<Session>>> iterator = connections.entrySet().iterator();
    	Integer key = null;
    	outerloop:
    	while( iterator.hasNext() ){
    		Entry<Integer, List<Session>> next = iterator.next();
    		List<Session> value = next.getValue();
    		for( Session s : value ){
    			if( s.equals(session) ){
    				key = next.getKey();
    				break outerloop;
    			}
    		}
    	}
    	
    	connections.get(key).remove(session);
        System.out.println("Session " +session.getId()+" with movieShowId: " + key + " has ended");
    }
}