package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Appointment extends BaseId {

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Guest guest;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Movie movie;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	private Seat seat;

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
}
