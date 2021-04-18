package com.example.demo.controller;

import com.example.demo.model.CredentialRequest;
import com.example.demo.model.Credential;
import com.example.demo.service.CredentialService;
import com.example.demo.validator.UserValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CredentialController {

	private CredentialService credentialService;

	private UserValidator userValidator;


	@Autowired
	public CredentialController(CredentialService credentialService, UserValidator userValidator) {
		this.credentialService = credentialService;
		this.userValidator = userValidator;
	}

	@PutMapping(value = "/update")
	public ResponseEntity<String> updateCredentials(@Valid @RequestBody CredentialRequest request) {
		this.userValidator.validate(request);
		Credential user = new Credential();
		BeanUtils.copyProperties(request, user);
		this.credentialService.updateCredentials(user);
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}

}
