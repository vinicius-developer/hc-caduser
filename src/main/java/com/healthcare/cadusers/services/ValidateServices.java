package com.healthcare.cadusers.services;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidateServices {

    public boolean checkEmail(String email){
        String regexEmail = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(regexEmail, email);
    }
    public boolean checkLogin(String login){
        String regexLogin = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regexLogin, login);
    }

    public boolean checkCPF(String cpf) {
        cpf = cpf.replaceAll("\\D+", "");
        String regexCPF = "^\\d{11}$";
        return Pattern.matches(regexCPF, cpf);
    }


}
