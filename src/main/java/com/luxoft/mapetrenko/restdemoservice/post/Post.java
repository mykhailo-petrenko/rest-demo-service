package com.luxoft.mapetrenko.restdemoservice.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luxoft.mapetrenko.restdemoservice.user.User;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(generator = "postsGen")
    @SequenceGenerator(name = "postsGen", sequenceName = "posts", initialValue = 100, allocationSize = Integer.MAX_VALUE)
    private int id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    Post() {

    }

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
