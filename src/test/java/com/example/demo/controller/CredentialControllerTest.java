package com.example.demo.controller;

import com.example.demo.BaseTest;
import com.example.demo.exceptions.DataValidationException;
import com.example.demo.model.Credential;
import com.example.demo.model.CredentialRequest;
import com.example.demo.service.CredentialService;
import com.example.demo.validator.UserValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class CredentialControllerTest extends BaseTest {

    @Mock
    private CredentialService credentialService;

    @Mock
    private UserValidator userValidator;

    private CredentialController controller;


    @Before
    public void init() {
        controller = new CredentialController(credentialService,userValidator);
    }


    @Test
    public void updateWithValidRequest_Success() {
        CredentialRequest credentialRequest = getCredentialRequest();
        controller.updateCredentials(credentialRequest);
        Assert.assertEquals(HttpStatus.OK, controller.updateCredentials(credentialRequest).getStatusCode());
        Assert.assertEquals("SUCCESS", controller.updateCredentials(credentialRequest).getBody());
    }

    @Test(expected = DataValidationException.class)
    public void updateWithInValidRequest_Failure() {
        CredentialRequest credentialRequest = getCredentialRequest();
        Mockito.when(userValidator.validate(credentialRequest)).thenThrow(DataValidationException.class);
        controller.updateCredentials(credentialRequest);
    }
}
