package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Cupon;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.CuponType;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.CuponRepository;

@Local
public interface CuponService {

	public List<Cupon> findAllCupon();
	
	public Cupon createCupon(String name, Timestamp startOfValidity, Timestamp endOfValidity, CuponType cuponType);
	
	public void deleteCupon(Long id);
	
	public CuponRepository getCuponRepository();
	
	public List<CuponType> findAllCuponType();
	
}