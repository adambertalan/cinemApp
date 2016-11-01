package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	@Query("select seat.occupied from Seat seat join seat.theatre theatre where seat.seatRow = ?1 and seat.seatColumn = ?2 and theatre.id = ?3")
	public Boolean isSeatOccupied(Integer seatRow, Integer seatColumn, Long theatreId);

	// @Query("select seat.occupied from Seat seat join seat.theatre theatre
	// where seat.seatRow = ?1 and seat.seatColumn = ?2 and theatre = ?3")
	// public Boolean isSeatOccupied(Integer seatRow, Integer seatColumn,
	// Theatre theatre);
}
