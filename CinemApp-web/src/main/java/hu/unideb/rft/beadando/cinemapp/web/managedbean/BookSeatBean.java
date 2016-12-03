package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.omnifaces.util.Ajax;
import org.omnifaces.util.Faces;
import org.springframework.beans.factory.annotation.Autowired;

import hu.unideb.rft.beadando.cinemapp.ejb.api.BookSeatService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;

@ManagedBean
@SessionScoped
public class BookSeatBean implements Serializable, HttpSessionBindingListener {

    private static final long serialVersionUID = 1L;

    @EJB
    private BookSeatService bookSeatService;

    private String guestName;

    private String guestPhone;

    private Integer guestZip;

    private String guestEmail;

    private Long movieShowId;

    private List<List<Seat>> seats;

    private List<Seat> occupiedSeats;

    private List<Seat> occupiedSeatsByOthers = new ArrayList<>();

    private Map<Long, List<Seat>> selectedSeatsMap = new HashMap<>();

    private List<Seat> selectedSeats;

    @ManagedProperty(value = "#{emailBean}")
    private EmailSenderBean emailBean;

    Appointment appointment;

    public boolean contains(List<Seat> list, Seat seat) {
        if (list == null) {
            return false;
        }

        for (Seat s : list) {
            if (seat.getId().equals(s.getId())) {
                return true;
            }
        }
        return false;
    }

    public void reload() {

        String movieShowIdString = Faces.getRequestParameter("movieShowId");
        String theatreIdString = Faces.getRequestParameter("theatreId");

        Long movieShowId = Long.parseLong(movieShowIdString);
        Long theatreId = Long.parseLong(theatreIdString);

        System.out.println("Reload: Querying seats");
        seats = bookSeatService.findAllSeatsOfTheatre(theatreId);
        occupiedSeats = bookSeatService.findOccupiedSeatsOfMovieShow(movieShowId);
        // TODO nullkezelés!!

//		occupiedSeats.addAll(selectedSeats);
        occupiedSeats.addAll(selectedSeatsMap.get(this.movieShowId));
        occupiedSeats.addAll(occupiedSeatsByOthers);

        Ajax.updateAll();
    }

    public void update() {
        System.out.println("Update called!!");
        Long seatId = Long.parseLong(Faces.getRequestParameter("seatId"));
        String movieShowId = Faces.getRequestParameter("movieShowId");
        Boolean occupyOrFree = Boolean.parseBoolean(Faces.getRequestParameter("occupyOrFree"));

        System.out.println("seatId: " + seatId);
        System.out.println("movieShowId: " + movieShowId);

        outerloop:
        for (List<Seat> seatlist : seats) {
            for (Seat s : seatlist) {
                if (s.getId().equals(seatId)) {
                    if (occupyOrFree) {
                        occupiedSeats.add(s);
                        occupiedSeatsByOthers.add(s);
                        break outerloop;
                    } else {
                        occupiedSeats.remove(s);
                        occupiedSeatsByOthers.remove(s);
                        break outerloop;
                    }
                }
            }
        }

        System.out.println("UPDATED");
    }

    // törli az általam kijelölt helyeet
    public void delete() {
        System.out.println("OCCUPY not COMMITTED! DELETING");
        selectedSeats.clear();
        this.occupiedSeats.removeAll(selectedSeats);
    }

    public void occupyOrFree(Integer row, Integer col) throws Exception {

        for (List<Seat> seatList : seats) {
            for (Seat seat : seatList) {
                if (seat.getSeatRow().equals(row) && seat.getSeatColumn().equals(col)) {
                    System.out.println("Seat found in list");
//					if( !seat.isOccupied() ){
                    if (!occupiedSeats.contains(seat)) {
                        System.out.println("this seat is free!");
                        // Foglalás
                        occupiedSeats.add(seat);
                        selectedSeats.add(seat);
                        System.out.println("Foglalás! (" + seat.getSeatRow() + "," + seat.getSeatColumn() + ")");
                    } else {
                        System.out.println("this seat is occupied ...");
                        // ha már eleve foglalt
                        // Általam foglalt? mert akkor szabaddá kell tenni
                        if (selectedSeats.contains(seat)) {
                            System.out.println("... by me");
                            // általam foglalt, szabaddá kell tenni							
                            selectedSeats.remove(seat);
                            occupiedSeats.remove(seat);
                            System.out.println("Felszabadítás! (" + seat.getSeatRow() + "," + seat.getSeatColumn() + ")");
                        } else {
                            System.out.println("... by someone else");
                            // más által foglalt, nem csinálunk semmit
                        }
                    }
                }
            }
        }

        System.out.println("Aktuális foglalásaim: ");
        for (Seat seat : selectedSeats) {
            System.out.println("(" + seat.getSeatRow() + "," + seat.getSeatColumn() + ")");
        }
    }

