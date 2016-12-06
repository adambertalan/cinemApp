package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "error")
@ViewScoped
public class ErrorBean {

	private String errorMessage;

	@PostConstruct
	public void init() {
		Random random = new Random();
		int randomNumber = random.nextInt(5);
		switch (randomNumber) {
		case 0:
			errorMessage = "Hoppá";
			break;
		case 1:
			errorMessage = "A manóba";
			break;
		case 2:
			errorMessage = "A nemjóját";
			break;
		case 3:
			errorMessage = "Nosza";
			break;
		case 4:
			errorMessage = "Ajaj";
			break;
		default:
			errorMessage = "Hopsz";
			break;
		}
	}

	public String backToIndex() {
		return "page";
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
