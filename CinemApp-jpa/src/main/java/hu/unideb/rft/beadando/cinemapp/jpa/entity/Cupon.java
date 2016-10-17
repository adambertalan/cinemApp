package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import java.sql.Date;

/**
 * Created by root on 2016. 10. 17..
 */
public class Cupon extends BaseName {

    //Maybe create an enum for this later..
    private Integer type;
    private boolean used;
    private Date startOfValidity;
    private Date endOfValidity;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public Date getStartOfValidity() {
        return startOfValidity;
    }

    public void setStartOfValidity(Date startOfValidity) {
        this.startOfValidity = startOfValidity;
    }

    public Date getEndOfValidity() {
        return endOfValidity;
    }

    public void setEndOfValidity(Date endOfValidity) {
        this.endOfValidity = endOfValidity;
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
