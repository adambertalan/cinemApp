package hu.unideb.rft.beadando.cinemapp.ejb.api.qsjobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("TestJob: OK");

	}

}
