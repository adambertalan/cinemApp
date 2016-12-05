package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name ="error")
@ViewScoped
public class ErrorBean {

	public String backToIndex(){
		return "page";
	}
}
