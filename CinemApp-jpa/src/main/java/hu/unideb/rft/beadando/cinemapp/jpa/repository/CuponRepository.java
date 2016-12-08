package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Cupon;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface CuponRepository extends JpaRepository<Cupon, Long> {
	
	@Query("select cupon from Cupon cupon where cupon.startOfValidity <= CURRENT_TIMESTAMP and cupon.endOfValidity > CURRENT_TIMESTAMP")
	public List<Cupon> findAllValidCupons();
	
	public Cupon findCuponByName(String name);
	
	public Cupon findCuponById(Long id);

}
