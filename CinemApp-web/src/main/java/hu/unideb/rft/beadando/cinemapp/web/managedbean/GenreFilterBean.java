package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hu.unideb.rft.beadando.cinemapp.ejb.api.GenreService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Genre;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;

@ManagedBean(name="genreFilterBean")
@ViewScoped
public class GenreFilterBean {

	@EJB
	private GenreService genreService;
	private List<Genre> genres;
	
	@EJB
	private MovieShowService movieShowService;
	private List<MovieShow> filteredMovieShowList;
	private List<Movie> filteredMovieList;
	
	private Long selectedGenreId;
	
	private List<Timestamp> movieTimes;
	private Timestamp selectedMovieTime;
	
	private Movie selectedMovie;
	
	private Long selectedMovieShowId;
	private Long theatreId;
	
	@PostConstruct
	public void init (){
		genres = genreService.findAllGenre();
		filteredMovieList = new ArrayList<Movie>();
		filteredMovieShowList = new ArrayList<MovieShow>();
		movieTimes = new ArrayList<Timestamp>();
	}
	
	public void filter(){
		filteredMovieList.clear();
		filteredMovieShowList.clear();
		System.out.println(selectedGenreId);
		for(MovieShow movieShow : movieShowService.findAllMovieShow()){
			if(selectedGenreId.equals(movieShow.getMovie().getGenre().getId()) && movieShow.getStartTime().after(new Date())){
				
				if(!filteredMovieList.contains(movieShow.getMovie())){
					filteredMovieList.add(movieShow.getMovie());
					
				}
				filteredMovieShowList.add(movieShow);
			}
		}
	}
	
	public void chooseMovie(){
		movieTimes.clear();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String movieID = params.get("movieID");
		System.out.println(movieID);
		for(Movie movie : filteredMovieList){
			if(movie.getId().equals(Long.parseLong(movieID)))
				selectedMovie = movie;
		}
		for(MovieShow movieShow : filteredMovieShowList){
			if(movieShow.getMovie().getId().equals(Long.parseLong(movieID))){
				movieTimes.add(movieShow.getStartTime());
			}
		}
//		return "chooseMovie";
	}

	public String goToSeatPicking(){
		for(MovieShow movieShow : filteredMovieShowList){
			if(movieShow.getMovie().equals(selectedMovie) && movieShow.getStartTime().equals(selectedMovieTime)){
				selectedMovieShowId = movieShow.getId();
				theatreId = movieShow.getTheatre().getId();
				break;
			}
		}
		return "seatbooking.xhtml?faces-redirect=true&includeViewParams=true";
	}
	
	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public Long getSelectedGenreId() {
		return selectedGenreId;
	}

	public void setSelectedGenreId(Long selectedGenreId) {
		this.selectedGenreId = selectedGenreId;
	}

	public List<MovieShow> getFilteredMovieShowList() {
		return filteredMovieShowList;
	}

	public void setFilteredMovieShowList(List<MovieShow> filteredMovieShowList) {
		this.filteredMovieShowList = filteredMovieShowList;
	}

	public List<Movie> getFilteredMovieList() {
		return filteredMovieList;
	}

	public void setFilteredMovieList(List<Movie> filteredMovieList) {
		this.filteredMovieList = filteredMovieList;
	}

	public List<Timestamp> getMovieTimes() {
		return movieTimes;
	}

	public void setMovieTimes(List<Timestamp> movieTimes) {
		this.movieTimes = movieTimes;
	}

	public Timestamp getSelectedMovieTime() {
		return selectedMovieTime;
	}

	public void setSelectedMovieTime(Timestamp selectedMovieTime) {
		this.selectedMovieTime = selectedMovieTime;
	}

	public Movie getSelectedMovie() {
		return selectedMovie;
	}

	public void setSelectedMovie(Movie selectedMovie) {
		this.selectedMovie = selectedMovie;
	}

	public Long getSelectedMovieShowId() {
		return selectedMovieShowId;
	}

	public void setSelectedMovieShowId(Long selectedMovieShowId) {
		this.selectedMovieShowId = selectedMovieShowId;
	}

	public Long getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Long theatreId) {
		this.theatreId = theatreId;
	}
	
	
	
}
