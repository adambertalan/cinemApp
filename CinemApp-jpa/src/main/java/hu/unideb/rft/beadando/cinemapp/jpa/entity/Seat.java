package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Seat extends BaseId {
    
    private Integer seatRow;
    
    private Integer seatColumn;
    
    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    private Theatre theatre;

//    public boolean isOccupied() {
//        return occupied;
//    }
//
//    public void setOccupied(boolean occupied) {
//        this.occupied = occupied;
//    }

	public Integer getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(Integer seatRow) {
		this.seatRow = seatRow;
	}

	public Integer getSeatColumn() {
		return seatColumn;
	}

	public void setSeatColumn(Integer seatColumn) {
		this.seatColumn = seatColumn;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
	        return false;

	   Seat seat = (Seat) obj;
	   if( !getId().equals(seat.getId()) )
	       return false;

	   return true;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return getId().intValue();
	}
}
