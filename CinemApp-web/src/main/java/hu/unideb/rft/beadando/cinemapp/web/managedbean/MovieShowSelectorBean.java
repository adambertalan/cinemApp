/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Levente
 */
@ManagedBean
@SessionScoped
public class MovieShowSelectorBean {
    
    @EJB
    private MovieService movieService;
    
    @EJB
    private MovieShowService movieShowService;
    
    private Long selectedMovieShowId;
    
    private Timestamp startTime;
    private Timestamp endTime;
    
    private String movieCode;
    
    private Movie selectedMovie;
    
    private List<MovieShow> movieShows;
    private List<MovieShow> allMovieShows;
    private List<Movie> recomendedMovies;

    public String processMovieShowSelector(){
        Map<String,String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	String movieCodeParam = params.get("movieCode");
        setMovieCode(movieCodeParam);
        selectedMovie = movieService.getMovieRepository().findByMovieCode(movieCode);
        recomendedMovies = movieService.getMovieRepository().findAll().stream().filter(x->x.getGenre().getName().equals(selectedMovie.getGenre().getName())&&!x.getName().equals(selectedMovie.getName())).collect(Collectors.toList());
        if(recomendedMovies.size()>3){
            recomendedMovies = recomendedMovies.subList(0, 2);
        }
        allMovieShows = movieShowService.getMovieShowRepository().findByMovieId(selectedMovie.getId());
        movieShows = allMovieShows.stream().filter(x -> x.getStartTime().after(Timestamp.valueOf(LocalDateTime.now().plusMinutes(30)))).collect(Collectors.toList());
        return "page";
    }
    
    public String getMovieShowName(MovieShow movieShow){
        return ("Nap: "+movieShow.getStartTime().getMonth()+1)+"."+movieShow.getStartTime().getDate()+
                " Kezdés: "+movieShow.getStartTime().getHours()+":"+movieShow.getStartTime().getMinutes()
                +" Vége: "+movieShow.getEndTime().getHours()+":"+movieShow.getEndTime().getMinutes();
    }
    
    @PostConstruct
    public void init() {
    }

    public List<MovieShow> getAllMovieShows() {
        return allMovieShows;
    }

    public void setAllMovieShows(List<MovieShow> allMovieShows) {
        this.allMovieShows = allMovieShows;
    }

    public List<Movie> getRecomendedMovies() {
        return recomendedMovies;
    }

    public void setRecomendedMovies(List<Movie> recomendedMovies) {
        this.recomendedMovies = recomendedMovies;
    }
    
    public String getMovieCode() {
        return movieCode;
    }

    public void setMovieCode(String movieCode) {
        System.out.println("lefutottam");
        this.movieCode = movieCode;
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieShowService getMovieShowService() {
        return movieShowService;
    }

    public void setMovieShowService(MovieShowService movieShowService) {
        this.movieShowService = movieShowService;
    }

    public Long getSelectedMovieShowId() {
        return selectedMovieShowId;
    }

    public void setSelectedMovieShowId(Long selectedMovieShowId) {
        this.selectedMovieShowId = selectedMovieShowId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public List<MovieShow> getMovieShows() {
        return movieShows;
    }

    public void setMovieShows(List<MovieShow> movieShows) {
        this.movieShows = movieShows;
    }
    
}
