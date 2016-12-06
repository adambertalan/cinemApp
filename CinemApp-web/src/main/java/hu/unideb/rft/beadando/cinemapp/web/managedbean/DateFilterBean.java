package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;

@ManagedBean(name = "dateFilterBean")
@ViewScoped
public class DateFilterBean {

	@EJB
	private MovieShowService movieShowService;

	private List<Movie> filteredMovieList;
	private List<MovieShow> filteredMovieShowList;
	private String filterDate;

	@PostConstruct
	public void init() {
		filteredMovieList = new ArrayList<Movie>();
		filteredMovieShowList = new ArrayList<MovieShow>();

	}

	public void filter() throws ParseException {
		System.out.println(filterDate);
		filteredMovieList.clear();
		filteredMovieShowList.clear();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
		for (MovieShow movieShow : movieShowService.findAllMovieShow()) {
			if (filterDate.equals(format.format(movieShow.getStartTime()))
					&& LocalDateTime.now().plusMinutes(30).isBefore(movieShow.getStartTime().toLocalDateTime())) {
				if (!filteredMovieList.contains(movieShow.getMovie()))
					filteredMovieList.add(movieShow.getMovie());
				filteredMovieShowList.add(movieShow);
			}
		}
	}

	public String getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(String filterDate) {
		this.filterDate = filterDate;
	}

	public List<Movie> getFilteredMovieList() {
		return filteredMovieList;
	}

	public void setFilteredMovieList(List<Movie> filteredMovieList) {
		this.filteredMovieList = filteredMovieList;
	}

}
