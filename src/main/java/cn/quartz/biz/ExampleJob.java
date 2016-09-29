package cn.quartz.biz;

import org.quartz.*;
import org.quartz.Trigger;
import org.springframework.scheduling.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wenqi
 */

public class ExampleJob extends QuartzJobBean {

    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Trigger trigger = jobExecutionContext.getTrigger();
        Date startTime = trigger.getStartTime();
        long minus=new Date().getTime() - startTime.getTime();
        JobDetail jobDetail = jobExecutionContext.getJobDetail();
        System.out.println("触发器：" + trigger.getKey().getName() + " 正在执行！");
        System.out.println("开始时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime));
        long twentyMin = 1 * 30 * 1000;
        TriggerKey triggerKey = trigger.getKey();
        JobKey jobKey = jobDetail.getKey();
        System.out.println("triggerKey:"+triggerKey+",jobKey:"+jobKey);
        System.out.println("触发器已执行" + (minus / 1000 + "秒"));
        if (minus >= twentyMin) {
            try {
                jobExecutionContext.getScheduler().unscheduleJob(triggerKey);
                System.out.println("触发器已经停止");
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }

    }
}
