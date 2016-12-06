package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {
	
	public MovieShow findMovieShowById( Long movieShowId );

        public List<MovieShow> findByMovieId( Long movieId );
        
        @Query("select movieShow from MovieShow movieShow where movieShow.endTime > CURRENT_TIMESTAMP")
        public List<MovieShow> findActiveMovieShows();
        
        public List<MovieShow> findByMovieIdOrderByStartTime(Long id);
}
