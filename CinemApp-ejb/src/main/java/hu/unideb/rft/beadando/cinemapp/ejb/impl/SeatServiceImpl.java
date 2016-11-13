package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.SeatService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.SeatRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Override
	public List<Seat> findAllSeat() {
		List<Seat> allSeats = seatRepository.findAll(); 
		return allSeats;
	}

}
