package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

@ManagedBean(name = "datePickerBean")
@ViewScoped
public class DatePickerBean {

	@EJB
	private MovieShowService movieShowService;

	private List<Movie> filteredMovieList;
	private List<MovieShow> filteredMovieShowList;
	private String filterDate;
	private List<Timestamp> movieTimes;

	private Timestamp selectedTime;
	private Movie selectedMovie;
	private Long selectedMovieShowId;
	private Long theatreId;

	@PostConstruct
	public void init() {
		filteredMovieList = new ArrayList<Movie>();
		filteredMovieShowList = new ArrayList<MovieShow>();
		movieTimes = new ArrayList<Timestamp>();
	}

	public void filter() throws ParseException {
		System.out.println(filterDate);
		filteredMovieList.clear();
		filteredMovieShowList.clear();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
		for (MovieShow movieShow : movieShowService.findAllMovieShow()) {
			if (filterDate.equals(format.format(movieShow.getStartTime()))) {
				if (!filteredMovieList.contains(movieShow.getMovie()))
					filteredMovieList.add(movieShow.getMovie());
				filteredMovieShowList.add(movieShow);
			}
		}
	}

	public String chooseMovie() {
		movieTimes.clear();
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String movieID = params.get("movieID");
		for(Movie movie : filteredMovieList){
			if(movie.getId().equals(Long.parseLong(movieID)))
				selectedMovie = movie;
		}
		System.out.println(movieID);
		for(MovieShow movieShow : filteredMovieShowList){
			if(movieShow.getMovie().getId().equals(Long.parseLong(movieID))){
				movieTimes.add(movieShow.getStartTime());
			}
		}
		return "chooseMovie";
	}
	
	public String goToSeatPicking(){
		for(MovieShow movieShow : filteredMovieShowList){
			if(movieShow.getMovie().equals(selectedMovie) && movieShow.getStartTime().equals(selectedTime)){
				selectedMovieShowId = movieShow.getId();
				theatreId = movieShow.getTheatre().getId();
				break;
			}
		}
		return "seatbooking.xhtml?faces-redirect=true&includeViewParams=true";
	}

	public String getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(String filterDate) {
		this.filterDate = filterDate;
	}

	public List<Timestamp> getMovieTimes() {
		return movieTimes;
	}

	public void setMovieTimes(List<Timestamp> movieTimes) {
		this.movieTimes = movieTimes;
	}

	public Timestamp getSelectedTime() {
		return selectedTime;
	}

	public void setSelectedTime(Timestamp selectedTime) {
		this.selectedTime = selectedTime;
	}

	public List<Movie> getFilteredMovieList() {
		return filteredMovieList;
	}

	public void setFilteredMovieList(List<Movie> filteredMovieList) {
		this.filteredMovieList = filteredMovieList;
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
