package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.BookSeatService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.AppointmentRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.GuestRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieShowRepository;
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

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private GuestRepository guestRepository;
	
	@Autowired
	private MovieShowRepository movieShowRepository;

	// @Override
	// public Boolean isSeatOccupied(Integer seatRow, Integer seatColumn, Long
	// theatreId) {
	// System.out.println("searching");
	// return seatRepository.isSeatOccupied(seatRow, seatColumn, theatreId);
	// }

	@Override
	public List<List<Seat>> findAllSeatsOfTheatre(Long theatreId) {

		Theatre theatre = theatreRepository.findOne(theatreId);

		List<List<Seat>> allSeats = new LinkedList<>();

		for (int i = 1; i <= theatre.getRowNumber(); i++) {
			// az i. sor
			List<Seat> rowSeats = seatRepository.findAllSeatsOfRowInTheatre(theatreId, i);
			allSeats.add(rowSeats);
		}

		return allSeats;
	}

	@Override
	public List<Seat> findOccupiedSeatsOfMovieShow(Long movieShowId) {
		List<Appointment> appointmentsOfMovieShow = appointmentRepository.findByMovieShowId(movieShowId);

		List<Seat> occupiedSeats = new ArrayList<>();
		for (Appointment ap : appointmentsOfMovieShow) {
			occupiedSeats.addAll(ap.getSeats());
		}
		return occupiedSeats;
	}

	@Override
	public void saveReservation(List<Seat> reservedSeats, String guestName, String guestEmail, String guestPhone,
			Integer guestZip, Long movieShowId) {
		System.out.println("BookSeatServiceImpl saving reservations");
		
		// létrehozni a guest-et
		Guest guest = guestRepository.findGuestByName(guestName);
		
		if( guest == null ){
			guest = new Guest();
			guest.setEmail(guestEmail);
			guest.setName(guestName);
			guest.setPhoneNumber(guestPhone);
			guest.setZip(guestZip);
			guestRepository.save(guest);
		}
		
		// megkeresni a movieShow-t
		MovieShow movieShow = movieShowRepository.findOne(movieShowId);
		
		Appointment appointment = new Appointment();
		appointment.setDeprecated(false);
		
		appointment.setGuest(guest);
		appointment.setMovieShow(movieShow);
		appointment.setSeats(reservedSeats);
		
		appointmentRepository.save(appointment);
		
		// TODO email küldés
	}

}
