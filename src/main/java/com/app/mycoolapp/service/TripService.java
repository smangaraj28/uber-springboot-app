package com.app.mycoolapp.service;

import com.app.mycoolapp.dto.BookTripModel;
import com.app.mycoolapp.entity.Driver;
import com.app.mycoolapp.entity.Passenger;
import com.app.mycoolapp.entity.Trip;

import java.util.List;

public interface TripService {

    List<Trip> findAll();

    Trip findById(long theId);

    Trip save(Trip theTrip);

    void deleteById(long theId);

    Trip updateTrip(Trip theTrip);

    List<Trip> findAllByTripObject(Trip theTrip);

}