package com.javaPlayground.javaBatch.config;

import com.javaPlayground.javaBatch.dto.EmployeeDTO;
import com.javaPlayground.javaBatch.entity.Employee;
import com.javaPlayground.javaBatch.partition.EmployeePartitioner;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class EmployeeBatchConfig {
    @Autowired
    private EmployeeWriter employeeWriter;

    private LineMapper<EmployeeDTO> lineMapper() {
        DefaultLineMapper<EmployeeDTO> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "name", "age", "salary", "department");

        BeanWrapperFieldSetMapper<EmployeeDTO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(EmployeeDTO.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    public EmployeePartitioner EmployeePartitioner() {
        return new EmployeePartitioner(1, 100001);
    }

    @Bean
    public PartitionHandler EmployeePartitionHandler(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        TaskExecutorPartitionHandler partitionHandler = new TaskExecutorPartitionHandler();
        partitionHandler.setGridSize(10);
        partitionHandler.setTaskExecutor(EmployeeTaskExecutor());
        partitionHandler.setStep(EmployeeSlaveStep(jobRepository, transactionManager));

        return partitionHandler;
    }

    @Bean
    public FlatFileItemReader<EmployeeDTO> EmployeeReader() {
        FlatFileItemReader<EmployeeDTO> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/employee_large_dataset.csv"));
        itemReader.setName("csv-reader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());

        return itemReader;
    }

    @Bean
    public EmployeeProcessor EmployeeProcessor() {
        return new EmployeeProcessor();
    }

    @Bean
    public Step EmployeeSlaveStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("slave-step", jobRepository)
                .<EmployeeDTO, Employee>chunk(10000, transactionManager)
                .reader(EmployeeReader())
                .processor(EmployeeProcessor())
                .writer(employeeWriter)
                .build();
    }

    @Bean
    public Step EmployeeMasterStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("master-step", jobRepository)
                .partitioner(EmployeeSlaveStep(jobRepository, transactionManager).getName(), EmployeePartitioner())
                .partitionHandler(EmployeePartitionHandler(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Job runJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("import-employee", jobRepository)
                .flow(EmployeeMasterStep(jobRepository, transactionManager))
                .end()
                .build();
    }

    @Bean
    public TaskExecutor EmployeeTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setQueueCapacity(20);
        taskExecutor.initialize();
        return taskExecutor;
    }
}

