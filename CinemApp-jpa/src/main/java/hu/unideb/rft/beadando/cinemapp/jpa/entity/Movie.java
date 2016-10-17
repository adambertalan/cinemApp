package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Movie extends BaseName {
   
    private Integer rating;
    
    private Integer ageLimit;

    //In secundums or.. we'll decide.
    private Integer length;

//    private List<String> producers;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

//    public List<String> getProducers() {
//        return producers;
//    }
//
//    public void setProducers(List<String> producers) {
//        this.producers = producers;
//    }

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
}
