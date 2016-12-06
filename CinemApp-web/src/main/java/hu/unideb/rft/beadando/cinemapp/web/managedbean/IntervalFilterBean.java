package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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


	private String startOfIntervalString;
	private String endOfIntervalString;

	private Timestamp startOfInterval;
	private Timestamp endOfInterval;


	@PostConstruct
	public void init() {
		filteredMovieList = new ArrayList<Movie>();
		filteredMovieShowList = new ArrayList<MovieShow>();
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
		calculateTimes();
		for (MovieShow movieShow : movieShowService.findAllMovieShow()) {
			if (movieShow.getStartTime().after(startOfInterval)
					&& movieShow.getStartTime().before(Timestamp.valueOf(endOfInterval.toLocalDateTime().plusDays(1)))
					&& LocalDateTime.now().plusMinutes(30).isBefore(movieShow.getStartTime().toLocalDateTime())) {
				if (!filteredMovieList.contains(movieShow.getMovie())) {
					filteredMovieList.add(movieShow.getMovie());

				}
				filteredMovieShowList.add(movieShow);
			}
		}
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

	
}
