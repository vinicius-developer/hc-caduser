package com.healthcare.cadusers.controllers;

import com.healthcare.cadusers.forms.UserForm;
import com.healthcare.cadusers.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CadUsersController {

    @Autowired
    private UserServices userServices;

    @PostMapping("cad/user")
    public String operatorRegistration(@RequestBody UserForm userForm) {
        String result = userServices.saveOperator(userForm);
        return "A";
    }

}
