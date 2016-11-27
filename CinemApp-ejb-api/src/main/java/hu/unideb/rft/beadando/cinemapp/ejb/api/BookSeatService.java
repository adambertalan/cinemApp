package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;

@Local
public interface BookSeatService {

//	Boolean isSeatOccupied( Integer seatRow, Integer seatColumn, Long theatreId);
	
	List<List<Seat>> findAllSeatsOfTheatre( Long theatreId ); 
	
	void saveReservation( List<Seat> reservedSeats, String guestName, String guestEmail, String guestPhone, Integer guestZip, Long movieShowId );
	
	List<Seat> findOccupiedSeatsOfMovieShow(Long movieShowId);
}
