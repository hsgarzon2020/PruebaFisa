package com.fisa.assesment.conference_management.management;

import com.fisa.assesment.conference_management.util.ConferenceConstants;
import com.fisa.assesment.conference_management.domain.Talk;
import com.fisa.assesment.conference_management.domain.TalkDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.RegexLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;


@Configuration
@EnableBatchProcessing
public class ManagementExecutor {

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("spring_batch");
    }

    @Bean
    public FlatFileItemReader<TalkDTO> reader() {
        BeanWrapperFieldSetMapper<TalkDTO> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(TalkDTO.class);

        DefaultLineMapper<TalkDTO> lineMapper = new DefaultLineMapper<TalkDTO>();
        RegexLineTokenizer rlt = new RegexLineTokenizer();
        rlt.setRegex("(.*\\s?)(\\s.*)");
        rlt.setNames("title", "duration");
        lineMapper.setLineTokenizer(rlt);
        lineMapper.setFieldSetMapper(new ManagementFieldSetMapper());

        return new FlatFileItemReaderBuilder<TalkDTO>()
                .name("EventsItemReader")
                .resource(new ClassPathResource(ConferenceConstants.TALKS_FILE)) //.delimited().delimiter("|").names("title", "duration")
                .lineMapper(lineMapper)
                .comments("# Talks input")
                .build();
    }

    @Bean
    public ManagementWriter writer() { return new ManagementWriter(); }

    @Bean
    public ManagementProcessor processor() {
        return new ManagementProcessor();
    }

    @Bean
    public Job conferenceManagementJob(JobCompletionNotificationListener listener, Step step1, JobBuilderFactory jobBuilderFactory) {
        return jobBuilderFactory.get("conferenceManagementJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("step1")
                .<TalkDTO, Talk>chunk(19)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .throttleLimit(1)
                .build();
    }
}
