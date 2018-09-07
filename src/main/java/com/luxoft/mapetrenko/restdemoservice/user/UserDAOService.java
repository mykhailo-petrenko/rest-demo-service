package com.luxoft.mapetrenko.restdemoservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount;

    static {
        users.add(new User(1, "John", new Date()));
        users.add(new User(2, "Doe", new Date()));
        users.add(new User(3, "Bill", new Date()));

        usersCount = 3;
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);

        return user;
    }

    public User findOne(Integer id) {
        for (User user: users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }
}