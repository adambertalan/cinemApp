package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;

@Local
public interface MovieShowService {

	public List<MovieShow> findAllMovieShow();
}
