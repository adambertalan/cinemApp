package hu.unideb.rft.beadando.cinemapp.ejb.api;

import javax.ejb.Local;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;

@Local
public interface EmailService {

	void sendEmail( String toEmailAddress, String type, String guestName, String guestMessage, String guestEmail, String guestSubject, String qrText, Appointment appointment);
}
