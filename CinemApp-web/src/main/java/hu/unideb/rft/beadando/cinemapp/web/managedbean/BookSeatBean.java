package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import hu.unideb.rft.beadando.cinemapp.ejb.api.AppointmentService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.persistence.NamedEntityGraph;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Ajax;
import org.omnifaces.util.Faces;

import hu.unideb.rft.beadando.cinemapp.ejb.api.BookSeatService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.CuponService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Cupon;
import java.util.Random;
import net.bootsfaces.utils.FacesMessages;

@ManagedBean
@SessionScoped
public class BookSeatBean implements Serializable, HttpSessionBindingListener {

	private static final long serialVersionUID = 1L;

	@EJB
	private BookSeatService bookSeatService;
        
        @EJB
        private AppointmentService appointmentService;
        
        @EJB
        private CuponService cuponService;

	private String guestName;
	private String guestPhone;
	private Integer guestZip;
	private String guestEmail;
	
	private UIComponent saveButton;

	private Long movieShowId;

	// az összes ülés
	private List<List<Seat>> seats;

	// az összes foglalt ülés ami az adatbázisban foglalt
	private Set<Seat> occupiedSeats = new HashSet<>();

	// azok az ülések amik mások által lettek foglalva
	private Set<Seat> occupiedSeatsByOthers = new HashSet<>();

	// az összes kiválasztott ülés vetítés kulccsal
	private static Map<Long, Set<Seat>> selectedSeatsMap = new HashMap<>();

	// azok a helyek amiket én választottam ki foglalásra
	private Set<Seat> selectedSeats = new HashSet<>();

	@ManagedProperty(value = "#{emailBean}")
	private EmailSenderBean emailBean;

	Appointment appointment;

	// lefut, ha betöltődik az oldal
	public void reload() {

		System.out.println("BookSeatBean: reload()");

		String movieShowIdString = Faces.getRequestParameter("movieShowId");
		String theatreIdString = Faces.getRequestParameter("theatreId");

		System.out.println("BookSeatBean: movieShowId: " + movieShowIdString);
		System.out.println("BookSeatBean: theatreId: " + theatreIdString);

		Long movieShowId = Long.parseLong(movieShowIdString);
		this.movieShowId = movieShowId;
		Long theatreId = Long.parseLong(theatreIdString);

		System.out.println("BookSeatBean: reload(): Querying seats");
		// az összes ülés keresése
		if( seats == null ){
			seats = bookSeatService.findAllSeatsOfTheatre(theatreId);
		}

		occupiedSeats = new HashSet<>();
		// az összes foglalt ülés erre a filmre (az adatbázisból)
		occupiedSeats.addAll(bookSeatService.findOccupiedSeatsOfMovieShow(movieShowId));

		if (selectedSeatsMap.get(movieShowId) == null) {
			selectedSeatsMap.put(movieShowId, new HashSet<>());
		}
		System.out.println("BookSeatBean: reload(): there is " + selectedSeatsMap.get(movieShowId).size()
				+ " seats occupied by others");

		// az éppen folyamatban lévő foglalások betöltése
		// occupiedSeats.addAll(selectedSeatsMap.get(movieShowId));
		for (List<Seat> seatlist : seats) {
			for (Seat seat : seatlist) {
				for (Seat occupiedSeat : selectedSeatsMap.get(movieShowId)) {
					if (seat.getId().equals(occupiedSeat.getId())) {
						occupiedSeats.add(seat);
					}
				}
			}
		}
		
		System.out.println("Selected seats: ");
		for (Seat seat : selectedSeats) {
			System.out.print("("+seat.getSeatRow()+ "," +seat.getSeatColumn()+") ");
		}
		System.out.println();

		System.out.print("BookSeatBean: reload(): there is " + occupiedSeats.size() + " occupied seats: ");
		for (Seat seat : occupiedSeats) {
			System.out.print("(" + seat.getSeatRow() + "," + seat.getSeatColumn() + ")");
		}
		System.out.println();
		// occupiedSeats.addAll(occupiedSeatsByOthers);

		// System.out.println("OCCUPIED SEATS:");
		// for (Seat seat : occupiedSeats) {
		// System.out.print("("+seat.getSeatRow()+","+ seat.getSeatColumn()+ ")
		// ");
		// }
		//
		// System.out.println("CHECKING");
		// for (List<Seat> seatList : seats) {
		// for (Seat seat : seatList) {
		// System.out.println("seat: " + seat.getSeatColumn() + "," +
		// seat.getSeatRow());
		// if( occupiedSeats.contains(seat) ){
		// System.out.println("occupiedseats contains: (" + seat.getSeatRow() +
		// "," + seat.getSeatColumn() + ")");
		// }
		// }
		// }

		// A képernyő lefrissül
//		Ajax.update("seatform");
		// Ajax.updateAll();
	}

