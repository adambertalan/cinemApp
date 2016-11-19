package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Appointment extends BaseId {

	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Guest guest;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private MovieShow movieShow;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Seat> seats;

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

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
}
