package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movie,Long>{

    public Movie findMovieByName( String movieName );
    
    public Movie findMovieById( Long movieId );
}