	// lefut ha üzenetet kapok a websocketről
	// ezzel a képernyő is lefrissül
	public void update() {
		System.out.println("BookSeatBean: update()");

		Long seatId = Long.parseLong(Faces.getRequestParameter("seatId"));
		String movieShowId = Faces.getRequestParameter("movieShowId");
		Boolean occupyOrFree = Boolean.parseBoolean(Faces.getRequestParameter("occupyOrFree"));

		System.out.println("BookSeatBean: update(): seatId: " + seatId);
		System.out.println("BookSeatBean: update(): movieShowId: " + movieShowId);
		System.out.println("BookSeatBean: update(): occupyOrFree: " + occupyOrFree);

		outerloop: for (List<Seat> seatlist : seats) {
			for (Seat s : seatlist) {
				// megkeresem azt az ülést amit az üzenetben kaptam
				if (s.getId().equals(seatId)) {
					if (occupyOrFree) {
						// ha foglalás volt
						occupiedSeats.add(s);
						// occupiedSeatsByOthers.add(s);
						break outerloop;
					} else {
						// ha felszabadítás volt
						occupiedSeats.remove(s);
						// occupiedSeatsByOthers.remove(s);
						break outerloop;
					}
				}
			}
		}
	}

	// törli az általam kijelölt helyeet
	public void delete() {
		System.out.println("BookSeatBean: delete()");
		List<Seat> toRemoveSeats = new ArrayList<>();

//		selectedSeatsMap.get(this.movieShowId).removeAll(occupiedSeats);
		for (List<Seat> seatlist : seats) {
			for (Seat seat : seatlist) {
				for (Seat occupiedSeat : selectedSeatsMap.get(movieShowId)) {
					if (seat.getId().equals(occupiedSeat.getId())) {
						toRemoveSeats.add(seat);
					}
				}
			}
		}
		
		selectedSeatsMap.get(this.movieShowId).removeAll(toRemoveSeats);

		this.occupiedSeats.removeAll(selectedSeats);
		selectedSeats.clear();
		
		this.occupiedSeats.removeAll(toRemoveSeats);
	}

	// egy ülésre kattintáskor lefutó metódus
	public void occupyOrFree(Integer row, Integer col) throws Exception {

		for (List<Seat> seatList : seats) {
			for (Seat seat : seatList) {
				if (seat.getSeatRow().equals(row) && seat.getSeatColumn().equals(col)) {
					// megvan az ülés
					if (!occupiedSeats.contains(seat)) {
						// ha még nem foglalt
						System.out.println("BookSeatBean: occupyOrFree(): Clicked on a free seat!");

						occupiedSeats.add(seat);
						if (selectedSeatsMap.get(this.movieShowId) == null) {
							selectedSeatsMap.put(this.movieShowId, new HashSet<>());
						}
						selectedSeatsMap.get(this.movieShowId).add(seat);
						selectedSeats.add(seat);

						System.out.println("BookSeatBean: occupyOrFree(): Foglalás! (" + seat.getSeatRow() + ","
								+ seat.getSeatColumn() + ")");
					} else {
						System.out.println("BookSeatBean: occupyOrFree(): Clicked on an occupied seat!");
						// ha már eleve foglalt
						// Általam foglalt? mert akkor szabaddá kell tenni
						if (selectedSeats.contains(seat)) {
							System.out.println("BookSeatBean: occupyOrFree(): The clicked seat is mine, freeing it!");
							// általam foglalt, szabaddá kell tenni
							occupiedSeats.remove(seat);
							if (selectedSeatsMap.get(this.movieShowId) == null) {
								selectedSeatsMap.put(this.movieShowId, new HashSet<>());
							}
							selectedSeatsMap.get(this.movieShowId).remove(seat);
							selectedSeats.remove(seat);
							System.out.println("BookSeatBean: occupyOrFree(): Felszabadítás! (" + seat.getSeatRow()
									+ "," + seat.getSeatColumn() + ")");
						} else {
							System.out.println("... by someone else");
							// más által foglalt, nem csinálunk semmit
						}
					}
				}
			}
		}

		System.out.println("BookSeatBean: occupyOrFree(): Aktuális foglalásaim: ");
		for (Seat seat : selectedSeats) {
			System.out.print("(" + seat.getSeatRow() + "," + seat.getSeatColumn() + ") ");
		}
		System.out.println();
	}

