package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.CuponService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Cupon;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.CuponType;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.CuponRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({ SpringBeanAutowiringInterceptor.class })
public class CuponServiceImpl implements CuponService {
	
	@Autowired
	private CuponRepository cuponRepository;

	@Override
	public List<Cupon> findAllCupon() {
		List<Cupon> cupons = cuponRepository.findAll();
		return cupons;
	}

	@Override
	public Cupon createCupon(String name, Timestamp startOfValidity, Timestamp endOfValidity, CuponType cuponType) {
		Cupon cupon = new Cupon();
		cupon.setName(name);
		cupon.setStartOfValidity(startOfValidity);
		cupon.setEndOfValidity(endOfValidity);
		cupon.setType(cuponType);
		cuponRepository.save(cupon);
		
		return cupon;
	}

	@Override
	public void deleteCupon(Long id) {
		cuponRepository.delete(id);
	}

	@Override
	public CuponRepository getCuponRepository() {
		return cuponRepository;
	}

	@Override
	public List<CuponType> findAllCuponType() {
		List<CuponType> cuponTypes = new ArrayList<CuponType>();
		for(CuponType ct : CuponType.values()){
			cuponTypes.add(ct);
		}
		return cuponTypes;
	}

	@Override
	public List<Cupon> findAllValidCupons() {
		return cuponRepository.findAllValidCupons();
	}

}
