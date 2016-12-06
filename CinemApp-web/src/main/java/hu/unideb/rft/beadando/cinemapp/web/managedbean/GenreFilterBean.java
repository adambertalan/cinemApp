package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.GenreService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Genre;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;

@ManagedBean(name = "genreFilterBean")
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

	private boolean hasMatch;
	
	@PostConstruct
	public void init() {
		genres = genreService.findAllGenre();
		filteredMovieList = new ArrayList<Movie>();
		filteredMovieShowList = new ArrayList<MovieShow>();
		hasMatch = true;
	}

	public void filter() {
		hasMatch = true;
		filteredMovieList.clear();
		filteredMovieShowList.clear();
		System.out.println(selectedGenreId);
		for (MovieShow movieShow : movieShowService.findAllMovieShow()) {
			if (selectedGenreId.equals(movieShow.getMovie().getGenre().getId())
					&& LocalDateTime.now().plusMinutes(30).isBefore(movieShow.getStartTime().toLocalDateTime())) {

				if (!filteredMovieList.contains(movieShow.getMovie())) {
					filteredMovieList.add(movieShow.getMovie());

				}
				filteredMovieShowList.add(movieShow);
			}
		}
		if(filteredMovieList.size() == 0) hasMatch = false;
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

	public boolean isHasMatch() {
		return hasMatch;
	}

	public void setHasMatch(boolean hasMatch) {
		this.hasMatch = hasMatch;
	}

	
}
