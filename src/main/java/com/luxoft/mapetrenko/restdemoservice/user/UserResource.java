package com.luxoft.mapetrenko.restdemoservice.user;

import com.luxoft.mapetrenko.restdemoservice.post.Post;
import com.luxoft.mapetrenko.restdemoservice.post.PostRepository;
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

    @Autowired
    private PostRepository posts;

    @GetMapping(path = "/users")
    public List<User> retrieveUsers() {
        return users.findAll();
    }

    @GetMapping(path = "/users/{userId}")
    public User retrieveUserById(@PathVariable Integer userId) {
        Optional<User> user = users.findById(userId);

        if (!user.isPresent()) {
            throw new UserNotFoundException("id: " + userId);
        }

        return user.get();
    }

    @GetMapping(path = "/users/{userId}/posts")
    public List<Post> retrievePostsByuserId(@PathVariable Integer userId) {
        Optional<User> user = users.findById(userId);

        if (!user.isPresent()) {
            throw new UserNotFoundException("id: " + userId);
        }

        return user.get().getPosts();
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

    @PostMapping(path = "/users/{userId}/posts")
    public ResponseEntity createPost(@PathVariable Integer userId, @Valid @RequestBody Post post) {
        Optional<User> user = users.findById(userId);

        if (!user.isPresent()) {
            throw new UserNotFoundException("id: " + userId);
        }

        post.setUser(user.get());

        posts.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .build()
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
