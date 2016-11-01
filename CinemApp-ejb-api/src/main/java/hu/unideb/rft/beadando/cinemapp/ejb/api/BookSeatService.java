package hu.unideb.rft.beadando.cinemapp.ejb.api;

import javax.ejb.Local;

@Local
public interface BookSeatService {

	Boolean isSeatOccupied( Integer seatRow, Integer seatColumn, Long theatreId);
}
