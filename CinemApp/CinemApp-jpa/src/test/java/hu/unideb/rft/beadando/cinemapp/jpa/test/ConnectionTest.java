package hu.unideb.rft.beadando.cinemapp.jpa.test;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieRepository;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-test-jpa.xml")
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class ConnectionTest {
    
    @Autowired
    MovieRepository movieRepository;
    
    @Test
    public void DataCreationTest() {
        Movie movie = new Movie();
        
        movie.setAgeLimit(18);
        movie.setName("The movie");
        movie.setRating(4);
        
        movieRepository.save(movie);
    }
    
    @Test
    public void DataFetchTest() {
        
        List<Movie> movies = movieRepository.findAll();
        
        Assert.assertTrue( !movies.isEmpty() );
        Assert.assertTrue( movies.size() == 1 );
    }
    
}
