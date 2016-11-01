package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.BookSeatService;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.SeatRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({ SpringBeanAutowiringInterceptor.class })
public class BookSeatServiceImpl implements BookSeatService {
	
	@Autowired
    private SeatRepository seatRepository;

	@Override
	public Boolean isSeatOccupied(Integer seatRow, Integer seatColumn, Long theatreId) {
		System.out.println("searching");
		return seatRepository.isSeatOccupied(seatRow, seatColumn, theatreId);
	}

}
