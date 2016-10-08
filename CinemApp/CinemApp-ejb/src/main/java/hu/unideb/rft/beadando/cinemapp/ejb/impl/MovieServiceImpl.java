package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.vo.MovieVo;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieRepository;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    
    @Override
    public List<MovieVo> findAllMovies() {
        List<Movie> allMovie = movieRepository.findAll();
        List<MovieVo> allMovieVo = new ArrayList<>();
        
        ModelMapper mapper = new ModelMapper();
        for (Movie movie : allMovie) {
            allMovieVo.add( mapper.map(movie, MovieVo.class));
        }
        return allMovieVo;
    }
    
}
