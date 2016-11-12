package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.AppointmentService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.AppointmentRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.GuestRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieShowRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.SeatRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({ SpringBeanAutowiringInterceptor.class})
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private MovieShowRepository movieShowRepository;
	
	@Autowired
	private SeatRepository seatRepository; 
	
	@Override
	public List<Appointment> findAllAppointments() {
		List<Appointment> allAppointments = appointmentRepository.findAll();
		return allAppointments;
	}

	@Override
	public Appointment createAppointment(Long guestId, Long movieShowId, Long seatId) {
		Appointment appointment = new Appointment();
		
		Guest guest = guestRepository.findGuestById(guestId);
		appointment.setGuest(guest);
		
		MovieShow movieShow = movieShowRepository.findMovieShowById(movieShowId);
		appointment.setMovieShow(movieShow);
		
		Seat seat = seatRepository.findSeatById(seatId);
		appointment.setSeat(seat);
		
		appointmentRepository.save(appointment);
		return appointment;
	}

	@Override
	public void deleteAppointment(Long appointmentId) {
		appointmentRepository.delete(appointmentId);
	}

	@Override
	public void editAppointment(Long appointmentId) {
		// TODO Auto-generated method stub
		
	}

}
