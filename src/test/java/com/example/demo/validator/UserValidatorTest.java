package com.example.demo.validator;

import com.example.demo.BaseTest;
import com.example.demo.dao.CredentialRepository;
import com.example.demo.exceptions.DataValidationException;
import com.example.demo.model.Credential;
import com.example.demo.model.CredentialRequest;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserValidatorTest extends BaseTest {

    @Mock
    private CredentialRepository credentialRepository;


    private UserValidator userValidator ;


    @Before
    public void init(){
        userValidator = new UserValidator(credentialRepository);
    }


    @Test
    public void testIsEmailExist_Success(){
        CredentialRequest credentialRequest = getCredentialRequest();
        Mockito.when(credentialRepository.findById(credentialRequest.getEmail())).thenReturn(Optional.of(new Credential()));
        userValidator.validate(credentialRequest);
    }


    @Test(expected = DataValidationException.class)
    public void testIsEmailExist_Failure(){
        CredentialRequest credentialRequest = getCredentialRequest();
        Mockito.when(credentialRepository.findById(credentialRequest.getEmail())).thenReturn(Optional.empty());
        userValidator.validate(credentialRequest);
    }

    @Test(expected = DataValidationException.class)
    public void testPasswordMatch_Failure(){
        CredentialRequest credentialRequest = getCredentialRequest();
        Mockito.when(credentialRepository.findById(credentialRequest.getEmail())).thenReturn(Optional.of(new Credential()));
        credentialRequest.setConfirmPassword("Random@4321");
        userValidator.validate(credentialRequest);
    }


}
