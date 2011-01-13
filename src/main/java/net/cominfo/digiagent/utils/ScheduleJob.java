package net.cominfo.digiagent.utils;

import net.cominfo.digiagent.service.ScheduleService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ScheduleJob extends QuartzJobBean {
	Log log = LogFactory.getLog(this.getClass());

	private static final String APPLICATION_CONTEXT_KEY = "applicationContext";

	private static ScheduleService scheduleService;

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		SchedulerContext schedulerContext = null;
		try {
			schedulerContext = context.getScheduler().getContext();
		} catch (SchedulerException e) {
			throw new JobExecutionException(
					"Failure accessing scheduler context", e);
		}
		ApplicationContext appContext = (ApplicationContext) schedulerContext
				.get(APPLICATION_CONTEXT_KEY);
		if (scheduleService == null) {
			scheduleService = (ScheduleService) appContext
					.getBean("scheduleService");
		}
		scheduleService.outPeriodDeleteCommodity();
	}

}
