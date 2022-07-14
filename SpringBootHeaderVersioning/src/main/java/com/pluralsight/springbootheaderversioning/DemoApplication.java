package com.pluralsight.springbootheaderversioning;

import com.pluralsight.springbootheaderversioning.entity.Application;
import com.pluralsight.springbootheaderversioning.repository.ApplicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationRepository applicationRepository) {
        return args -> {
            applicationRepository.save(new Application("Medicine", "Building new structure.", "Bai Tosho"));
            applicationRepository.save(new Application("Education", "Improving our system.", "Bai Medi"));
            applicationRepository.save(new Application("Finance", "Increasing salaries for your employees.", "Bai Galena"));

            for (Application application : applicationRepository.findAll()) {
                System.out.println(application);
            }
        };
    }
}
