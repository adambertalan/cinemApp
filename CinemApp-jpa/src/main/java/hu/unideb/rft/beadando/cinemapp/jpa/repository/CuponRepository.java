package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Cupon;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface CuponRepository extends JpaRepository<Cupon, Long> {
	
	public Cupon findCuponByName(String name);
	
	public Cupon findCuponById(Long id);

}
