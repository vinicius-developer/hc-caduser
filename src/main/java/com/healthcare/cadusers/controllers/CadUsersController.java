package com.healthcare.cadusers.controllers;

import com.healthcare.cadusers.forms.UserForm;
import com.healthcare.cadusers.services.UserServices;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CadUsersController {

    @Autowired
    private UserServices userServices;

    @PostMapping("cad/user")
    public JSONObject operatorRegistration(@RequestBody UserForm userForm) {
        Map<String, String> result = userServices.saveOperator(userForm);
        JSONObject ret = new JSONObject(result);
        return ret;
    }

}
