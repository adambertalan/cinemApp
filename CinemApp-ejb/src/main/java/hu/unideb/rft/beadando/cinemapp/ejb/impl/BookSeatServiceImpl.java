package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.BookSeatService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.SeatRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.TheatreRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({ SpringBeanAutowiringInterceptor.class })
public class BookSeatServiceImpl implements BookSeatService {
	
	@Autowired
    private SeatRepository seatRepository;

	@Autowired
    private TheatreRepository theatreRepository;
	
//	@Override
//	public Boolean isSeatOccupied(Integer seatRow, Integer seatColumn, Long theatreId) {
//		System.out.println("searching");
//		return seatRepository.isSeatOccupied(seatRow, seatColumn, theatreId);
//	}

	@Override
	public List<List<Seat>> findAllSeatsOfTheatre(Long theatreId) {
		
		Theatre theatre = theatreRepository.findOne(theatreId);
		
		List<List<Seat>> allSeats = new LinkedList<>();
		
		for( int i = 1; i <= theatre.getRowNumber(); i++ ){
			// az i. sor
			List<Seat> rowSeats = seatRepository.findAllSeatsOfRowInTheatre(theatreId, i);
			allSeats.add(rowSeats);
		}
		
		return allSeats;
	}

	@Override
	public void saveReservation(List<Seat> reservedSeats) {
		System.out.println("BookSeatServiceImpl saving reservations");
		seatRepository.save(reservedSeats);
	}

}
