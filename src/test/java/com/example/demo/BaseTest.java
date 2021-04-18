package com.example.demo;

import com.example.demo.model.CredentialRequest;

public class BaseTest {

    public CredentialRequest getCredentialRequest(){
        CredentialRequest credentialRequest = new CredentialRequest();
        credentialRequest.setEmail("abc@gmail.com");
        credentialRequest.setPassword("Random@123");
        credentialRequest.setConfirmPassword("Random@123");
        return credentialRequest;
    }
}
