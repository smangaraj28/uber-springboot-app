package com.app.mycoolapp.service;

import com.app.mycoolapp.dao.PassengerRepository;
import com.app.mycoolapp.dto.Status;
import com.app.mycoolapp.entity.Passenger;
import com.app.mycoolapp.dto.SignupModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    public PassengerRepository passengerRepository;

    @Override
    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger findById(long theId) {
        return passengerRepository.findById(theId).orElseThrow(RuntimeException::new);
    }

    @Override
    public Passenger save(Passenger thePassenger) {
        return passengerRepository.save(thePassenger);
    }

    @Override
    public void deleteById(long theId) {
        passengerRepository.deleteById(theId);
    }

    @Override
    public boolean checkPassengerStatus(long theId) {
        Passenger thePassenger = passengerRepository.findById(theId).orElseThrow(RuntimeException::new);
        return thePassenger.getStatus().equals(Status.INACTIVE.getCode());
    }

    @Override
    public void updatePassenger(Passenger passenger) {
        Passenger thePassenger = passengerRepository.findById(passenger.getId()).orElseThrow(RuntimeException::new);
        thePassenger.setStatus(passenger.getStatus());
        passengerRepository.save(thePassenger);
    }

    @Override
    public List<Passenger> findAvailablePassengers() {
        return passengerRepository.findByStatusContainingIgnoreCase(Status.INACTIVE.getCode());
    }

    @Override
    public Passenger signup(SignupModel signupModel) {
        Passenger passenger = new Passenger();
        passenger.setId(0);
        passenger.setName(signupModel.getName());
        passenger.setGender(signupModel.getGender());
        passenger.setPhoneNo(signupModel.getPhoneNo());
        passenger.setStatus(Status.INACTIVE.getCode());
        return this.save(passenger);
    }
}
