package com.app.mycoolapp.service;

import com.app.mycoolapp.dao.TripRepository;
import com.app.mycoolapp.dto.Status;
import com.app.mycoolapp.entity.Trip;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceTests {

    @InjectMocks
    TripServiceImpl tripService;

    @Mock
    TripRepository tripRepository;

    Trip testTrip;
    Trip testTripRequest;

    @Before
    public void setup() {
        testTrip = new Trip();
        testTrip.setId(12);
        testTrip.setStatus(Status.ACTIVE.getCode());
        testTrip.setStartTime("20/09/2019");
        testTrip.setEndTime("20/09/2019");
        testTripRequest = new Trip();
        testTrip.setId(12);
        testTrip.setStatus(Status.ACTIVE.getCode());
        testTrip.setStartTime("20/09/2019");
        testTrip.setEndTime("20/09/2019");
    }

    @Test
    public void testFindAllDrivers() {
        List tripList = Arrays.asList(testTrip);
        Mockito.when(tripRepository.findAll()).thenReturn(tripList);
        List returnedList = tripService.findAll();
        Mockito.verify(tripRepository, Mockito.times(1)).findAll();
        Assert.assertNotNull(returnedList);
        Assert.assertEquals(tripList, returnedList);
    }
}
