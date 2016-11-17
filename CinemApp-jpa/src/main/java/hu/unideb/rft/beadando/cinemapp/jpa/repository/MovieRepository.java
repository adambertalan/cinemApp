package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface MovieRepository extends JpaRepository<Movie,Long>{

    public Movie findMovieByName( String movieName );
    
    public Movie findMovieById( Long movieId );
    
    public Movie findByMovieCode( String movieCode );
}
