package hu.unideb.rft.beadando.cinemapp.jpa.entity;

/**
 * Created by root on 2016. 10. 17..
 */
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
