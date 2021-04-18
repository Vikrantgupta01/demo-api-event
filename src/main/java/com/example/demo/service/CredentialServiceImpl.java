package com.example.demo.service;


import com.example.demo.dao.CredentialRepository;
import com.example.demo.model.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CredentialServiceImpl implements CredentialService {

	@Autowired
	private CredentialRepository credentialRepository;

	@Autowired
	private MessagePublisher messagePublisher;

	public List<Credential> getAll() {
		List<Credential> users = credentialRepository.findAll();
		return users;
	}

	@Override
	public void updateCredentials(Credential credential) {
		credentialRepository.save(credential);
		messagePublisher.publish(getEventMessage(credential));
	}

	private String getEventMessage(Credential credential){
		return UUID.randomUUID()+ " : User with email id  "+credential.getEmail()+ " changes the password" ;
	}

}