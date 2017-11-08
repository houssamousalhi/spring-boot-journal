package com.apress.spring;


import com.apress.spring.domain.Journal;
import com.apress.spring.repository.JournalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@SpringBootApplication
public class SpringBootJournalApplication   {

	@Bean
	InitializingBean saveData(JournalRepository repo){
		return () -> {
				repo.save(new Journal("Get to know Spring Boot","Today I will learn Spring Boot","01/01/2016"));
				repo.save(new Journal("Simple Spring Boot Project","I will do my first Spring Boot Project","01/02/2016"));
				repo.save(new Journal("Spring Boot Reading","Read more about Spring Boot","02/01/2016"));
				repo.save(new Journal("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016"));
		};
	}

	private static final Logger log = LoggerFactory.getLogger(SpringBootJournalApplication.class);



	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringBootJournalApplication.class, args);
	}
	@Bean
	String info(){
		return "Just a simple String bean";
	}
	@Autowired
	String info;

    @Value("${server.ip}")
    String serverIp;

    @Bean
    CommandLineRunner values() {
        return args -> {
            log.info(" > The Server IP is: " + serverIp);
        };
    }

}