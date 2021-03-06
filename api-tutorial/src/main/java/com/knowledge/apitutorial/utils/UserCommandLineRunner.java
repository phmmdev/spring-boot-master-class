package com.knowledge.apitutorial.utils;

import com.knowledge.apitutorial.model.User;
import com.knowledge.apitutorial.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory
            .getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) {
        repository.save(new User("Ranga", "Admin"));
        repository.save(new User("Ravi", "User"));
        repository.save(new User("Satish", "Admin"));
        repository.save(new User("Raghu", "User"));

        for (User user : repository.findAll()) {
            log.info(user.toString());
        }

        log.info("Admin users are.....");
        log.info("____________________");
        for (User user : repository.findByRole("Admin")) {
            log.info(user.toString());
        }

        log.info("Admin users with name Satish.....");
        log.info("____________________");
        for (User user : repository.findByRoleAndName("Admin", "Satish")) {
            log.info(user.toString());
        }


    }

}
