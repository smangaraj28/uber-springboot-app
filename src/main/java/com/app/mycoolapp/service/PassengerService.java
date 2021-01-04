package com.app.mycoolapp.service;

import com.app.mycoolapp.entity.Passenger;
import com.app.mycoolapp.dto.SignupModel;

import java.util.List;

public interface PassengerService {

    List<Passenger> findAll();

    Passenger findById(long theId);

    Passenger save(Passenger thePassenger);

    void deleteById(long theId);

    boolean checkPassengerStatus(long theId);

    void updatePassenger(Passenger thePassenger);

    List<Passenger> findAvailablePassengers();

    Passenger signup(SignupModel signupModel);

}
