package hu.unideb.rft.beadando.cinemapp.web.servlet;

import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;
import hu.unideb.rft.beadando.cinemapp.ejb.api.qsjobs.SchedulerJob;
import hu.unideb.rft.beadando.cinemapp.ejb.api.qsjobs.TestJob;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.MovieShow;

public class StartupContextListener implements ServletContextListener {

	@EJB
	private MovieService movieService;

	@EJB
	private MovieShowService movieShowService;

	Scheduler sched;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("STARTUPCONTEXTLISTENER: contextInitialized!");

		List<MovieShow> activeMovieShows = movieShowService.findActiveMovieShows();
		System.out.println("Active movieShows: " + activeMovieShows.size());

		for( MovieShow activeMovieShow : activeMovieShows ){
			try {
				sched = new StdSchedulerFactory().getScheduler();
				sched.start();
				
				TestJob tj = new TestJob();
				
				System.out.println( tj instanceof Job);
				System.out.println("Scheduler started? : " + sched.isStarted());
				JobDetail job = JobBuilder.newJob(SchedulerJob.class)
						.usingJobData("movieShowId", activeMovieShow.getId())
						.build();
				
				job.getJobDataMap().put("movieShowService", movieShowService);

				// Trigger the job to run now, and then every 40 seconds
				Trigger trigger = TriggerBuilder.newTrigger()
						.startAt(activeMovieShow.getEndTime())
						.build();

				// Tell quartz to schedule the job using our trigger
				 sched.scheduleJob(job, trigger);
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		try {
			sched.shutdown();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
