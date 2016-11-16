package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import hu.unideb.rft.beadando.cinemapp.ejb.api.BookSeatService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;

@ManagedBean
@SessionScoped
public class BookSeatBean implements Serializable, HttpSessionBindingListener {

	private static final long serialVersionUID = 1L;

	@EJB
	private BookSeatService bookSeatService;

	private static List<List<Seat>> seats;
	
	private List<Seat> selectedSeats;
	
	public void update(){
		System.out.println("UPDATED");
	}
	
	// törli az általam kijelölt helyeet
	public void delete(){
		System.out.println("OCCUPY not COMMITTED! DELETING");
		for( Seat seat : selectedSeats ){
			seat.setOccupied(false);
		}
		selectedSeats.clear();
	}

	// TODO átnevezni, mert nem csak foglalni lehet vele
	public void occupyOrFree(Integer row, Integer col) throws Exception {
		
		for (List<Seat> seatList : seats) {
			for (Seat seat : seatList) {
				if (seat.getSeatRow().equals(row) && seat.getSeatColumn().equals(col)) {
					if( !seat.isOccupied() ){
						// Foglalás
						seat.setOccupied(true);
						selectedSeats.add(seat);
						System.out.println("Foglalás! (" + seat.getSeatRow() + "," + seat.getSeatColumn() + ")");
					} else {
						// ha már eleve foglalt
						// Általam foglalt? mert akkor szabaddá kell tenni
						if( selectedSeats.contains(seat) ){
							// általam foglalt, szabaddá kell tenni							
							seat.setOccupied(false);
							selectedSeats.remove(seat);
							System.out.println("Felszabadítás! (" + seat.getSeatRow() + "," + seat.getSeatColumn() + ")");
						} else {
							// más által foglalt, nem csinálunk semmit
						}
					}
				}
			}
		}
		
		
		System.out.println("Aktuális foglalásaim: ");
		for( Seat seat: selectedSeats ){
			System.out.println("(" + seat.getSeatRow() + "," + seat.getSeatColumn() + ")");
		}
	}
	
	public String save() {
		System.out.println("Saving");
		if( selectedSeats != null && !selectedSeats.isEmpty() ){
			// elmenteni
			this.bookSeatService.saveReservation(selectedSeats);
			// törölni a foglalásokat
			this.selectedSeats.clear();
			System.out.println("Querying after saving");
			// frissíteni az adatbázisból
			this.seats = bookSeatService.findAllSeatsOfTheatre(1L);
			return "index?faces-redirect=true";
		}
		System.out.println("No selected seats!");
		return null;
	}

	@PostConstruct
	public void init() {
		System.out.println("BookseatBean INIT");
		
		// lekérni az aktuális foglaltságot, ha még nem volt lekérve
		if( seats == null ){
			System.out.println("Querying seats");
			seats = bookSeatService.findAllSeatsOfTheatre(1L);			
		}
		// ha voltak korábbi foglalások, töröljük
		if( this.selectedSeats != null ){
			this.delete();
		} else {
			System.out.println("nincsenek korábbi foglalások");
		}
		// új foglalások
		this.selectedSeats = new ArrayList<>();
	}
	
	public void destroy() {
		System.out.println("BookSeatBean DESTROY");
		// ha maradt beragadt foglalása, akkor azt törölni.
		this.delete();
	}

	public BookSeatService getBookSeatService() {
		return bookSeatService;
	}

	public void setBookSeatService(BookSeatService bookSeatService) {
		this.bookSeatService = bookSeatService;
	}

	public List<List<Seat>> getSeats() {
		return seats;
	}

	public void setSeats(List<List<Seat>> seats) {
		this.seats = seats;
	}

	public List<Seat> getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(List<Seat> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("ValueBOUND " + this.toString());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("Value-UN-BOUND " + this.toString());
		this.destroy();
	}
}
