/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.web.jsf.FacesContextUtils;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;

@ManagedBean(name="movieBean")
@SessionScoped
public class MovieBean {
    
    @EJB
    private MovieService movieService;

    public MovieService getMovieService() {	
        return movieService;
    }
    
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}
    
    private List<Movie> movies;
    
    public List<Movie> getMovies() {
        return movies;
    }
    

    
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    @PostConstruct
    public void init() {
        FacesContextUtils
            .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
            .getAutowireCapableBeanFactory().autowireBean(this);
        movies = movieService.findAllMovies();
        System.out.println("Movies :" + movies);
    }

    
}
