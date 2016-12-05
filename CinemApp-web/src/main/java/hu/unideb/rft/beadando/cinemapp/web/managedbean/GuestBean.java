package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Ajax;

import de.larmic.butterfaces.event.TableSingleSelectionListener;
import hu.unideb.rft.beadando.cinemapp.ejb.api.AppointmentService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.CuponService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.GuestService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;

@ManagedBean(name = "guestBean")
@ViewScoped
public class GuestBean implements TableSingleSelectionListener {
	
	@EJB
	private GuestService guestService;
	
	@EJB
	private CuponService cuponService;
	
	@EJB
	private AppointmentService appointmentService;
	
	private List<Guest> guests;
	
	private Guest selectedGuest;
	
	private List<Appointment> guestAppointments;

	@PostConstruct
	public void init(){
		System.out.println("GuestBean: init()");
		guests = guestService.findAllGuest();
		System.out.println("Guests :" + guests);
	}
	
	public String format( Timestamp ts ){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		return sdf.format(ts);
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}

	@Override
	public boolean isValueSelected(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void processTableSelection(Object guest) {
		// TODO Auto-generated method stub
		System.out.println("VALUE SELECED" + guest);
		this.guestAppointments = appointmentService.findAppointmentsOfGuest((Guest)guest);
		this.selectedGuest = (Guest)guest;
		
		
		Ajax.update("well");
//		Ajax.update("well:welldiv");
	}

//	public String getSelectedGuestName() {
//		return selectedGuestName;
//	}
//
//	public void setSelectedGuestName(String selectedGuestName) {
//		this.selectedGuestName = selectedGuestName;
//	}

	public List<Appointment> getGuestAppointments() {
		return guestAppointments;
	}

	public void setGuestAppointments(List<Appointment> guestAppointments) {
		this.guestAppointments = guestAppointments;
	}

	public Guest getSelectedGuest() {
		return selectedGuest;
	}

	public void setSelectedGuest(Guest selectedGuest) {
		this.selectedGuest = selectedGuest;
	}
}
