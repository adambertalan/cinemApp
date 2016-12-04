package hu.unideb.rft.beadando.cinemapp.web.socket;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<SeatMessage> {

	  @Override
	  public String encode(SeatMessage message) throws EncodeException {

	    JsonObject jsonObject = Json.createObjectBuilder()
	        .add("movieShowId", message.getMovieShowId())
	        .add("seatId", message.getSeatId())
	        .add("occupyOrFree", message.getOccupyOrFree())
	        .add("theatreId", message.getTheatreId()).build();
	    return jsonObject.toString();

	  }

	  @Override
	  public void init(EndpointConfig ec) {
//	    System.out.println("MessageEncoder - init method called");
	  }

	  @Override
	  public void destroy() {
//	    System.out.println("MessageEncoder - destroy method called");
	  }

	}