package com.tyss.password.password.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordChecker {

    @GetMapping("/check-password")
    public String checkPassword(@RequestParam String password) {

        if(password.contains(" "))
            return "Password should not contain spaces.";
        if(password.length() < 8 || password.length() > 15)
            return "Password length should be between 8 and 15 characters.";
        if(!password.matches(".*[A-Z].*"))
            return "Password should contain at least one uppercase letter.";
        if(!password.matches(".*[a-z].*"))
            return "Password should contain at least one lowercase letter.";
        if(!password.matches(".*\\d.*"))
            return "Password should contain at least one digit.";
        if(!password.matches(".*[!@#$%^&*()].*"))
            return "Password should contain at least one special character (!@#$%^&*()).";

        return "Password is valid.";

    }
}
