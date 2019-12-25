package com.xiao.systemlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SystemlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemlogApplication.class, args);
    }

}
