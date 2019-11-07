package com.gctchina.demo.service.sch;

import com.gctchina.demo.dao.entity.Etl_cron;
import com.gctchina.demo.dao.repository.sec.Etl_cronRepositoryB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class TestScheduleTask implements SchedulingConfigurer {

    private static final Logger LOG = LoggerFactory.getLogger(TestScheduleTask.class);
    private String cronId="1001";

    @Autowired      //注入mapper
    @SuppressWarnings("all")
    Etl_cronRepositoryB etl_cronRepositoryB;


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        taskRegistrar.addTriggerTask(

                () -> exejob(),

                triggerContext -> {

                    Optional<Etl_cron> etl_cron = etl_cronRepositoryB.findById(cronId);
                    if (!etl_cron.isPresent()||false==etl_cron.get().getEnable()) {

                        LOG.error("获取执行计划【"+this.cronId+"】失败或该计划已被禁用，请检查数据库配置信息，");
                        return null;
                    }

                    return new CronTrigger(etl_cron.get().getCronstr()).nextExecutionTime(triggerContext);
                }
        );
    }

    private String exejob()
    {
        LOG.info("执行计划【"+cronId+"】开始执行+++++++++++++++++++++++++++");
        String resultMessage="success";

        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timekey = sdf.format(new Date());
        LOG.info(timekey);


        Etl_cron etl_cron = etl_cronRepositoryB.findById(cronId).get();
        etl_cron.setLasttimekey(timekey);
        etl_cronRepositoryB.save(etl_cron);

        LOG.info("执行计划【"+cronId+"】执行完毕+++++++++++++++++++++++++++");
        return resultMessage;
    }

}