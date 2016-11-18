package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Genre;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.GenreRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<Movie> findAllMovies() {
        List<Movie> allMovie = movieRepository.findAll();
        return allMovie;
    }

    @Override
    public Movie createMovie(String movieName, String movieCode, Integer ageLimit, String description, Integer length,
            Long genreId) {
        Movie movie = new Movie();
        movie.setName(movieName);
        movie.setAgeLimit(ageLimit);
        movie.setDescription(description);
        movie.setLength(length);
        movie.setMovieCode(movieCode);
        movie.setRating(0);

        Genre genre = genreRepository.findOne(genreId);

        movie.setGenre(genre);

        movieRepository.save(movie);
        return movie;
    }

    @Override
    public void deleteMovie(Long movieId) {
        movieRepository.delete(movieId);
    }

    @Override
    public void editMovie(Long movideId) {
        // TODO Auto-generated method stub

    }

    @Override
    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    @Override
    public GenreRepository getGenreRepository() {
        return genreRepository;
    }

}
