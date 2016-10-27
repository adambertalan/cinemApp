package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class MovieShow extends BaseId {
	
	// film kezdete
    private Timestamp startTime;
    // film vége
    private Timestamp endTime;
    
    // melyik film
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    private Movie movie;
    
    // hol
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    private Theatre theatre;

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

}
