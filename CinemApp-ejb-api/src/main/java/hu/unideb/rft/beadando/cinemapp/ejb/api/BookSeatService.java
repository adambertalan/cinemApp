package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;

@Local
public interface BookSeatService {

//	Boolean isSeatOccupied( Integer seatRow, Integer seatColumn, Long theatreId);
	
	List<List<Seat>> findAllSeatsOfTheatre( Long theatreId ); 
	
	Appointment saveReservation( Set<Seat> reservedSeats, String guestName, String guestEmail, String guestPhone, Integer guestZip, Long movieShowId );
	
	List<Seat> findOccupiedSeatsOfMovieShow(Long movieShowId);
}
