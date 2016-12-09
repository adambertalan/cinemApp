package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Movie extends BaseName {
   
    private Double rating;
    
    private Integer rateCounter;
    
    private String movieCode;
    
    private Integer ageLimit;
    
    @Basic
    private byte[] image;
    
    @Column(columnDefinition="TEXT")
    private String description;

    // Hossz percben
    private Integer length;
    
    @ManyToOne(fetch=FetchType.EAGER, optional=false)
    private Genre genre;


    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Integer getRateCounter() {
		return rateCounter;
	}

	public void setRateCounter(Integer rateCounter) {
		this.rateCounter = rateCounter;
	}
}
