package hu.unideb.rft.beadando.cinemapp.web.socket;

public class SeatMessage {
	
	Integer theatreId;
	Integer seatId;
	Integer movieShowId;
	private Boolean occupyOrFree;
	
	public Integer getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}
	public Integer getSeatId() {
		return seatId;
	}
	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}
	public Integer getMovieShowId() {
		return movieShowId;
	}
	public void setMovieShowId(Integer movieShowId) {
		this.movieShowId = movieShowId;
	}
	public Boolean getOccupyOrFree() {
		return occupyOrFree;
	}
	public void setOccupyOrFree(Boolean occupyOrFree) {
		this.occupyOrFree = occupyOrFree;
	}

}
