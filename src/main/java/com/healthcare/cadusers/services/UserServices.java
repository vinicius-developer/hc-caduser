package com.healthcare.cadusers.services;

import com.healthcare.cadusers.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserServices {

    public String saveOperator(User user){

        return "user";
    }
}
