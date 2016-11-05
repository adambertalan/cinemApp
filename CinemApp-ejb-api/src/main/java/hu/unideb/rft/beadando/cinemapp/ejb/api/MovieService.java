package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;

@Local
public interface MovieService {

	public List<Movie> findAllMovies();
	
	public void createMovie( String movieName, String movieCode, Integer ageLimit, String description, Integer length, Long genreId );
	
	public void deleteMovie( Long movieId );
}
