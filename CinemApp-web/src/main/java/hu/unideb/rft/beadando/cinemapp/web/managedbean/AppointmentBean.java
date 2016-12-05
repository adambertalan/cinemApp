package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;

import org.omnifaces.util.Ajax;

import hu.unideb.rft.beadando.cinemapp.ejb.api.AppointmentService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.GuestService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.SeatService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Seat;

@ManagedBean(name = "appointmentBean")
@ViewScoped
public class AppointmentBean {

    @EJB
    private AppointmentService appointmentService;
    @EJB
    private GuestService guestService;
    @EJB
    private SeatService seatService;

    private List<Seat> seats;

    private String appointmentGuestName;
    private String appointmentGuestEmail;
    private String appointmentGuestPhoneNumber;
    private Integer appointemntGuestZip;

    private Long appointmentMovieShowId;
    @NotNull
    private String appointmentSeatId = null;

    private Long selectedAppointmentId;

    private static Long appointmentToBeEditedId = null;

    private List<Appointment> appointments;

    @PostConstruct
    public void init() {
        System.out.println("AppointmentBean: init()");
        appointments = appointmentService.findAllAppointments();
        System.out.println("Appointments :" + appointments);
        this.seats = seatService.findAllSeat();
        
        Ajax.update("reservationsForm");
    }

    public void addNewOrEditAppointment() {
        System.out.println(appointmentGuestName);
        System.out.println(appointmentGuestEmail);
        System.out.println(appointmentGuestPhoneNumber);
        System.out.println(appointemntGuestZip);
        System.out.println(appointmentMovieShowId);
        System.out.println(appointmentSeatId);

        if (appointmentToBeEditedId == null) {
            addNewAppointment();
        } else {
            Appointment editedAppointment = appointmentService.getAppointmentRepository().findAppointmentById(appointmentToBeEditedId);
            if (editedAppointment == null) {
                addNewAppointment();
                clearFields();
                return;
            }
            Guest editedGuest = appointmentService.getGuestRepository().findGuestById(editedAppointment.getGuest().getId());
            editedGuest.setName(appointmentGuestName);
            editedGuest.setEmail(appointmentGuestEmail);
            editedGuest.setPhoneNumber(appointmentGuestPhoneNumber);
            editedGuest.setZip(appointemntGuestZip);
            editedAppointment.setGuest(editedGuest);
            editedAppointment.setMovieShow(appointmentService.getMovieShowRepository().findOne(appointmentMovieShowId));

            String[] ids = appointmentSeatId.split(",");
            List<Long> longids = new ArrayList<>();
            for (String str : ids) {
                longids.add(Long.parseLong(str));
            }
            List<Seat> seats = new ArrayList<>();
            for (Long id : longids) {
                Seat seat = appointmentService.getSeatRepository().findOne(id);
                seats.add(seat);
            }
            editedAppointment.setSeats(seats);
            appointmentService.getAppointmentRepository().save(editedAppointment);
            appointmentService.getGuestRepository().save(editedGuest);
            appointments = appointmentService.findAllAppointments();
            appointmentToBeEditedId = null;
        }

        clearFields();

    }

    private void clearFields() {
        this.appointmentGuestName = null;
        this.appointmentGuestEmail = null;
        this.appointmentGuestPhoneNumber = null;
        this.appointemntGuestZip = null;
        this.appointmentMovieShowId = 1L;
        this.appointmentSeatId = "";
    }

    private void addNewAppointment() {
        Guest guest = guestService.createGuest(appointmentGuestName, appointmentGuestEmail, appointmentGuestPhoneNumber,
                appointemntGuestZip);
        System.out.println("Guest Id: " + guest.getId());

        String[] ids = appointmentSeatId.split(",");
        List<Long> longids = new ArrayList<>();
        for (String str : ids) {
            longids.add(Long.parseLong(str));
        }
        Appointment appointment = appointmentService.createAppointment(guest.getId(), appointmentMovieShowId,
                longids);
        appointments.add(appointment);
    }

    public void editAppointment() {
        Appointment selectedAppointment = appointmentService.getAppointmentRepository().findAppointmentById(selectedAppointmentId);
        if (selectedAppointment != null) {
            appointmentGuestName = selectedAppointment.getGuest().getName();
            appointmentGuestEmail = selectedAppointment.getGuest().getEmail();
            appointmentGuestPhoneNumber = selectedAppointment.getGuest().getPhoneNumber();
            appointemntGuestZip = selectedAppointment.getGuest().getZip();
            appointmentMovieShowId = selectedAppointment.getMovieShow().getId();
            appointmentSeatId = "";
            List<Seat> seats = selectedAppointment.getSeats();
            for (Seat seat : seats) {
                appointmentSeatId += seat.getId() + ",";
            }
            if (appointmentSeatId.endsWith(",")) {
                appointmentSeatId = appointmentSeatId.substring(0, appointmentSeatId.length() - 1);
            }
            appointmentToBeEditedId = selectedAppointmentId;
        }
    }

    public String getAppointmentName(Appointment a) {
        return a.getId().toString() + ". " + a.getGuest().getName() + ": " + a.getMovieShow().getMovie().getName();
    }

    public void deleteAppointment() {
        appointmentService.deleteAppointment(selectedAppointmentId);
        appointments = appointmentService.findAllAppointments();
    }

    public AppointmentService getAppointmentSerevice() {
        return appointmentService;
    }

    public void setAppointmentSerevice(AppointmentService appointmentSerevice) {
        this.appointmentService = appointmentSerevice;
    }

    public String getAppointmentGuestName() {
        return appointmentGuestName;
    }

    public void setAppointmentGuestName(String appointmentGuestName) {
        this.appointmentGuestName = appointmentGuestName;
    }

    public String getAppointmentGuestEmail() {
        return appointmentGuestEmail;
    }

    public void setAppointmentGuestEmail(String appointmentGuestEmail) {
        this.appointmentGuestEmail = appointmentGuestEmail;
    }

    public String getAppointmentGuestPhoneNumber() {
        return appointmentGuestPhoneNumber;
    }

    public void setAppointmentGuestPhoneNumber(String appointmentGuestPhoneNumber) {
        this.appointmentGuestPhoneNumber = appointmentGuestPhoneNumber;
    }

    public Integer getAppointemntGuestZip() {
        return appointemntGuestZip;
    }

    public void setAppointemntGuestZip(Integer appointemntGuestZip) {
        this.appointemntGuestZip = appointemntGuestZip;
    }

    public Long getAppointmentMovieShowId() {
        return appointmentMovieShowId;
    }

    public void setAppointmentMovieShowId(Long appointmentMovieShowId) {
        this.appointmentMovieShowId = appointmentMovieShowId;
    }

    public String getAppointmentSeatId() {
        return appointmentSeatId;
    }

    public void setAppointmentSeatId(String appointmentSeatId) {
        this.appointmentSeatId = appointmentSeatId;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Long getSelectedAppointmentId() {
        return selectedAppointmentId;
    }

    public void setSelectedAppointmentId(Long selectedAppointmentId) {
        this.selectedAppointmentId = selectedAppointmentId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

}
