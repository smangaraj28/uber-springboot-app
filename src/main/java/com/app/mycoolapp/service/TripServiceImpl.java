package com.app.mycoolapp.service;

import com.app.mycoolapp.dao.TripRepository;
import com.app.mycoolapp.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    public TripRepository tripRepository;

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public Trip findById(long theId) {
        return null;
    }

    @Override
    public Trip save(Trip theTrip) {
        return tripRepository.save(theTrip);
    }

    @Override
    public void deleteById(long theId) {
    }

    @Override
    public Trip updateTrip(Trip trip) {
        Trip theTrip = tripRepository.findById(trip.getId()).orElseThrow(RuntimeException::new);
        theTrip.setStatus(trip.getStatus());
        theTrip.setEndTime(trip.getEndTime());
        tripRepository.save(theTrip);
        return theTrip;
    }

    @Override
    public List<Trip> findAllByTripObject(Trip theTrip) {
        return null;
    }
}
