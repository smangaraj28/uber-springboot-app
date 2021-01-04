package com.app.mycoolapp.mapper;

import com.app.mycoolapp.dto.SignUpResponse;
import com.app.mycoolapp.dto.TripResponse;
import com.app.mycoolapp.entity.Driver;
import com.app.mycoolapp.entity.Passenger;
import com.app.mycoolapp.entity.Trip;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
public interface EntityMapper {
    
    SignUpResponse driverToSignupResponse(Driver driver);

    SignUpResponse passengerToSignupResponse(Passenger passenger);

    TripResponse tripToTripResponse(Trip trip);
}