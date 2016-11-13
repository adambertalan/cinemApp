package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Theatre extends BaseId {

    private Integer theatreNumber;
    
    private Integer capacity;
    
    // hány sor van
    private Integer rowNumber;
    
    // hány oszlop van
    private Integer colNumber;

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

	public Integer getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	public Integer getColNumber() {
		return colNumber;
	}

	public void setColNumber(Integer colNumber) {
		this.colNumber = colNumber;
	}    
}
