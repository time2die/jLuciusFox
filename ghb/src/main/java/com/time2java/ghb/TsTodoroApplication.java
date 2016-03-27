package com.time2java.ghb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@Import(SpringFabric.class)
public class TsTodoroApplication {

    public static void main(String[] args) {
        SpringApplication.run(TsTodoroApplication.class);
    }
}