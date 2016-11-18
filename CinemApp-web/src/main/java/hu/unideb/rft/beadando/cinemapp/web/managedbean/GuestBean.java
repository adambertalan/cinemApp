package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import de.larmic.butterfaces.event.TableSingleSelectionListener;
import hu.unideb.rft.beadando.cinemapp.ejb.api.GuestService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;

@ManagedBean(name = "guestBean")
@ViewScoped
public class GuestBean implements TableSingleSelectionListener {
	
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

	@Override
	public boolean isValueSelected(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void processTableSelection(Object arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
