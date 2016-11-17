package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {
	
	public MovieShow findMovieShowById( Long movieShowId );

        public List<MovieShow> findByMovieId( Long movieId );
}
