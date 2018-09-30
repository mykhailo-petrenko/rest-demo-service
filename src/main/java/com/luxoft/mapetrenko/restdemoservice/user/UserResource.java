package com.luxoft.mapetrenko.restdemoservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {
    @Autowired
    private UserRepository users;

    @GetMapping(path = "/users")
    public List<User> retrieveUsers() {
        return users.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUserById(@PathVariable Integer id) {
        Optional<User> user = users.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException("id: " + id);
        }

        return user.get();
    }

    @PostMapping(path = "/users")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User newUser = users.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        Optional<User> user = users.findById(id);

        if (!user.isPresent()) {
            throw new UserNotFoundException("id: " + id);
        }

        users.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
