package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Movie extends BaseName {
   
    private Integer rating;
    
    private Integer ageLimit;
    
    private String description;

    // Hossz percben
    private Integer length;
    
    // film kezdete
    private Timestamp startTime;
    // film vége
    private Timestamp endTime;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    private Genre genre;
    
    // melyik teremben adják
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    private Theatre theatre;


    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}    
}
