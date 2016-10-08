package hu.unideb.rft.beadando.cinemapp.ejb.api;

import hu.unideb.rft.beadando.cinemapp.ejb.api.vo.MovieVo;
import java.util.List;

public interface MovieService {
    
    List<MovieVo> findAllMovies();
}
