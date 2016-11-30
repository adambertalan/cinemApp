package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.AppointmentRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.GuestRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieShowRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.SeatRepository;

@Local
public interface AppointmentService {

	public List<Appointment> findAllAppointments();
        
        public Appointment findAppointmentById(Long id);
	
	public List<Appointment> findAppointmentsOfGuest( Guest guest );

	public Appointment createAppointment(Long guestId, Long movieShowId, List<Long> seatIds);
	
	public List<Appointment> findAppointmentsByMovieShow( Long movieShowId );

	public void deleteAppointment(Long appointmentId);

	public AppointmentRepository getAppointmentRepository();
	
	public MovieShowRepository getMovieShowRepository();
	
	public SeatRepository getSeatRepository();
	
	public GuestRepository getGuestRepository();

}
