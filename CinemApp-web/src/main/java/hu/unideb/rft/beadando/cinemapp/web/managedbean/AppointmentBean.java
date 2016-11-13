package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.AppointmentService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.GuestService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;

@ManagedBean(name = "appointmentBean")
@ViewScoped
public class AppointmentBean {

	@EJB
	private AppointmentService appointmentService;
	@EJB
	private GuestService guestService;

	private String appointmentGuestName;
	private String appointmentGuestEmail;
	private String appointmentGuestPhoneNumber;
	private Integer appointemntGuestZip;

	private Long appointmentMovieShowId;
	private Long appointmentSeatId;

	private Long selectedAppointmentId;
	
	private static Long appointmentToBeEditedId = null;

	private List<Appointment> appointments;

	@PostConstruct
	public void init() {
		System.out.println("called");
		appointments = appointmentService.findAllAppointments();
		System.out.println("Appointments :" + appointments);
	}

	public void addNewOrEditAppointment() {
		System.out.println(appointmentGuestName);
		System.out.println(appointmentGuestEmail);
		System.out.println(appointmentGuestPhoneNumber);
		System.out.println(appointemntGuestZip);
		System.out.println(appointmentMovieShowId);
		System.out.println(appointmentSeatId);
		
		if(appointmentToBeEditedId == null){
			addNewAppointment();
		}else{
			Appointment editedAppointment = appointmentService.getAppointmentRepository().findAppointmentById(appointmentToBeEditedId);
			if(editedAppointment == null){
				addNewAppointment();
				clearTextFields();
				return;
			}
			Guest editedGuest = appointmentService.getGuestRepository().findGuestById(editedAppointment.getGuest().getId());
			editedGuest.setName(appointmentGuestName);
			editedGuest.setEmail(appointmentGuestEmail);
			editedGuest.setPhoneNumber(appointmentGuestPhoneNumber);
			editedGuest.setZip(appointemntGuestZip);
			editedAppointment.setGuest(editedGuest);
			editedAppointment.setMovieShow(appointmentService.getMovieShowRepository().findOne(appointmentMovieShowId));
			editedAppointment.setSeat(appointmentService.getSeatRepository().findOne(appointmentSeatId));
			appointmentService.getAppointmentRepository().save(editedAppointment);
			appointmentService.getGuestRepository().save(editedGuest);
			appointments = appointmentService.findAllAppointments();
			appointmentToBeEditedId = null;
		}

		clearTextFields();

	}
	
	private void clearTextFields(){
		this.appointmentGuestName = null;
		this.appointmentGuestEmail = null;
		this.appointmentGuestPhoneNumber = null;
		this.appointemntGuestZip = null;
		this.appointmentMovieShowId = 1L;
		this.appointmentSeatId = 1L;
	}
	
	private void addNewAppointment(){
		Guest guest = guestService.createGuest(appointmentGuestName, appointmentGuestEmail, appointmentGuestPhoneNumber,
				appointemntGuestZip);
		System.out.println("Guest Id: " + guest.getId());

		Appointment appointment = appointmentService.createAppointment(guest.getId(), appointmentMovieShowId,
				appointmentSeatId);
		appointments.add(appointment);
	}

	public void editAppointment() {
		Appointment selectedAppointment = appointmentService.getAppointmentRepository().findAppointmentById(selectedAppointmentId);
		if(selectedAppointment != null){
			appointmentGuestName = selectedAppointment.getGuest().getName();
			appointmentGuestEmail = selectedAppointment.getGuest().getEmail();
			appointmentGuestPhoneNumber = selectedAppointment.getGuest().getPhoneNumber();
			appointemntGuestZip = selectedAppointment.getGuest().getZip();
			appointmentMovieShowId = selectedAppointment.getMovieShow().getId();
			appointmentSeatId = selectedAppointment.getSeat().getId();
			appointmentToBeEditedId = selectedAppointmentId;
		}
	}

	public void deleteAppointment() {
		appointmentService.deleteAppointment(selectedAppointmentId);
		appointments = appointmentService.findAllAppointments();
	}

	public AppointmentService getAppointmentSerevice() {
		return appointmentService;
	}

	public void setAppointmentSerevice(AppointmentService appointmentSerevice) {
		this.appointmentService = appointmentSerevice;
	}

	public String getAppointmentGuestName() {
		return appointmentGuestName;
	}

	public void setAppointmentGuestName(String appointmentGuestName) {
		this.appointmentGuestName = appointmentGuestName;
	}

	public String getAppointmentGuestEmail() {
		return appointmentGuestEmail;
	}

	public void setAppointmentGuestEmail(String appointmentGuestEmail) {
		this.appointmentGuestEmail = appointmentGuestEmail;
	}

	public String getAppointmentGuestPhoneNumber() {
		return appointmentGuestPhoneNumber;
	}

	public void setAppointmentGuestPhoneNumber(String appointmentGuestPhoneNumber) {
		this.appointmentGuestPhoneNumber = appointmentGuestPhoneNumber;
	}

	public Integer getAppointemntGuestZip() {
		return appointemntGuestZip;
	}

	public void setAppointemntGuestZip(Integer appointemntGuestZip) {
		this.appointemntGuestZip = appointemntGuestZip;
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
