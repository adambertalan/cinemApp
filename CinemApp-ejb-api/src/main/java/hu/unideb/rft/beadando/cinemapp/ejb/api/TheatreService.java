package hu.unideb.rft.beadando.cinemapp.ejb.api;

import javax.ejb.Local;
import java.util.List;


import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;

@Local
public interface TheatreService {

    public List<Theatre> findAllTheatres();

    public Theatre findById(Long theatreId);
}
