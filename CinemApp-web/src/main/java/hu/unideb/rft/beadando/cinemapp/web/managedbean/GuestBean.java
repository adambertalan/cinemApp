package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.GuestService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;

@ManagedBean(name = "guestBean")
@ViewScoped
public class GuestBean {
	
	@EJB
	private GuestService guestService;
	
	private List<Guest> guests;

	@PostConstruct
	public void init(){
		guests = guestService.findAllGuest();
		System.out.println("Guests :" + guests);
	}

	public List<Guest> getGuests() {
		return guests;
	}

	public void setGuests(List<Guest> guests) {
		this.guests = guests;
	}
	
	
}
