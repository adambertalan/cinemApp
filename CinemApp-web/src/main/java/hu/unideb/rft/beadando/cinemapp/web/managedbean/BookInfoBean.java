/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import hu.unideb.rft.beadando.cinemapp.ejb.api.AppointmentService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import java.time.LocalDateTime;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
public class BookInfoBean {
    
    @EJB
    private AppointmentService appointmentService;
    
    private String guestName;
    private String guestPhone;
    private Integer guestZip;
    private String guestEmail;
    private Long appointmentId;
    private MovieShow movieShow;
    
    LocalDateTime start;
    LocalDateTime end;
    
    private Appointment appointment;
    
    
    @PostConstruct
    void init(){
        FacesContext context = FacesContext.getCurrentInstance();

        String requestURI = ((HttpServletRequest) context.getExternalContext().getRequest()).getRequestURI();
        System.out.println("requestURI: " + requestURI);

        Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();

        String appointmentIdString = requestMap.get("appointmentId");

        System.out.println("INIT: appointmentId " + appointmentIdString);

        this.appointmentId = Long.parseLong(appointmentIdString);
        
        appointment = appointmentService.findAppointmentById(appointmentId);
        
        guestName = appointment.getGuest().getName();
        guestPhone = appointment.getGuest().getPhoneNumber();
        guestZip = appointment.getGuest().getZip();
        guestEmail = appointment.getGuest().getEmail();
        movieShow = appointment.getMovieShow();
        
        start = movieShow.getStartTime().toLocalDateTime();
        end = movieShow.getEndTime().toLocalDateTime();
    }
    
    public String getStartString(){
        return start.getMonth().name() + " " + start.getDayOfMonth() + ". " + start.getHour()+":"+start.getMinute();
    }
    
    public String getEndString(){
        return end.getMonth().name() + " " + end.getDayOfMonth() + ". " + end.getHour()+":"+end.getMinute();
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
    
    public AppointmentService getAppointmentService() {
        return appointmentService;
    }

    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public Integer getGuestZip() {
        return guestZip;
    }

    public void setGuestZip(Integer guestZip) {
        this.guestZip = guestZip;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public MovieShow getMovieShow() {
        return movieShow;
    }

    public void setMovieShow(MovieShow movieShow) {
        this.movieShow = movieShow;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    
    
}
