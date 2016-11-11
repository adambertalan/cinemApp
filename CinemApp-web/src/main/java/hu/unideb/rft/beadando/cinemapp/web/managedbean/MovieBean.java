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
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;

@ManagedBean(name = "movieBean")
@ViewScoped
public class MovieBean {

	@EJB
	private MovieService movieService;

	private Long selectedMovieId;

	private String movieName;
	private String movieCode;
	private String movieDescription;
	private Integer movieAgeLimit;
	private Long movieGenreId;
	private Integer movieLength;
	

	private static Long movieToBeEditedID = null;
	
	private List<Movie> movies;

	@PostConstruct
	public void init() {
		System.out.println("called");
//		FacesContextUtils.getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
//				.getAutowireCapableBeanFactory().autowireBean(this);
		movies = movieService.findAllMovies();
		System.out.println("Movies :" + movies);
	}

	public void addNewMovie() {
		System.out.println(movieName);
		System.out.println(movieCode);
		System.out.println(movieDescription);
		System.out.println(movieAgeLimit);
		System.out.println(movieGenreId);
		System.out.println(movieLength);
		
		if(movieToBeEditedID == null){
			addMovie();
		}else{
			Movie editedMovie = movieService.getMovieRepository().findMovieById(movieToBeEditedID);
			if(editedMovie == null){
				addMovie();
				clearTextFields();
				return;
			}
			editedMovie.setName(movieName);
			editedMovie.setMovieCode(movieCode);
			editedMovie.setDescription(movieDescription);
			editedMovie.setAgeLimit(movieAgeLimit);
			editedMovie.setGenre(movieService.getGenreRepository().findOne(movieGenreId));
			editedMovie.setLength(movieLength);
			movieService.getMovieRepository().save(editedMovie);
			movies = movieService.findAllMovies();
			movieToBeEditedID = null;
		}

		clearTextFields();
	}
	
	private void clearTextFields(){
		this.movieName = null;
		this.movieCode = null;
		this.movieDescription = null;
		this.movieAgeLimit = null;
		this.movieLength = null;
		this.movieGenreId = 1L;
	}
	
	private void addMovie(){
		Movie movie = movieService.createMovie(movieName, movieCode, movieAgeLimit, movieDescription, movieLength,
				movieGenreId);
		movies.add(movie);
	}

	public void editMovie() {
		
			Movie selectedMovie = movieService.getMovieRepository().findMovieById(selectedMovieId);
			if(selectedMovie != null){
				movieName = selectedMovie.getName();
				movieCode = selectedMovie.getMovieCode();
				movieAgeLimit = selectedMovie.getAgeLimit();
				movieLength = selectedMovie.getLength();
				movieGenreId = selectedMovie.getGenre().getId();
				movieDescription = selectedMovie.getDescription();
				movieToBeEditedID = selectedMovieId;
			}
	}

	public void deleteMovie() {
		
		movieService.deleteMovie(selectedMovieId);
		movies = movieService.findAllMovies();

	}

	public MovieService getMovieService() {
		return movieService;
	}

	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public Integer getMovieAgeLimit() {
		return movieAgeLimit;
	}

	public void setMovieAgeLimit(Integer movieAgeLimit) {
		this.movieAgeLimit = movieAgeLimit;
	}

	public Long getMovieGenreId() {
		return movieGenreId;
	}

	public void setMovieGenreId(Long movieGenreId) {
		this.movieGenreId = movieGenreId;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Integer getMovieLength() {
		return movieLength;
	}

	public void setMovieLength(Integer movieLength) {
		this.movieLength = movieLength;
	}

	public Long getSelectedMovieId() {
		return selectedMovieId;
	}

	public void setSelectedMovieId(Long selectedMovieId) {
		this.selectedMovieId = selectedMovieId;
	}
	
}
