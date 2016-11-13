package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface SeatRepository extends JpaRepository<Seat, Long> {
	
	public Seat findSeatById(Long seatId);

	@Query("select seat.occupied from Seat seat join seat.theatre theatre where seat.seatRow = ?1 and seat.seatColumn = ?2 and theatre.id = ?3")
	public Boolean isSeatOccupied(Integer seatRow, Integer seatColumn, Long theatreId);
	
	@Query("select seat from Seat seat join seat.theatre theatre where theatre.id = ?1 order by seat.seatRow, seat.seatColumn")
	public LinkedList<Seat> findAllSeatsOfTheatre(Long theatreId);
	
	@Query("select seat from Seat seat join seat.theatre theatre where theatre.id = ?1 and seat.seatRow = ?2 order by seat.seatColumn")
	public List<Seat> findAllSeatsOfRowInTheatre( Long theatreId, Integer row);
	
	@Query("select seat from Seat seat join seat.theatre theatre where theatre.id = ?1 and seat.seatColumn = ?2")
	public List<Seat> findAllSeatsOfColumnInTheatre( Long theatreId, Integer col);

	// @Query("select seat.occupied from Seat seat join seat.theatre theatre
	// where seat.seatRow = ?1 and seat.seatColumn = ?2 and theatre = ?3")
	// public Boolean isSeatOccupied(Integer seatRow, Integer seatColumn,
	// Theatre theatre);
}
