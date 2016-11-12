package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.SeatService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;

@ManagedBean(name = "seatBean")
@ViewScoped
public class SeatBean {

	@EJB
	private SeatService seatService;

	private List<Seat> seats;

	@PostConstruct
	public void init() {
		seats = seatService.findAllSeat();
		System.out.println("Seats :" + seats);
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

}
