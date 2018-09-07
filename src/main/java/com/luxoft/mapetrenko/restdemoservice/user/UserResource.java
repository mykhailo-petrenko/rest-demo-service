package com.luxoft.mapetrenko.restdemoservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDAOService users;

    @GetMapping(path = "/users")
    public List<User> retrieveUsers() {
        return users.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUserById(@PathVariable Integer id) {
        return users.findOne(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity createUser(@RequestBody User user) {
        User newUser = users.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
