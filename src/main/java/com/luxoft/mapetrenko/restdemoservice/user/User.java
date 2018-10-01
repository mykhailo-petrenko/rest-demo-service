package com.luxoft.mapetrenko.restdemoservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luxoft.mapetrenko.restdemoservice.post.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Description for User model")
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "usersGen")
    @SequenceGenerator(name="usersGen", sequenceName = "users", initialValue=100, allocationSize = Integer.MAX_VALUE)
    private Integer id;

    @Size(min = 2)
    @ApiModelProperty(notes = "Should be at least 2 symbols")
    private String name;

    @Past
    @ApiModelProperty(notes = "Should be in the past")
    private Date birthday;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Post> posts;

    User() {

    }

    public User(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
