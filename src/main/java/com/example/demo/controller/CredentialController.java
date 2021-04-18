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
import java.util.List;

@RestController
public class CredentialController {

	@Autowired
	private CredentialService credentialService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Credential> getAll() {
		return credentialService.getAll();
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> updateCredentials(@Valid @RequestBody CredentialRequest request) {
		userValidator.validate(request);
		Credential user = new Credential();
		BeanUtils.copyProperties(request, user);
		credentialService.updateCredentials(user);
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}

}
