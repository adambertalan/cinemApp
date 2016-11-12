package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;

@ManagedBean(name = "movieShowBean")
@ViewScoped
public class MovieShowBean {

	@EJB
	private MovieShowService movieShowService;
	
	private List<MovieShow> movieShows;
	
	@PostConstruct
	public void init(){
		movieShows = movieShowService.findAllMovieShow();
		System.out.println("MovieShows :" + movieShows);
	}

	public List<MovieShow> getMovieShows() {
		return movieShows;
	}

	public void setMovieShows(List<MovieShow> movieShows) {
		this.movieShows = movieShows;
	}
	
	
}
