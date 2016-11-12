package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.AppointmentService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;

@ManagedBean(name="appointmentBean")
@ViewScoped
public class AppointmentBean {

	@EJB
	private AppointmentService appointmentSerevice;
	
	private Long appointmentGuestId;
	private Long appointmentMovieShowId;
	private Long appointmentSeatId;
	
	private Long selectedAppointmentId;
	
	private List<Appointment> appointments;
	
	@PostConstruct
	public void init(){
		System.out.println("called");
		appointments = appointmentSerevice.findAllAppointments();
		System.out.println("Appointments :" + appointments);
	}
	
	public void addNewAppointment(){
		System.out.println(appointmentGuestId);
		System.out.println(appointmentMovieShowId);
		System.out.println(appointmentSeatId);
		
		Appointment appointment = appointmentSerevice.createAppointment(appointmentGuestId, appointmentMovieShowId, appointmentSeatId);
		appointments.add(appointment);
		
		this.appointmentGuestId = 1L;
		this.appointmentMovieShowId = 1L;
		this.appointmentSeatId = 1L;
				
	}
	
	public void editAppointment(){
		
	}
	
	public void deleteAppointment(){
		appointmentSerevice.deleteAppointment(selectedAppointmentId);
		appointments = appointmentSerevice.findAllAppointments();
	}

	public AppointmentService getAppointmentSerevice() {
		return appointmentSerevice;
	}

	public void setAppointmentSerevice(AppointmentService appointmentSerevice) {
		this.appointmentSerevice = appointmentSerevice;
	}

	
	
	public Long getAppointmentGuestId() {
		return appointmentGuestId;
	}

	public void setAppointmentGuestId(Long appointmentGuestId) {
		this.appointmentGuestId = appointmentGuestId;
	}

	public Long getAppointmentMovieShowId() {
		return appointmentMovieShowId;
	}

	public void setAppointmentMovieShowId(Long appointmentMovieShowId) {
		this.appointmentMovieShowId = appointmentMovieShowId;
	}

	public Long getAppointmentSeatId() {
		return appointmentSeatId;
	}

	public void setAppointmentSeatId(Long appointmentSeatId) {
		this.appointmentSeatId = appointmentSeatId;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Long getSelectedAppointmentId() {
		return selectedAppointmentId;
	}

	public void setSelectedAppointmentId(Long selectedAppointmentId) {
		this.selectedAppointmentId = selectedAppointmentId;
	}
	
	
	
}
