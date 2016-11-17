package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Cupon;

@Local
public interface CuponService {

	public List<Cupon> findAllCupon();
	
	public Cupon createCupon(String name, Timestamp startOfValidity, Timestamp endOfValidity);
	
	public void deleteCupon(Long id);
	
}
