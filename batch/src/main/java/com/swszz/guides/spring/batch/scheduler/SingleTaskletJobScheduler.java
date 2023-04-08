package com.swszz.guides.spring.batch.scheduler;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * packageName    : com.swszz.guides.spring.batch.scheduler
 * fileName       : SingleTaskletJobScheduler
 * author         : 김성원
 * date           : 2023-04-08
 * description    :
 */

public class SingleTaskletJobScheduler extends AbstractScheduler {

    public SingleTaskletJobScheduler(@Qualifier("singleTaskletJob") Job job, JobLauncher jobLauncher) {
        super(job, jobLauncher);
    }

    @Override
    @Scheduled(cron = "0/5 * * * * ?")
    public void run() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        final JobParameters jobParameters = new JobParametersBuilder()
                .addLocalDateTime("startedAt", LocalDateTime.now())
                .toJobParameters();
        jobLauncher.run(job, jobParameters);
    }
}
