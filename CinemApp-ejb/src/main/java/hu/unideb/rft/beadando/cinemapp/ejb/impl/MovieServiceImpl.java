package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({ SpringBeanAutowiringInterceptor.class })
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    
    public List<Movie> findAllMovies() {
        List<Movie> allMovie = movieRepository.findAll();
        return allMovie;
    }
    
}
