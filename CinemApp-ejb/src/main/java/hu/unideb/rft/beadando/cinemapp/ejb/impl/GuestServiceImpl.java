package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.GuestService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.GuestRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({ SpringBeanAutowiringInterceptor.class})
public class GuestServiceImpl implements GuestService {
	
	@Autowired
	private GuestRepository guestRepository;

	@Override
	public List<Guest> findAllGuest() {
		List<Guest> allGuests = guestRepository.findAll();
		return allGuests;
	}

}
