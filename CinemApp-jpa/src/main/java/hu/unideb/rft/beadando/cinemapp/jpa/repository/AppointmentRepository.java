package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	  public Appointment findAppointmentById( Long appointmentId );
	  
	  public List<Appointment> findByGuest( Guest guest );
	  
}
