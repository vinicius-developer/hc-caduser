package com.healthcare.cadusers.controllers;

import com.healthcare.cadusers.forms.UserForm;
import com.healthcare.cadusers.services.UserServices;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
/**
    Também não é legal usar .* não é legal
    
    é melhor utilizar a invocação da classe unica
**/
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@RestController
public class CadUsersController {

    @Autowired
    private UserServices userServices;

    @PostMapping("cad/user")
    public ResponseEntity<?> operatorRegistration(@RequestBody UserForm userForm) {
        
        Map<String, String> result = userServices.saveOperator(userForm);
        /**
            Aqui você pode colocar o retorno em uma linha só 
            
            Também tecnicamente nas regras de Rest quando você registra algo no banco 
            é retornado código 201
            
            e não precisa retornar nada em json quando você cria algo
        **/
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
