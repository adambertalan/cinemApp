package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.AppointmentService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.EmailService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.qsjobs.SchedulerJob;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Appointment;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Guest;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.MovieShowRepository;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.TheatreRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({ SpringBeanAutowiringInterceptor.class })
public class MovieShowServiceImpl implements MovieShowService {

	@Autowired
	private MovieShowRepository movieShowRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private TheatreRepository theatreRepository;

	@EJB
	private AppointmentService appointmentService;
	
	@EJB
	private EmailService emailService;

	@Override
	public List<MovieShow> findAllMovieShow() {
		List<MovieShow> allMovieShow = movieShowRepository.findAll();
		return allMovieShow;
	}

	@Override
	public MovieShow createMovieShow(Timestamp startTime, Timestamp endTime, Long movieId, Long theatreId) {
		MovieShow movieShow = new MovieShow();

		movieShow.setStartTime(startTime);
		movieShow.setEndTime(endTime);

		Movie movie = movieRepository.findMovieById(movieId);
		Theatre theatre = theatreRepository.findOne(theatreId);

		movieShow.setMovie(movie);
		movieShow.setTheatre(theatre);

		movieShowRepository.save(movieShow);

		try {
			Scheduler sched = new StdSchedulerFactory().getScheduler();
			sched.start();

			JobDetail job = JobBuilder.newJob(SchedulerJob.class)
					.usingJobData("movieShowId", movieShow.getId())
					.build();

			job.getJobDataMap().put("movieShowService", this);
			
			Trigger trigger = TriggerBuilder.newTrigger()
					.startAt(movieShow.getEndTime())
					.build();

			sched.scheduleJob(job, trigger);

		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return movieShow;
	}

	@Override
	public void deleteMovieShow(Long movieShowId) {
		movieShowRepository.delete(movieShowId);
	}

	@Override
	public void editMovieShow(Long moveiShowId) {

	}

	@Override
	public MovieShowRepository getMovieShowRepository() {
		return movieShowRepository;
	}

	@Override
	public MovieRepository getMovieRepository() {
		return movieRepository;
	}

	@Override
	public TheatreRepository getTheatreRepository() {
		return theatreRepository;
	}

	@Override
	public List<MovieShow> findActiveMovieShows() {
		return movieShowRepository.findActiveMovieShows();
	}

	@Override
	public void deprecateMovieShowAppointments(Long movieShowId) {
//		MovieShow movieShow = movieShowRepository.findMovieShowById(movieShowId);
		System.out.println("MovieShowServiceImpl: deprecateMovieShowAppointments");
		
		// meg kell keresni az összes foglalást hozzá
		List<Appointment> appointmentsOfMovieShow = appointmentService.findAppointmentsByMovieShow(movieShowId);
		
		System.out.println("deprecating " + appointmentsOfMovieShow.size() +" appointments!");
		
		for (Appointment appointment : appointmentsOfMovieShow) {
			appointment.setDeprecated(true);
		}

	}

	@Override
	public MovieShow findMovieShowById(Long id) {
		
		return movieShowRepository.findMovieShowById(id);
	}

	@Override
	public void sendRateEmailToAppointmentGuests(Long movieShowId) {
		
		System.out.println("MovieShowServiceImpl: sendRateEmailToAppointmentGuests");
		
		List<Appointment> appointmentsOfMovieShow = appointmentService.findAppointmentsByMovieShow(movieShowId);
		
                String link = "http://5.249.154.6:8080/CinemApp-web/rateMovie.xhtml?movieId="+findMovieShowById(movieShowId).getMovie().getId();
                
		for (Appointment appointment : appointmentsOfMovieShow) {
			Guest guest = appointment.getGuest();
			
			this.emailService.sendEmail(guest.getEmail(), "aftermovie", guest.getName(), null, null, null,link,null);
		}
		
	}

	@Override
	public List<MovieShow> findByMovieIdOrderByStartTime(Long id) {
		return movieShowRepository.findByMovieIdOrderByStartTime(id);
	}

}
