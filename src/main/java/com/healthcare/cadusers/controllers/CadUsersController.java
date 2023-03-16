package com.healthcare.cadusers.controllers;

import com.healthcare.cadusers.forms.UserForm;
import com.healthcare.cadusers.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * Não utilizar o .* é melhor importar classe por classe
 * tem como mexer na configuração do intellij pra
 * não utilizar
 */
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URISyntaxException;

@RestController
public class CadUsersController {

    @Autowired
    private UserServices userServices;

    @PostMapping("cad/user")
    public ResponseEntity<?> operatorRegistration(@RequestBody UserForm userForm) throws URISyntaxException {

        /**
         * Normalmente quando nós criamos algum registro no banco retornamos
         *
         * o HTTP code 201 e nele não é necessário retornar o body
         *
         * também normalmente quando retornamos o codigo 201 informamos uma url que onde o dado possa ser
         * encontrado depois
         */

        userServices.saveOperator(userForm);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
