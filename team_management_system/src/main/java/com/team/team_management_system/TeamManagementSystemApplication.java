package com.team.team_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages="com.team.dao")
@EntityScan(basePackages="com.team.model")
@ComponentScan(basePackages = {"com.team"})
@SpringBootApplication
public class TeamManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamManagementSystemApplication.class, args);
    }

}
