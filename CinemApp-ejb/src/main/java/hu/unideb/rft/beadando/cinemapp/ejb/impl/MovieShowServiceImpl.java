package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieShowRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.TheatreRepository;
import java.sql.Timestamp;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class MovieShowServiceImpl implements MovieShowService {

    @Autowired
    private MovieShowRepository movieShowRepository;
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public List<MovieShow> findAllMovieShow() {
        List<MovieShow> allMovieShow = movieShowRepository.findAll();
        return allMovieShow;
    }

    @Override
    public MovieShow createMovieShow(Timestamp startTime, Timestamp endTime, Long movieId, Long theatreId) {
        MovieShow movieShow = new MovieShow();
        
        movieShow.setStartTime(startTime);
        movieShow.setEndTime(endTime);
        
        Movie movie = movieRepository.findMovieById(movieId);
        Theatre theatre = theatreRepository.findOne(theatreId);
        
        movieShow.setMovie(movie);
        movieShow.setTheatre(theatre);
        
        movieShowRepository.save(movieShow);
        
        return movieShow;
    }

    @Override
    public void deleteMovieShow(Long movieShowId) {
        movieShowRepository.delete(movieShowId);
    }

    @Override
    public void editMovieShow(Long moveiShowId) {
        
    }

    @Override
    public MovieShowRepository getMovieShowRepository() {
        return movieShowRepository;
    }

    @Override
    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    @Override
    public TheatreRepository getTheatreRepository() {
        return theatreRepository;
    }

}
