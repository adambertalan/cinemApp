package hu.unideb.rft.beadando.cinemapp.web.socket;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<SeatMessage> {

	  @Override
	  public SeatMessage decode(String jsonMessage) throws DecodeException {

	    JsonObject jsonObject = Json
	        .createReader(new StringReader(jsonMessage)).readObject();
	    SeatMessage message = new SeatMessage();
	    message.setMovieShowId(jsonObject.getInt("movieShowId"));
	    message.setTheatreId(jsonObject.getInt("theatreId"));
	    message.setSeatId(jsonObject.getInt("seatId"));
	    message.setOccupyOrFree(jsonObject.getBoolean("occupyOrFree"));
	    return message;

	  }

	  @Override
	  public boolean willDecode(String jsonMessage) {
	    try {
	      // Check if incoming message is valid JSON
	      Json.createReader(new StringReader(jsonMessage)).readObject();
	      return true;
	    } catch (Exception e) {
	      return false;
	    }
	  }

	  @Override
	  public void init(EndpointConfig ec) {
	    System.out.println("MessageDecoder -init method called");
	  }

	  @Override
	  public void destroy() {
	    System.out.println("MessageDecoder - destroy method called");
	  }

	}