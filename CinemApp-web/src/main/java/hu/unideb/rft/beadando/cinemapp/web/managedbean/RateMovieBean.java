package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.xml.rpc.encoding.SerializationContext;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;

@ManagedBean(name = "rateMovieBean")
@ViewScoped
public class RateMovieBean implements Serializable{
	
	@EJB
	private MovieService movieService;
	
	private Movie movie;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();

        Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();

        String movieIdParam = requestMap.get("movieId");
        
        System.out.println("RATE MOVIE BEAN INIT");
        
        Long movieId = Long.parseLong(movieIdParam);
        
        System.out.println("MOVIE ID: " + movieId);
        
        this.movie = movieService.findMovieById(movieId);
        
	}
	
	public String rate(Integer rate){
		System.out.println(rate);
		
		// jelenlegi pont
		Double rating = this.movie.getRating();
		// hányan pontozták
		Integer rateCounter = movie.getRateCounter();
		rateCounter++;
		
		movie.setRateCounter(rateCounter);
		
		movie.setRating((rating + rate)/rateCounter);
		
		movieService.saveMovie(movie);
		
		return "index?faces-redirect=true";
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
