package com.app.mycoolapp.service;

import com.app.mycoolapp.dao.DriverRepository;
import com.app.mycoolapp.dto.SignupModel;
import com.app.mycoolapp.dto.Status;
import com.app.mycoolapp.entity.Driver;
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
public class DriverServiceTests {

    @InjectMocks
    DriverServiceImpl driverService;

    @Mock
    DriverRepository driverRepository;

    @Captor
    ArgumentCaptor<Driver> driverArgumentCaptor;

    Driver testDriver;
    Driver testDriverRequest;
    long id = 12;
    String status = "inactive";
    SignupModel signupModelDriver;

    @Before
    public void setup() {
        testDriver = new Driver();
        testDriver.setId(12);
        testDriver.setStatus(Status.ACTIVE.getCode());
        testDriver.setCabId("sad23");
        testDriver.setGender("male");
        testDriver.setPhoneNo("989839148");
        testDriver.setName("soumya");
        testDriverRequest = new Driver();
        testDriverRequest.setId(12);
        testDriverRequest.setStatus(Status.ACTIVE.getCode());
        testDriverRequest.setCabId("CAADF12");
        testDriverRequest.setGender("female");
        testDriverRequest.setPhoneNo("544444444");
        testDriverRequest.setName("biswa");
        signupModelDriver = new SignupModel("driver", "soumya", "989839148", "male", "sad23");
    }

    @Test
    public void testFindAllDrivers() {
        List driverList = Arrays.asList(testDriver);
        Mockito.when(driverRepository.findAll()).thenReturn(driverList);
        List returnedList = driverService.findAll();
        Mockito.verify(driverRepository, Mockito.times(1)).findAll();
        Assert.assertNotNull(returnedList);
        Assert.assertEquals(driverList, returnedList);
    }

    @Test
    public void testFindDriverById() {
        Mockito.when(driverRepository.findById(Mockito.eq(id))).thenReturn(Optional.of(testDriver));
        Driver returnedDriver = driverService.findById(id);
        Mockito.verify(driverRepository, Mockito.times(1)).findById(id);
        Assert.assertNotNull(returnedDriver);
        Assert.assertEquals(testDriver, returnedDriver);
    }

    @Test(expected = RuntimeException.class)
    public void testFindDriverNullById() {
        Mockito.when(driverRepository.findById(Mockito.eq(id))).thenReturn(Optional.empty());
        Driver returnedDriver = driverService.findById(id);
        Mockito.verify(driverRepository, Mockito.times(1)).findById(id);
    }

    @Test
    public void testSaveDriver() {
        driverService.save(testDriver);
        Mockito.verify(driverRepository, Mockito.times(1)).save(driverArgumentCaptor.capture());
        Assert.assertEquals(driverArgumentCaptor.getValue(), testDriver);
    }

    @Test
    public void testDeleteDriverById() {
        driverService.deleteById(id);
        Mockito.verify(driverRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void testUpdateDriver() {
        Driver updatedDriver = new Driver();
        updatedDriver.setStatus(Status.ACTIVE.getCode());
        updatedDriver.setCabId("CAADF12");
        updatedDriver.setGender("female");
        updatedDriver.setName("biswa");
        Mockito.when(driverRepository.findById(Mockito.eq(id))).thenReturn(Optional.of(testDriver));
//        Mockito.when(driverRepository.save(Mockito.eq(updatedDriver))).thenReturn(updatedDriver);
        Driver returnedDriver = driverService.updateDriver(testDriverRequest);
        Mockito.verify(driverRepository, Mockito.times(1)).findById(id);
//        Mockito.verify(driverRepository, Mockito.times(1)).save(updatedDriver);
//        Assert.assertNotNull(returnedDriver);
//        Assert.assertEquals("female", returnedDriver.getGender());
    }

    @Test
    public void testGetAvailableDriver() {
        List driverList = Arrays.asList(testDriver);
        Mockito.when(driverRepository.findFirst1ByStatusContainingIgnoreCase(Mockito.eq(status))).thenReturn(driverList);
        long id = driverService.getSingleAvailableDriver();
        Mockito.verify(driverRepository, Mockito.times(1)).findFirst1ByStatusContainingIgnoreCase(status);
        Assert.assertNotNull(id);
        Assert.assertEquals(testDriver.getId(), id);
        driverRepository.findFirst1ByStatusContainingIgnoreCase(Status.INACTIVE.getCode());
    }

    @Test
    public void testFindAvailableDrivers() {
        List driverList = Arrays.asList(testDriver);
        Mockito.when(driverRepository.findByStatusContainingIgnoreCase(status)).thenReturn(driverList);
        List returnedList = driverService.findAvailableDrivers();
        Mockito.verify(driverRepository, Mockito.times(1)).findByStatusContainingIgnoreCase(status);
        Assert.assertNotNull(returnedList);
        Assert.assertEquals(driverList, returnedList);
    }

    @Test
    public void testSignup() {
//        Driver returnedDriver = driverService.signup(signupModelDriver);
//        Assert.assertEquals(testDriver, returnedDriver);
    }
}
