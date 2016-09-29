package cn.quartz.biz;

import org.quartz.*;
import org.quartz.CronTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.support.*;

import java.util.Set;

/**
 * @author wenqi
 */
//@Component("extraJob")
public class ExtraJob extends QuartzJobBean {


    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        TriggerKey triggerKey=new TriggerKey("cronTrigger");
        JobKey jobKey=new JobKey("exampleJob");
        try {
            Scheduler scheduler=jobExecutionContext.getScheduler();
            if(scheduler.checkExists(triggerKey)){
                System.out.println("exit");
            }else{
                //how to dynamic create a job & trigger
                JobDetail jobDetail=JobBuilder.newJob(ExampleJob.class).withIdentity("exampleJob").storeDurably(true).build();
                System.out.println("not exit");
                Trigger trigger=TriggerBuilder.newTrigger()
                        .withIdentity(triggerKey)
                        .forJob(jobDetail)
                        .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                        .build();
                scheduler.addJob(jobDetail,true);
                scheduler.scheduleJob(trigger);
//                scheduler.start();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
