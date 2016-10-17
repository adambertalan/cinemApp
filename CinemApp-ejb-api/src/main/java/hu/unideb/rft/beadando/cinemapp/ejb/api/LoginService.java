package hu.unideb.rft.beadando.cinemapp.ejb.api;

import javax.ejb.Local;

@Local
public interface LoginService {

	public Boolean validate(String username, String password);
}
