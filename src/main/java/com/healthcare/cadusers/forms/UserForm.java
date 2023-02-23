package com.healthcare.cadusers.forms;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UserForm {
    private String name;
    private String email;
    private String cpf;
    private List<Map<String, String>> phone;
    private List<Map<String, String>> credential;

    public UserForm() {
    }

    public UserForm(String name, String email, String cpf, List<Map<String, String>> phone, List<Map<String, String>> credential) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.phone = phone;
        this.credential = credential;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Map<String, String>> getPhone() {
        return phone;
    }

    public void setPhone(List<Map<String, String>> phone) {
        this.phone = phone;
    }

    public List<Map<String, String>> getCredential() {
        return credential;
    }

    public void setCredential(List<Map<String, String>> credential) {
        this.credential = credential;
    }
}
