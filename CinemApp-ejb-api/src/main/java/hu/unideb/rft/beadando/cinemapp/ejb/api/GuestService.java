package hu.unideb.rft.beadando.cinemapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;

@Local
public interface GuestService {

	public List<Guest> findAllGuest();
}
