package hu.unideb.rft.beadando.cinemapp.ejb.api;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;

@Local
public interface TheatreService {

	public Theatre findById( Long theatreId );
}
