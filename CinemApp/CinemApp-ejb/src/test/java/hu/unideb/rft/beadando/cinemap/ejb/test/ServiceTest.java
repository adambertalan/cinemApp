package hu.unideb.rft.beadando.cinemap.ejb.test;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import javax.transaction.Transactional;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration("/spring-ejb.xml")
@TransactionConfiguration(defaultRollback = false)
public class ServiceTest {
    
    @Autowired
    MovieService movieService;
    
    public ServiceTest() {
    }
    
    @Ignore
    @Test
    public void serviceTest(){
        Assert.assertNotNull(movieService);
    }
}
