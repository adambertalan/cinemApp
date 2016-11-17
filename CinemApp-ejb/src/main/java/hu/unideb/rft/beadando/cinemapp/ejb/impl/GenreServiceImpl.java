package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.GenreService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Genre;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.GenreRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({ SpringBeanAutowiringInterceptor.class })
public class GenreServiceImpl implements GenreService {
	
	@EJB
	private MovieService movieService;

	@Override
	public List<Genre> findAllGenre() {
		return movieService.getGenreRepository().findAll();
	}

	@Override
	public GenreRepository getGenreRepository() {
		return movieService.getGenreRepository();
	}

	@Override
	public Genre createGenre(String name) {
		Genre genre = new Genre();
		genre.setName(name);
		movieService.getGenreRepository().save(genre);
		return genre;
	}

}
