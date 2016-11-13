package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;

public interface TheatreService {
    
    public List<Theatre> findAllTheatres();
    
}
