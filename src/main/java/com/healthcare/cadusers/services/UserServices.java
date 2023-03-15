package com.healthcare.cadusers.services;

import com.healthcare.cadusers.entities.Credential;
import com.healthcare.cadusers.entities.User;
import com.healthcare.cadusers.forms.UserForm;
import com.healthcare.cadusers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserServices {

    /**
        Mano tira o @Component nessa classe 
        fica mais fácil de testar e é melhor 
        pq os erros do springboot são um saco de resolver
        
        Aí é só instaciar ela como um objeto normal
    **/
    @Autowired
    ValidateServices validateServices;
    @Autowired
    UserRepository userRepository;

    public Map<String, String> saveOperator(UserForm userForm){
        /**
            Cria um Enum para o último parâmetro
            
            E cria um construtor que recebe um objeto
        **/
        User user = new User(userForm.getName(), userForm.getEmail(), userForm.getCpf(), "T");
        Map<String, String> checkUser = validateUser(user);
        Credential credential = userForm.getCredential();
        Map<String, String> checkCredential = validateCredential(credential);
        Map<String, String> ret = new HashMap<>();
        ret.putAll(checkUser);
        ret.putAll(checkCredential);
        return ret;
    }

    private Map<String, String> validateUser(User user){
        boolean emailCheck = validateServices.checkEmail(user.getEmail());
        Map<String, String> ret = new HashMap<>();
        if (!emailCheck)
            ret.put("email", "Email is invalid");

        boolean cpfCheck = validateServices.checkCPF(user.getCpf());
        if (!cpfCheck)
            ret.put("cpf", "CPF is invalid");

        return ret;
    }

    private Map<String, String> validateCredential(Credential credential){
        Map<String, String> ret = new HashMap<>();
        boolean usernameCheck = validateServices.checkUsername(credential.getLogin());
        if (!usernameCheck)
            ret.put("login", "Login is invalid");

        boolean passwordCheck = validateServices.checkPassword(credential.getPassword());
        if (!passwordCheck)
            ret.put("password", "Password is invalid");

        return ret;
    }



}
