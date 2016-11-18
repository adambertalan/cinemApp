package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

@ManagedBean(name = "movieShowBean")
@ViewScoped
public class MovieShowBean {

    @EJB
    private MovieShowService movieShowService;

    private Long selectedMovieShowId;

    private String startDate; 
    
    private Timestamp startTime;
    private Timestamp endTime;
    private Long movieId;
    private Long theatreId;

    private List<MovieShow> movieShows;

    private static Long movieShowToBeEditedID = null;
    
    public String getMovieShowName(MovieShow movieShow){
        return movieShow.getMovie().getName()+": "+movieShow.getStartTime().toString();
    }

    public void calculateStartTime() throws ParseException{
        System.out.println(startDate);
        SimpleDateFormat formater = new SimpleDateFormat("dd/mm/yyyy hh:mm a",Locale.US);
        Date date = formater.parse(startDate);
        System.out.println(date);
        setStartTime(Timestamp.from(date.toInstant()));
        //setStartTime(Timestamp.from(startDate.toInstant()));
    }
    
    public void addNewOrEditMovieShow() throws IOException, ParseException {
        calculateStartTime();
        System.out.println(startTime);
        this.endTime = Timestamp.valueOf(startTime.toLocalDateTime().plusMinutes(movieShowService.getMovieRepository().findMovieById(movieId).getLength()));
        System.out.println(endTime);
        System.out.println(movieId);
        System.out.println(theatreId);

        if (movieShowToBeEditedID == null) {
            addNewMovieShow();
        } else {
            MovieShow editedMovieShow = movieShowService.getMovieShowRepository().findMovieShowById(movieShowToBeEditedID);
            if (editedMovieShow == null) {
                addNewMovieShow();
                clearFields();
                return;
            }
            editedMovieShow.setStartTime(startTime);
            editedMovieShow.setEndTime(endTime);
            editedMovieShow.setMovie(movieShowService.getMovieRepository().findMovieById(movieId));
            editedMovieShow.setTheatre(movieShowService.getTheatreRepository().findOne(theatreId));
            movieShowService.getMovieShowRepository().save(editedMovieShow);
            movieShows = movieShowService.findAllMovieShow();
            movieShowToBeEditedID = null;
        }

        clearFields();
    }

    private void clearFields() {
        this.startTime = null;
        this.endTime = null;
        this.movieId = 1L;
        this.theatreId = 1L;
    }
    
    private void addNewMovieShow() {
        MovieShow movieShow = movieShowService.createMovieShow(startTime, endTime, movieId, theatreId);
        movieShows.add(movieShow);
    }
    
    public void editMovie() {

        MovieShow selectedMovieShow = movieShowService.getMovieShowRepository().findMovieShowById(selectedMovieShowId);
        if (selectedMovieShow != null) {
            startTime = selectedMovieShow.getStartTime();
            endTime = selectedMovieShow.getEndTime();
            movieId = selectedMovieShow.getMovie().getId();
            theatreId = selectedMovieShow.getTheatre().getId();
            movieShowToBeEditedID = selectedMovieShowId;
        }
    }

    public void deleteMovieShow() {

        movieShowService.deleteMovieShow(selectedMovieShowId);
        movieShows = movieShowService.findAllMovieShow();

    }
    
    @PostConstruct
    public void init() {
        movieShows = movieShowService.findAllMovieShow();
        System.out.println("MovieShows :" + movieShows);
    }

    public List<MovieShow> getMovieShows() {
        return movieShows;
    }

    public void setMovieShows(List<MovieShow> movieShows) {
        this.movieShows = movieShows;
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

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(Long theatreId) {
        this.theatreId = theatreId;
    }

    public static Long getMovieShowToBeEditedID() {
        return movieShowToBeEditedID;
    }

    public static void setMovieShowToBeEditedID(Long movieShowToBeEditedID) {
        MovieShowBean.movieShowToBeEditedID = movieShowToBeEditedID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}
