package com.app.mycoolapp.service;

import com.app.mycoolapp.dto.SignUpResponse;
import com.app.mycoolapp.dto.SignupModel;
import com.app.mycoolapp.entity.Driver;
import com.app.mycoolapp.entity.Passenger;
import com.app.mycoolapp.mapper.EntityMapper;
import com.app.mycoolapp.service.DriverService;
import com.app.mycoolapp.service.PassengerService;
import com.app.mycoolapp.service.SignUpServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SignUpServiceTests {

    @InjectMocks
    SignUpServiceImpl signUpService;

    @Mock
    DriverService driverService;

    @Mock
    PassengerService passengerService;

    EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

    SignupModel signupModelDriver;
    SignupModel signupModelPassenger;
    SignUpResponse testSignUpResponse;

    @Before
    public void setup() {
        signupModelPassenger = new SignupModel("passenger", "soumya", "989839148", "male", "sad23");
        testSignUpResponse = new SignUpResponse(11, "soumya", "989839148", "male", "inactive");
        signupModelDriver = new SignupModel("driver", "soumya", "989839148", "male", "sad23");
    }

    @Test
    public void testPassengerSignUp() {
        System.out.println("Test Passenger Signup API");
        Mockito.when(passengerService.signup(Mockito.eq(signupModelPassenger))).thenReturn(new Passenger());
        Mockito.when(entityMapper.passengerToSignupResponse(new Passenger())).thenReturn(testSignUpResponse);
        SignUpResponse signUpResponse = signUpService.signup(signupModelPassenger);
        Assert.assertEquals(testSignUpResponse, signUpResponse);
    }

    @Test
    public void testDriverSignUp() {
        System.out.println("Test Driver Signup API");
        Mockito.when(driverService.signup(Mockito.eq(signupModelDriver))).thenReturn(new Driver());
        Mockito.when(entityMapper.driverToSignupResponse(new Driver())).thenReturn(testSignUpResponse);
        SignUpResponse signUpResponse = signUpService.signup(signupModelDriver);
        Assert.assertEquals(testSignUpResponse, signUpResponse);
    }
}
