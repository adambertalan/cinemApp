package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Guest extends BaseName {

    private String email;
    
    private String phoneNumber;
    
    private Integer zip;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Cupon cupon;
    
    private Boolean usedCupon;

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

	public Cupon getCupon() {
		return cupon;
	}

	public void setCupon(Cupon cupon) {
		this.cupon = cupon;
	}

	public Boolean getUsedCupon() {
		return usedCupon;
	}

	public void setUsedCupon(Boolean usedCupon) {
		this.usedCupon = usedCupon;
	}
}
