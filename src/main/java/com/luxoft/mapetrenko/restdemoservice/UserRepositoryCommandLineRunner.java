package com.luxoft.mapetrenko.restdemoservice;

import com.luxoft.mapetrenko.restdemoservice.user.User;
import com.luxoft.mapetrenko.restdemoservice.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

//@Compone
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
    Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = Arrays.asList(
                new User("John Doe", new Date()),
                new User("Jack Sparrow", new Date()),
                new User("Hugh Laurie", new Date())
        );
        repository.saveAll(users);

        log.info("Users add to storage: " + users);
    }
}
