package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Movie extends BaseName implements Serializable {
   
    private Integer rating;
    
    private Integer ageLimit;

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

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
