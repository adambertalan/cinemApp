package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;

@ManagedBean(name = "intervalFilterBean")
@ViewScoped
public class IntervalFilterBean {

	@EJB
	private MovieShowService movieShowService;

	private List<MovieShow> filteredMovieShowList;
	private List<Movie> filteredMovieList;

	private List<Timestamp> movieTimes;
	private Timestamp selectedMovieTime;

	private String startOfIntervalString;
	private String endOfIntervalString;

	private Timestamp startOfInterval;
	private Timestamp endOfInterval;
	
	private Movie selectedMovie;
	private Long selectedMovieShowId;
	private Long theatreId;

	@PostConstruct
	public void init() {
		filteredMovieList = new ArrayList<Movie>();
		filteredMovieShowList = new ArrayList<MovieShow>();
		movieTimes = new ArrayList<Timestamp>();
	}

	private void calculateTimes() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
		Date date = formatter.parse(startOfIntervalString);
		startOfInterval = Timestamp.from(date.toInstant());
		date = formatter.parse(endOfIntervalString);
		endOfInterval = Timestamp.from(date.toInstant());
	}

	public void filter() throws ParseException {
		filteredMovieList.clear();
		filteredMovieShowList.clear();
		movieTimes.clear();
		calculateTimes();
		for (MovieShow movieShow : movieShowService.findAllMovieShow()) {
			if (movieShow.getStartTime().after(startOfInterval) && movieShow.getStartTime()
					.before(Timestamp.valueOf(endOfInterval.toLocalDateTime().plusDays(1))) && LocalDateTime.now().plusMinutes(30).isBefore(movieShow.getStartTime().toLocalDateTime())) {
				System.out.println("na");
				if (!filteredMovieList.contains(movieShow.getMovie())){
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
		Long id = Long.parseLong(movieID);
		System.out.println(id);
		for(Movie movie : filteredMovieList){
			if(movie.getId().equals(id)){
				selectedMovie = movie;
				break;
			}
		}
		for(MovieShow movieShow : filteredMovieShowList){
			if(movieShow.getMovie().getId().equals(id)){
				movieTimes.add(movieShow.getStartTime());
			}
		}
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

	public String getStartOfIntervalString() {
		return startOfIntervalString;
	}

	public void setStartOfIntervalString(String startOfIntervalString) {
		this.startOfIntervalString = startOfIntervalString;
	}

	public String getEndOfIntervalString() {
		return endOfIntervalString;
	}

	public void setEndOfIntervalString(String endOfIntervalString) {
		this.endOfIntervalString = endOfIntervalString;
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
