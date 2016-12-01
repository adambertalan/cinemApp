package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.GenreRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieRepository;

@Local
public interface MovieService {

	public List<Movie> findAllMovies();
	
	public Movie createMovie( String movieName, String movieCode, Integer ageLimit, String description, Integer length, Long genreId );
	
	public void deleteMovie( Long movieId );
	
	public void editMovie(Long movideId);
	
	public Movie findMovieById( Long movieId );
	
	public MovieRepository getMovieRepository();
	
	public GenreRepository getGenreRepository();
	
	public void saveMovie( Movie movie );
	
	public byte[] getImageOfMovie( Long movieId );
}
