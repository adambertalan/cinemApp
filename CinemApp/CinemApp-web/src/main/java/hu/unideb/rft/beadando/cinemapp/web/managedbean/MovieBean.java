/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.vo.MovieVo;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.jsf.FacesContextUtils;

//@Component
@ManagedBean(name="movieBean")
@ViewScoped

//@Component
//@ManagedBean(name="movieBean")
//@SessionScoped
//@Component
//@Scope(value="request")
public class MovieBean implements Serializable{
    
//    @ManagedProperty("#{movieService}")
//    @Autowired
    @Autowired
//    @ManagedProperty(value = "#{movieService}")
    MovieService movieService;

    public MovieService getMovieService() {
        return movieService;
    }

//    public void setMovieService(MovieService movieService) {
//        this.movieService = movieService;
//    }
    
    private List<MovieVo> movies;
    
    public List<MovieVo> getMovies() {
        return movies;
    }
    
    public void setMovies(List<MovieVo> movies) {
        this.movies = movies;
    }
    
    @PostConstruct
    public void init() {
        FacesContextUtils
            .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
            .getAutowireCapableBeanFactory().autowireBean(this);
        movies = movieService.findAllMovies();
    }
    
}
