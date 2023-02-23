package com.healthcare.cadusers.controllers;

import com.healthcare.cadusers.entities.User;
import com.healthcare.cadusers.forms.UserForm;
import com.healthcare.cadusers.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadUsersController {

    @Autowired
    private UserServices userServices;

    @RequestMapping("cad/user")
    private String OperatorRegistration(@RequestBody UserForm userForm) {
        System.out.println(userForm.getPhone());
        //        String result = userServices.saveOperator(user);
        return "A";
    }

}
