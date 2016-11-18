package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.GenreService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Genre;

@ManagedBean(name = "genreBean")
@ViewScoped
public class GenreBean {

	@EJB
	private GenreService genreService;

	private Long selectedGenreId;

	private String genreName;

	private List<Genre> genres;
	
	private static Long genreToBeEditedId = null;

	@PostConstruct
	public void init() {
		// FacesContextUtils.getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
		// .getAutowireCapableBeanFactory().autowireBean(this);
		genres = genreService.findAllGenre();
		System.out.println("Genres :" + genres);
	}

	public void addNewOrEditGenre() {
		System.out.println(genreName);
		if(genreToBeEditedId == null){
			addNewGenre();
		}else {
			Genre editedGenre = genreService.getGenreRepository().findOne(genreToBeEditedId);
			if(editedGenre == null){
				addNewGenre();
				clearFields();
				return;
			}
			editedGenre.setName(genreName);
			genreService.getGenreRepository().save(editedGenre);
			genres = genreService.findAllGenre();
			genreToBeEditedId = null;
		}
		
		clearFields();
	}
	
	private void clearFields(){
		this.genreName = null;
	}
	
	private void addNewGenre(){
		Genre genre = genreService.createGenre(genreName);
		genres.add(genre);
	}
	
	public void editGenre(){
		Genre genre = genreService.getGenreRepository().findOne(selectedGenreId);
		if(genre != null){
			genreName = genre.getName();
			genreToBeEditedId = selectedGenreId;
		}
	}

	public void deleteGenre() {
		genreService.getGenreRepository().delete(selectedGenreId);
		genres = genreService.findAllGenre();
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

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

}
