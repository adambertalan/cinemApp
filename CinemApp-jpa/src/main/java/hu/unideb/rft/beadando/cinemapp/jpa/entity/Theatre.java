package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Theatre extends BaseName {

    private Integer theatreNumber;
    private Integer capacity;

    public Integer getTheatreNumber() {
        return theatreNumber;
    }

    public void setTheatreNumber(Integer theatreNumber) {
        this.theatreNumber = theatreNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
