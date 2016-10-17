package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Guest extends BaseName{

    private String email;
    private String phoneNumber;
    private Integer zip;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }
}
