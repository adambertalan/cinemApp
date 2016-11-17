package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import hu.unideb.rft.beadando.cinemapp.ejb.api.CuponService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Cupon;


@ManagedBean(name ="cuponBean")
@ViewScoped
public class CuponBean {

	@EJB
	private CuponService cuponsService;
	
	private List<Cupon> cupons;
	
	private Long selectedCuponId;
	
	private String startDate;
	private String endDate;
	
	private String cuponName;
	private Timestamp startOfValidity;
	private Timestamp endOfValidity;
	
	@PostConstruct
	public void init(){
		cupons = cuponsService.findAllCupon();
		System.out.println("Cupons: " + cupons);
	}
	
	public void calculateTime() throws ParseException{
        System.out.println(startDate);
        System.out.println(endDate);
        SimpleDateFormat formater = new SimpleDateFormat("dd/mm/yyyy hh:mm a",Locale.US);
        Date date = formater.parse(startDate);
        System.out.println(date);
        setStartOfValidity(Timestamp.from(date.toInstant()));
        date = formater.parse(endDate);
        System.out.println(date);
        setEndOfValidity(Timestamp.from(date.toInstant()));
        //setStartTime(Timestamp.from(startDate.toInstant()));
    }

	public void addNewCupon() throws ParseException{
		calculateTime();
		System.out.println(cuponName);
		System.out.println(startOfValidity);
		System.out.println(endOfValidity);

		cuponsService.createCupon(cuponName, startOfValidity, endOfValidity);
		cupons = cuponsService.findAllCupon();
		
		clearFields();
	}
	
	public void clearFields(){
		this.cuponName = null;
		this.startOfValidity = null;
		this.endOfValidity = null;
		this.startDate = null;
		this.endDate = null;
	}


	
	public void editCupon(){
		
	}
	
	public void deleteCupon(){
		cuponsService.deleteCupon(selectedCuponId);
		cupons = cuponsService.findAllCupon();
	}
	
	public List<Cupon> getCupons() {
		return cupons;
	}

	public void setCupons(List<Cupon> cupons) {
		this.cupons = cupons;
	}

	public String getCuponName() {
		return cuponName;
	}

	public void setCuponName(String cuponName) {
		this.cuponName = cuponName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getSelectedCuponId() {
		return selectedCuponId;
	}

	public void setSelectedCuponId(Long selectedCuponId) {
		this.selectedCuponId = selectedCuponId;
	}

	public Timestamp getStartOfValidity() {
		return startOfValidity;
	}

	public void setStartOfValidity(Timestamp startOfValidity) {
		this.startOfValidity = startOfValidity;
	}

	public Timestamp getEndOfValidity() {
		return endOfValidity;
	}

	public void setEndOfValidity(Timestamp endOfValidity) {
		this.endOfValidity = endOfValidity;
	}
}
