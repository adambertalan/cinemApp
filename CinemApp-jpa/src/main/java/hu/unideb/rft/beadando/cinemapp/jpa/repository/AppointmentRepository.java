package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	  public Appointment findAppointmentById( Long appointmentId );
	  
}
