package com.app.mycoolapp.service;

import com.app.mycoolapp.dto.BookTripModel;
import com.app.mycoolapp.dto.Status;
import com.app.mycoolapp.dto.TripResponse;
import com.app.mycoolapp.entity.Driver;
import com.app.mycoolapp.entity.Passenger;
import com.app.mycoolapp.entity.Trip;
import com.app.mycoolapp.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TripOperationServiceImpl implements TripOperationService {

    @Autowired
    public PassengerService passengerService;

    @Autowired
    public DriverService driverService;

    @Autowired
    public TripService tripService;

    @Autowired
    public EntityMapper entityMapper;

    @Override
    public TripResponse canceltrip(long tripId) {
        // Update Trip Table (trip_end_time, status = 'cancel')
        Trip trip = new Trip();
        trip.setId(tripId);
        trip.setStatus(Status.CANCEL.getCode());
        trip.setEndTime(new Date().toString());
        TripResponse tripResponse = entityMapper.tripToTripResponse(tripService.updateTrip(trip));
        long driverId = tripResponse.getDriverResponse().getId();
        long passengerId = tripResponse.getPassengerResponse().getId();
        // Update Driver Table (status='inactive') where driverId is given
        Driver driver = new Driver();
        driver.setStatus(Status.INACTIVE.getCode());
        driver.setId(driverId);
        driverService.updateDriver(driver);
        // Update Passenger Table (status='inactive') where passengerId is given
        Passenger passenger = new Passenger();
        passenger.setStatus(Status.INACTIVE.getCode());
        passenger.setId(passengerId);
        passengerService.updatePassenger(passenger);
        return tripResponse;
    }

    @Override
    public TripResponse completetrip(long tripId) {
        // Update Trip Table (trip_end_time, status = 'complete')
        Trip trip = new Trip();
        trip.setId(tripId);
        trip.setStatus(Status.COMPLETE.getCode());
        trip.setEndTime(new Date().toString());
        TripResponse tripResponse = entityMapper.tripToTripResponse(tripService.updateTrip(trip));
        long driverId = tripResponse.getDriverResponse().getId();
        long passengerId = tripResponse.getPassengerResponse().getId();
        // Update Driver Table (status='inactive') where driverId is given
        Driver driver = new Driver();
        driver.setStatus(Status.INACTIVE.getCode());
        driver.setId(driverId);
        driverService.updateDriver(driver);
        // Update Passenger Table (status='inactive') where passengerId is given
        Passenger passenger = new Passenger();
        passenger.setStatus(Status.INACTIVE.getCode());
        passenger.setId(passengerId);
        passengerService.updatePassenger(passenger);
        return tripResponse;
    }


    @Override
    public TripResponse booktrip(BookTripModel bookTripModel) {

        // PassengerID Check (status = "inactive")
        if (!passengerService.checkPassengerStatus(bookTripModel.getPassengerId())) {
            throw new RuntimeException("Booking can't be Possible as Passenger is already on a ride");
        }

        // DriverID Retrieval from all available drivers (status = "inactive") && Select First Available Driver
        long driverId = driverService.getSingleAvailableDriver();

        Driver driver = new Driver();
        driver.setId(driverId);

        Passenger passenger = new Passenger();
        passenger.setId(bookTripModel.getPassengerId());

        // Insert into Trip Table (driverId,passengerId,start_loc_id,end_loc_id,start_time,status="active") , Foreign Key Reference Check
        Trip trip = new Trip();
        trip.setStatus(Status.ACTIVE.getCode());
        trip.setStartLocId(bookTripModel.getStartLocId());
        trip.setEndLocId(bookTripModel.getEndLocId());
        trip.setStartTime(new Date().toString());
        trip.setDriver(driver);
        trip.setPassenger(passenger);
        TripResponse tripResponse = entityMapper.tripToTripResponse(tripService.save(trip));

        String status = Status.ACTIVE.getCode();
        // Update Driver Table  status = "active"
        driver.setStatus(status);
        driverService.updateDriver(driver);

        // Update Passenger Table status = "active"
        passenger.setStatus(status);
        passengerService.updatePassenger(passenger);

        return tripResponse;
    }
}
