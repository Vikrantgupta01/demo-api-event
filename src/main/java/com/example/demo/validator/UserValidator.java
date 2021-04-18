package com.example.demo.validator;

import com.example.demo.dao.CredentialRepository;
import com.example.demo.exceptions.DataValidationException;
import com.example.demo.model.Credential;
import com.example.demo.model.CredentialRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserValidator {

    private CredentialRepository credentialRepository;

    @Autowired
    public UserValidator(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    public boolean validate(CredentialRequest credential){
        if(!isEmailExist(credential.getEmail())){
            throw new DataValidationException("Email id doesnt exist in the system");
        }

        if(!isPasswordMatches(credential)){
            throw new DataValidationException("passwords are not equal");
        }
        return true;
    }

    private boolean isEmailExist(String email){
        Optional<Credential> credential = credentialRepository.findById(email);
        return credential.isPresent();
    }

    public boolean isPasswordMatches(CredentialRequest credential) {
        return credential.getPassword().equals(credential.getConfirmPassword());
    }
}
