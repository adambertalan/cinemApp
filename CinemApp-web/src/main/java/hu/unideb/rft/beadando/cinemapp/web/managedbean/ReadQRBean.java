package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Faces;

import hu.unideb.rft.beadando.cinemapp.ejb.api.AppointmentService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.GuestService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Cupon;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;

@ManagedBean
@ViewScoped
public class ReadQRBean {
	
	@EJB
	private GuestService guestService;
	
	@EJB
	private AppointmentService appointmentService;
	

	private Boolean valid;

	private Long appointmentId;
	private Long guestId;
	private Long movieShowId;
	private Long movieId;
//	private Long cuponId;
	
	private Movie movie;
	private Theatre theatre;
	private Guest guest;
	private MovieShow movieShow; 
	private List<Seat> seats;
	private Cupon cupon;
	private String cuponValidFrom;
	private String cuponValidTo;
	private Boolean cuponUsable;
	
	private String showStart;
	private String showEnd;
	
	public String useCupon(){
		guest.setUsedCupon(true);
		guestService.saveGuest(guest);
		return "index?faces-redirect=true";
	}
	
	private boolean isNullOrNan( String in ){
		if( in == null ){
			return true;
		}
		try {
			Long.parseLong(in);
		} catch (NumberFormatException nfe ) {
			return true;
		}
		return false;
	} 
	
	@PostConstruct
	public void init() {
		System.out.println("ReadQRBean init()");
		
		String appointmentIdText = Faces.getRequestParameter("appointmentId");
		String guestIdText = Faces.getRequestParameter("guestId");
		String movieShowIdText = Faces.getRequestParameter("movieshowId");
		String movieIdText = Faces.getRequestParameter("movieId");
		
//		String cuponIdText = Faces.getRequestParameter("cuponId");
		
		
		System.out.println("appointmentId " + appointmentIdText);
		System.out.println("guestId " + guestIdText);
		System.out.println("movieShowId " + movieShowIdText);
		System.out.println("movieId " + movieIdText);
//		System.out.println("cuponId " + cuponIdText);
		
		if( isNullOrNan(appointmentIdText) || isNullOrNan(guestIdText) || isNullOrNan(movieShowIdText) || isNullOrNan(movieIdText) ){
			valid = false;
			System.out.println("invalid");
			return;
		}

		appointmentId = Long.parseLong(appointmentIdText);
		guestId = Long.parseLong(guestIdText);
		movieShowId = Long.parseLong(movieShowIdText);
		movieId = Long.parseLong(movieIdText);
		
//		try {
//			cuponId = Long.parseLong(cuponIdText);	
//		} catch( NumberFormatException nfe ){
//			cuponId = null;
//		}
		
		
		Appointment appointment = this.appointmentService.findAppointmentById(appointmentId);
		if( appointment == null ) {
			valid = false;
			System.out.println("invalid");
			return;
		}
		
		MovieShow movieShow = appointment.getMovieShow();
		
		movie = movieShow.getMovie();
		guest = appointment.getGuest();
		seats = appointment.getSeats();
		theatre = movieShow.getTheatre();
		cupon = guest.getCupon();
		
		if( !movie.getId().equals(movieId) || !guest.getId().equals(guestId) || !appointment.getId().equals(appointmentId)
				|| !movieShow.getId().equals(movieShowId) ){
			valid = false;
			System.out.println("invalid");
			return;
		}
		
		valid = true;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm");
		
		Timestamp startTime = movieShow.getStartTime();
		showStart = sdf.format(startTime);
		Timestamp endTime = movieShow.getEndTime();
		showEnd = sdf.format(endTime);
		
//		System.out.println(cuponId);
		
		if( cupon != null ){
			setCuponValidFrom(sdf.format(cupon.getStartOfValidity()));
			setCuponValidTo(sdf.format(cupon.getEndOfValidity()));
			Long now = System.currentTimeMillis();
			if( (cupon.getStartOfValidity().getTime() <= now && cupon.getEndOfValidity().getTime() >= now) && !guest.getUsedCupon() ) {
				cuponUsable = true;
			} else {
				cuponUsable = false;
			}
		}

	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Long getGuestId() {
		return guestId;
	}

	public void setGuestId(Long guestId) {
		this.guestId = guestId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

//	public Long getCuponId() {
//		return cuponId;
//	}
//
//	public void setCuponId(Long cuponId) {
//		this.cuponId = cuponId;
//	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public Long getMovieShowId() {
		return movieShowId;
	}

	public void setMovieShowId(Long movieShowId) {
		this.movieShowId = movieShowId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public String getShowEnd() {
		return showEnd;
	}

	public void setShowEnd(String showEnd) {
		this.showEnd = showEnd;
	}

	public String getShowStart() {
		return showStart;
	}

	public void setShowStart(String showStart) {
		this.showStart = showStart;
	}

	public Cupon getCupon() {
		return cupon;
	}

	public void setCupon(Cupon cupon) {
		this.cupon = cupon;
	}

	public String getCuponValidFrom() {
		return cuponValidFrom;
	}

	public void setCuponValidFrom(String cuponValidFrom) {
		this.cuponValidFrom = cuponValidFrom;
	}

	public String getCuponValidTo() {
		return cuponValidTo;
	}

	public void setCuponValidTo(String cuponValidTo) {
		this.cuponValidTo = cuponValidTo;
	}

	public Boolean getCuponUsable() {
		return cuponUsable;
	}

	public void setCuponUsable(Boolean cuponUsable) {
		this.cuponUsable = cuponUsable;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public MovieShow getMovieShow() {
		return movieShow;
	}

	public void setMovieShow(MovieShow movieShow) {
		this.movieShow = movieShow;
	}

}
