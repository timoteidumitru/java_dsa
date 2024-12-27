package com.javaPlayground.javaBatch.controller;

import com.javaPlayground.javaBatch.entity.Employee;
import com.javaPlayground.javaBatch.repository.EmployeeRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    @Autowired
    EmployeeRepository employeeRepository;

//    @PostMapping("/import-customers")
//    public List<Customer> importCustomersToDB(){
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addLocalDate("startAt: ", LocalDate.now())
//                .toJobParameters();
//
//        try {
//            jobLauncher.run(job, jobParameters);
//        } catch (JobExecutionAlreadyRunningException | JobParametersInvalidException |
//                 JobInstanceAlreadyCompleteException | JobRestartException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @PostMapping("/import-employee")
    public List<Employee> importEmployeeToDB(){
        JobParameters jobParameters = new JobParametersBuilder()
                .addLocalDate("startAt: ", LocalDate.now())
                .toJobParameters();

        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobParametersInvalidException |
                 JobInstanceAlreadyCompleteException | JobRestartException e) {
            throw new RuntimeException(e);
        }
        return employeeRepository.findAll();
    }

}


// ############################ For 1000 entries dataset ##################################
//   Runs without executors  ||    Runs with executors        ||   Runs with partitioner(for 100k dataset)
// - time: 2.92s             || - time: 1.93s                 || - time: 886ms (2 grid)
// - time: 1.82s             || - time: 1.40s                 || - time: 760ms (4 grid)
// - time: 1.84s             || - time: 1.37s                 || - time: 800ms (10 grid)
// - time: 1.93s             || - time: 1.32s                 || - time: 768ms (5 grid)
// - time: 1.82s(1.66s)      || - time: 1.33s(1.18s)          || - time: 817ms (16 grid)

// ################################# For 100k dataset ##################################
//         Runs without partitioning        ||     Runs with partitioning
//              - time: 14.78s              ||      - time: 9.23s @9.77MB(return data to client)
//              - time: 17.77s              ||      - time: 7.76s (just execution part)
//                                          ||      - time: 52.44s (with @StepScope, avoiding thread starvation)