package hu.unideb.rft.beadando.cinemapp.ejb.api.qsjobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import hu.unideb.rft.beadando.cinemapp.ejb.api.MovieShowService;

public class SchedulerJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobDataMap = context.getMergedJobDataMap();
		long long1 = jobDataMap.getLong("movieShowId");
		
		System.out.println("Quartz job: get long: " + long1 );
		
		MovieShowService mss = (MovieShowService)jobDataMap.get("movieShowService");
		
		System.out.println("Quartz job: get object: " + mss );
		
		mss.deprecateMovieShowAppointments(long1);
		
		mss.sendRateEmailToAppointmentGuests(long1);
	}

}
