package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.TheatreService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.TheatreRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({ SpringBeanAutowiringInterceptor.class })
public class TheatreServiceImpl implements TheatreService {

	@Autowired
	private TheatreRepository theatreRepository;
	
	@Override
	public Theatre findById(Long theatreId) {
		return theatreRepository.findOne(theatreId);
	}

}
