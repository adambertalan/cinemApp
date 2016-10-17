package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Rating extends BaseId {

    private Integer rating;

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
