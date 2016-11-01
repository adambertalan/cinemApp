package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.web.jsf.FacesContextUtils;

import hu.unideb.rft.beadando.cinemapp.ejb.api.BookSeatService;

@ManagedBean(name = "bookSeat")
@ViewScoped
public class BookSeatBean {
	
	@EJB
	private BookSeatService bookSeatService;
	
	private Boolean occupied;
	
	@PostConstruct
    public void init() {
        FacesContextUtils
            .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
            .getAutowireCapableBeanFactory().autowireBean(this);
        occupied = bookSeatService.isSeatOccupied(1, 1, 1L);
        System.out.println(occupied);
    }
	
	public void onChange() {
		System.out.println("onChange()");
	}

	public Boolean getOccupied() {
		return occupied;
	}

	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}

	public BookSeatService getBookSeatService() {
		return bookSeatService;
	}

	public void setBookSeatService(BookSeatService bookSeatService) {
		this.bookSeatService = bookSeatService;
	}
	
	

}
