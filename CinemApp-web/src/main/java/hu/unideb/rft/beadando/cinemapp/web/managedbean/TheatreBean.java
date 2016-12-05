package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import hu.unideb.rft.beadando.cinemapp.ejb.api.TheatreService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;
import javax.annotation.PostConstruct;

@ManagedBean(name = "theatreBean")
@ViewScoped
public class TheatreBean {
    
    @EJB
    private TheatreService theatreService;
    
    private String name;
    private Integer capacity;
    private Integer theatreNumber;
    
    private List<Theatre> theatres;
    
    @PostConstruct
    public void init() {
    	System.out.println("TheatreBean: init()");
        theatres = theatreService.findAllTheatres();
        System.out.println("Theatres :" + theatres);
    }

    public TheatreService getTheatreService() {
        return theatreService;
    }

    public void setTheatreService(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getTheatreNumber() {
        return theatreNumber;
    }

    public void setTheatreNumber(Integer theatreNumber) {
        this.theatreNumber = theatreNumber;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }
    
}
