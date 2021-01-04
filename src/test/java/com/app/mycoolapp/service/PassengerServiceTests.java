package com.app.mycoolapp.service;

import com.app.mycoolapp.dao.PassengerRepository;
import com.app.mycoolapp.dto.SignupModel;
import com.app.mycoolapp.dto.Status;
import com.app.mycoolapp.entity.Passenger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PassengerServiceTests {

    @InjectMocks
    PassengerServiceImpl passengerService;

    @Mock
    PassengerRepository passengerRepository;

    Passenger testPassenger;
    Passenger testPassengerRequest;

    @Captor
    ArgumentCaptor<Passenger> passengerArgumentCaptor;

    long id = 12;
    String status = "inactive";
    SignupModel signupModelDriver;

    @Before
    public void setup() {
        testPassenger = new Passenger();
        testPassenger.setId(12);
        testPassenger.setStatus(Status.ACTIVE.getCode());
        testPassenger.setGender("female");
        testPassenger.setPhoneNo("544444444");
        testPassenger.setName("biswa");
        testPassengerRequest = new Passenger();
        testPassengerRequest.setId(12);
        testPassengerRequest.setStatus(Status.ACTIVE.getCode());
        testPassengerRequest.setGender("female");
        testPassengerRequest.setPhoneNo("544444444");
        testPassengerRequest.setName("biswa");
    }

    @Test
    public void testFindAllPassengers() {
        List passengerList = Arrays.asList(testPassenger);
        Mockito.when(passengerRepository.findAll()).thenReturn(passengerList);
        List returnedList = passengerService.findAll();
        Mockito.verify(passengerRepository, Mockito.times(1)).findAll();
        Assert.assertNotNull(returnedList);
        Assert.assertEquals(passengerList, returnedList);
    }

    @Test
    public void testFindPassengerById() {
        Mockito.when(passengerRepository.findById(Mockito.eq(id))).thenReturn(Optional.of(testPassenger));
        Passenger returnedPassenger = passengerService.findById(id);
        Mockito.verify(passengerRepository, Mockito.times(1)).findById(id);
        Assert.assertNotNull(returnedPassenger);
        Assert.assertEquals(testPassenger, returnedPassenger);
    }

    @Test(expected = RuntimeException.class)
    public void testFindPassengerNullById() {
        Mockito.when(passengerRepository.findById(Mockito.eq(id))).thenReturn(Optional.empty());
        Passenger returnedPassenger = passengerService.findById(id);
        Mockito.verify(passengerRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testSavePassenger() {
        passengerService.save(testPassenger);
        Mockito.verify(passengerRepository, Mockito.times(1)).save(passengerArgumentCaptor.capture());
        Assert.assertEquals(passengerArgumentCaptor.getValue(), testPassenger);
    }

    @Test
    public void testDeletePassengerById() {
        passengerService.deleteById(id);
        Mockito.verify(passengerRepository, Mockito.times(1)).deleteById(id);
    }

}