	// a foglalt ülések elmentésekor fut le
	public String save() {
		System.out.println("BookSeatBean: save()");

		System.out.println("BookSeatBean: guestName: " + this.guestName);
		System.out.println("BookSeatBean: guestEmail: " + this.guestEmail);
		System.out.println("BookSeatBean: guestPhone: " + this.guestPhone);
		System.out.println("BookSeatBean: guestZip: " + this.guestZip);

		if (selectedSeats != null && !selectedSeats.isEmpty()) {
			if (isValidEmail(guestEmail)) {
				// elmenteni
				System.out.println("BookSeatBean: saving occupied seats!");
				this.appointment = this.bookSeatService.saveReservation(selectedSeats, guestName, guestEmail,
						guestPhone, guestZip, movieShowId);
				// törölni a foglalásokat
				this.selectedSeats.clear();

				// e-mail kiküldése
				this.emailBean.setGuestName(guestName);
				this.emailBean.setAddress(guestEmail);
				this.emailBean.setTypeOfTheEmail("afterbook");
                                
                                List<Appointment> appointments = this.appointmentService.findAllAppointments();
                                
                                int counter=0;
                                for(Appointment a : appointments){
                                    if(a.getGuest().getName().equals(guestName)&&a.getGuest().getEmail().equals(guestEmail)){
                                        counter++;
                                    }
                                }
                                
                                if(counter%3==0){
                                    List<Cupon> cupons = this.cuponService.findAllCupon();
                                    Cupon selectedCupon = cupons.get(new Random().nextInt(cupons.size()));
                                    this.emailBean.setQrText("id:"+appointment.getId()+"guest:"+appointment.getGuest().getName()+"movieshowid:"+appointment.getMovieShow().getId()+"movie:"+appointment.getMovieShow().getMovie().getName()+"cupon:"+selectedCupon.getName());
                                    this.emailBean.setTypeOfTheEmail("afterthreebook");
                                }else{
                                    this.emailBean.setQrText("id:"+appointment.getId()+"guest:"+appointment.getGuest().getName()+"movieshowid:"+appointment.getMovieShow().getId()+"movie:"+appointment.getMovieShow().getMovie().getName());
                                }
                              
				
				this.emailBean.sendEmail();

				return "bookingInfo.xhtml?faces-redirect=true&includeViewParams=true";
			} else {
				System.out.println("BookSeatBean: email not valid");
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(saveButton.getClientId(),
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nincs ülőhely kiválasztva", ""));
			System.out.println("BookSeatBean: No selected seats!");
		}
		return null;
	}

	public boolean isValidEmail(String address) {
		Pattern p = Pattern.compile("[^@]+@[^@]+\\.[^@]+");
		if (p.matcher(address).matches()){
			return true;
		} else {
			return false;	
		}
	}

	@PostConstruct
	public void init() {
		System.out.println("BookseatBean: init()");
		this.reload();
//
//		FacesContext context = FacesContext.getCurrentInstance();
//
//		String requestURI = ((HttpServletRequest) context.getExternalContext().getRequest()).getRequestURI();
//		System.out.println("BookSeatBean: init(): requestURI: " + requestURI);
//
//		Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();
//
//		String theatreIdString = requestMap.get("theatreId");
//		String movieShowIdString = requestMap.get("movieShowId");
//
//		System.out.println("BookSeatBean: init(): theatreId: " + theatreIdString);
//		System.out.println("BookSeatBean: init(): movieShowId: " + movieShowIdString);
//
//		Long theatreId = Long.parseLong(theatreIdString);
//		Long movieShowId = Long.parseLong(movieShowIdString);

//		this.movieShowId = movieShowId;

		// selectedSeatsMap.put(movieShowId, new HashSet<Seat>());

		// lekérni az aktuális foglaltságot, ha még nem volt lekérve
//		System.out.println("Querying seats");
//		seats = bookSeatService.findAllSeatsOfTheatre(theatreId);
//
//		this.reload();
		// fel kell tölteni a foglalt üléseket
//		this.occupiedSeats = new HashSet<>();
//		this.occupiedSeats.addAll(bookSeatService.findOccupiedSeatsOfMovieShow(movieShowId));

		// ha voltak korábbi foglalások, töröljük
//		if (this.selectedSeats != null) {
//			this.delete();
//		} else {
//			System.out.println("nincsenek korábbi foglalások");
//		}
//		// új foglalások
//		this.selectedSeats = new HashSet<>();
	}

	public void destroy() {
		System.out.println("BookSeatBean: destroy()");
		// ha maradt beragadt foglalása, akkor azt törölni.
		this.delete();
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

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
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

	public Set<Seat> getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(Set<Seat> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}

	public Set<Seat> getOccupiedSeats() {
		return occupiedSeats;
	}

	public void setOccupiedSeats(Set<Seat> occupiedSeats) {
		this.occupiedSeats = occupiedSeats;
	}

	public Map<Long, Set<Seat>> getSelectedSeatsMap() {
		return selectedSeatsMap;
	}

	public void setSelectedSeatsMap(Map<Long, Set<Seat>> selectedSeatsMap) {
		this.selectedSeatsMap = selectedSeatsMap;
	}

	public Long getMovieShowId() {
		return movieShowId;
	}

	public void setMovieShowId(Long movieShowId) {
		this.movieShowId = movieShowId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestPhone() {
		return guestPhone;
	}

	public void setGuestPhone(String guestPhone) {
		this.guestPhone = guestPhone;
	}

	public Integer getGuestZip() {
		return guestZip;
	}

	public void setGuestZip(Integer guestZip) {
		this.guestZip = guestZip;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public EmailSenderBean getEmailBean() {
		return emailBean;
	}

	public void setEmailBean(EmailSenderBean emailBean) {
		this.emailBean = emailBean;
	}

	public UIComponent getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(UIComponent saveButton) {
		this.saveButton = saveButton;
	}

}
