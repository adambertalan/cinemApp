package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationController implements Serializable {

    private static final long serialVersionUID = 1L;

    public String processHome() {
        return "page";
    }

    public String processMovies() {
        return "page";
    }

    public String processContact() {
        return "page";
    }

    public String processGYIK() {
        return "page";
    }

    public String processLogin() {
        return "page";
    }

    public String processAdmin() {
        return "page";
    }
    
    public String processFilters(){
    	return "page";
    }
    
}
