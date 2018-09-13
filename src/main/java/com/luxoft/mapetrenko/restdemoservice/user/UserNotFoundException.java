package com.luxoft.mapetrenko.restdemoservice.user;

import com.luxoft.mapetrenko.restdemoservice.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
