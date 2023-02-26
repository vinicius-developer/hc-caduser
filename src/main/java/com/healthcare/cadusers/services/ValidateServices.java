package com.healthcare.cadusers.services;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class ValidateServices {

    public boolean checkEmail(String email){
        String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(regexEmail, email);
    }

    public Boolean checkCPF(String cpf) {
        cpf = cpf.replaceAll("\\D+", "");
        String regexCPF = "^\\d{11}$";
        return Pattern.matches(regexCPF, cpf);
    }
}