    public String save() {
        System.out.println("Saving");
        System.out.println(this.guestName);
        System.out.println(this.guestEmail);
        System.out.println(this.guestPhone);
        System.out.println(this.guestZip);

        if (selectedSeats != null && !selectedSeats.isEmpty()) {
            if (isValidEmail(guestEmail)) {
                // elmenteni
                this.appointment = this.bookSeatService.saveReservation(selectedSeats, guestName, guestEmail, guestPhone, guestZip, movieShowId);
                // törölni a foglalásokat
                this.selectedSeats.clear();
                // e-mail kiküldése

                this.emailBean.setGuestName(guestName);
                this.emailBean.setAddress(guestEmail);
                this.emailBean.setTypeOfTheEmail("afterbook");

                this.emailBean.sendEmail();

                return "bookingInfo.xhtml?faces-redirect=true&includeViewParams=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Helytelen E-mail cím formátum",
                                ""));
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Nincs ülőhely kiválasztva",
                            "A foglalás véglegesítéséhez válasszon ülőhelyet!"));
            System.out.println("No selected seats!");
        }
        return null;
    }

    public boolean isValidEmail(String address) {
        Pattern p = Pattern.compile("(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)");
        if (p.matcher(address).matches()) {
            return true;
        } else {
            return false;
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("BookseatBean INIT");

        FacesContext context = FacesContext.getCurrentInstance();

        String requestURI = ((HttpServletRequest) context.getExternalContext().getRequest()).getRequestURI();
        System.out.println("requestURI: " + requestURI);

        Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();

        String theatreIdString = requestMap.get("theatreId");
        String movieShowIdString = requestMap.get("movieShowId");

        System.out.println("INIT: theatreId " + theatreIdString);
        System.out.println("INIT: movieShowId " + movieShowIdString);

        Long theatreId = Long.parseLong(theatreIdString);
        Long movieShowId = Long.parseLong(movieShowIdString);

        this.movieShowId = movieShowId;

        selectedSeatsMap.put(movieShowId, new ArrayList<Seat>());

        // lekérni az aktuális foglaltságot, ha még nem volt lekérve
        System.out.println("Querying seats");
        seats = bookSeatService.findAllSeatsOfTheatre(theatreId);

//		for( List<Seat> seatlist : seats ){
//			for( Seat s : seatlist ){
//				System.out.println("GOT SEAT " + s.getId());
//			}
//		}
        // fel kell tölteni a foglalt üléseket
        this.occupiedSeats = bookSeatService.findOccupiedSeatsOfMovieShow(movieShowId);
//		for( Seat s : occupiedSeats){
//			System.out.println("OCCUPIED SEAT: " + s.getId());	
//		}

//		for( List<Seat> seatlist : seats ){
//			for( Seat s : seatlist ){
//				if( s.getId().equals(38L) ){
//					System.out.println("got seat 38");
//					Seat seat = occupiedSeats.get(0);
//					System.out.println("occupied seat: " + seat.getId());
//					System.out.println(s.getId().equals(seat.getId()));
//				}
//			}
//		}
//		for( List<Seat> seatList : seats ){
//			for( Seat s : occupiedSeats) {
//				if( seatList.contains(s) ) {
//					System.out.println("The occupied seat (" + s.getId() + ") is in the seats list!");
//				}
//			}
//		}
        // ha voltak korábbi foglalások, töröljük
        if (this.selectedSeats != null) {
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

    public List<Seat> getOccupiedSeats() {
        return occupiedSeats;
    }

    public void setOccupiedSeats(List<Seat> occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }

    public Map<Long, List<Seat>> getSelectedSeatsMap() {
        return selectedSeatsMap;
    }

    public void setSelectedSeatsMap(Map<Long, List<Seat>> selectedSeatsMap) {
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

}
