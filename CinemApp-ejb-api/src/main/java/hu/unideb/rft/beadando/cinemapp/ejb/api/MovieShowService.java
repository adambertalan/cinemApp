package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieShowRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.TheatreRepository;
import java.sql.Timestamp;

@Local
public interface MovieShowService {

	public List<MovieShow> findAllMovieShow();
        
        public MovieShow createMovieShow(Timestamp startTime, Timestamp endTime, Long movieId, Long theatreId);
        
        public void deleteMovieShow(Long movieShowId);
        
        public void sendRateEmailToAppointmentGuests( Long movieShowId );
        
        public void editMovieShow(Long moveiShowId);
        
        public MovieShowRepository getMovieShowRepository();
        
        public MovieRepository getMovieRepository();
        
        public TheatreRepository getTheatreRepository();
        
        public List<MovieShow> findActiveMovieShows();
        
        public void deprecateMovieShowAppointments( Long movieShowId );
        
        public MovieShow findMovieShowById(Long id);
        
        public List<MovieShow> findByMovieIdOrderByStartTime(Long id);
}
