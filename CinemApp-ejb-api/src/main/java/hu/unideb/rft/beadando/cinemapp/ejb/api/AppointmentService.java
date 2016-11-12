package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;

@Local
public interface AppointmentService {

	public List<Appointment> findAllAppointments();

	public Appointment createAppointment(Long guestId, Long movieShowId, Long seatId);

	public void deleteAppointment(Long appointmentId);

	public void editAppointment(Long appointmentId);

}
