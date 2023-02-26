package com.healthcare.cadusers.services;

import com.healthcare.cadusers.entities.User;
import com.healthcare.cadusers.forms.UserForm;
import com.healthcare.cadusers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServices {

    @Autowired
    ValidateServices validateServices;
    @Autowired
    UserRepository userRepository;

    public String saveOperator(UserForm userForm){
        User user = new User(userForm.getName(), userForm.getEmail(), userForm.getCpf(), "T");
        Boolean checkUser = validateUser(user);
        if (Boolean.TRUE.equals(checkUser))
            userRepository.save(user);

        return "user";
    }

    private Boolean validateUser(User user){
        Boolean emailCheck = validateServices.checkEmail(user.getEmail());
        Boolean cpfCheck = validateServices.checkCPF(user.getCpf());
        if (emailCheck && cpfCheck){
            return true;
        }
        return false;
    }



}
