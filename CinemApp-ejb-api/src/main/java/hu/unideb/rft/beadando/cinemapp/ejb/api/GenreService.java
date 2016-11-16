package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Genre;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.GenreRepository;

@Local
public interface GenreService {
	
	public List<Genre> findAllGenre();
	
	public Genre createGenre(String name);
	
	public GenreRepository getGenreRepository();

}
