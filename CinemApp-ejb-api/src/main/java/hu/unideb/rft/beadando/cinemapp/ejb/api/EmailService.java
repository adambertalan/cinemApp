package hu.unideb.rft.beadando.cinemapp.ejb.api;

import javax.ejb.Local;

@Local
public interface EmailService {

	void sendEmail( String toEmailAddress, String type, String guestName, String guestMessage, String guestEmail, String guestSubject, String qrText);
}
