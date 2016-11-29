package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.ArrayList;
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
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class AppointmentServiceImpl implements AppointmentService {

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
    public Appointment createAppointment(Long guestId, Long movieShowId, List<Long> seatIds) {
        Appointment appointment = new Appointment();

        Guest guest = guestRepository.findGuestById(guestId);
        appointment.setGuest(guest);

        MovieShow movieShow = movieShowRepository.findMovieShowById(movieShowId);
        appointment.setMovieShow(movieShow);

        List<Seat> seats = new ArrayList<>();
        for (Long id : seatIds) {
            Seat seat = seatRepository.findSeatById(id);
            seats.add(seat);
        }
        appointment.setSeats(seats);

        appointmentRepository.save(appointment);
        return appointment;
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.delete(appointmentId);
    }

    @Override
    public AppointmentRepository getAppointmentRepository() {
        return appointmentRepository;
    }

    @Override
    public MovieShowRepository getMovieShowRepository() {
        return movieShowRepository;
    }

    @Override
    public SeatRepository getSeatRepository() {
        return seatRepository;
    }

    @Override
    public GuestRepository getGuestRepository() {
        return guestRepository;
    }

    @Override
    public List<Appointment> findAppointmentsOfGuest(Guest guest) {
        List<Appointment> guestAppointments = appointmentRepository.findByGuest(guest);
        return guestAppointments;
    }

    @Override
    public List<Appointment> findAppointmentsByMovieShow(Long movieShowId) {
        return appointmentRepository.findByMovieShowId(movieShowId);
    }

    @Override
    public Appointment findAppointmentById(Long id) {
        return appointmentRepository.findOne(id);
    }

}
