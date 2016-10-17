package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Appointment extends BaseName {

	private Date startDate;
    private Date endDate;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    
}
