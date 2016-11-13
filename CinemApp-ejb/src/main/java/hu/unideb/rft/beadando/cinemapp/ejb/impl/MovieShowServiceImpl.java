package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieShowRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class MovieShowServiceImpl implements MovieShowService {
	
	@Autowired
	private MovieShowRepository movieShowRepository;

	@Override
	public List<MovieShow> findAllMovieShow() {
		List<MovieShow> allMovieShow = movieShowRepository.findAll();
		return allMovieShow;
	}

}
