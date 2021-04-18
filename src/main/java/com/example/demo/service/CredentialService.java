package com.example.demo.service;



import com.example.demo.model.Credential;

import java.util.List;

public interface CredentialService {
	List<Credential> getAll();
	void updateCredentials(Credential user);
}