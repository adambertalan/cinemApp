package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Appointment extends BaseId {

	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Guest guest;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private MovieShow movieShow;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Seat seat;

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public MovieShow getMovieShow() {
		return movieShow;
	}

	public void setMovieShow(MovieShow movieShow) {
		this.movieShow = movieShow;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}
