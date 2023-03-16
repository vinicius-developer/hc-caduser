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

/**
 *
 * Normalmente o pessoal cria interfaces para os services e colocam
 * os métodos do service lá dentro
 */
@Component
public class UserServices {

    /**
     * Não tem porque a classe ValidateServices ser uma classe com anotação
     * do springboot já que ela não acessa o banco pode ser uma classe normal
     * é mais fácil de testar
     *
     * e quando a injeção de dependência do springboot dá erro é um saco de corrigir
     */
    @Autowired
    ValidateServices validateServices;
    @Autowired
    UserRepository userRepository;

    public Map<String, String> saveOperator(UserForm userForm){
        /**
         * Criar um enum para o parâmetro status
         *
         * Também dá para criar um construtor onde é passado o objeto UserForm de uma vez
         */
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
