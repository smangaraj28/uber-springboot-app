package com.app.mycoolapp.dto;

import lombok.Data;

@Data
public class TripResponse {
    private long id;
    private String startLocId;
    private String endLocId;
    private String startTime;
    private String endTime;
    private String status;
    private DriverResponse driverResponse;
    private PassengerResponse passengerResponse;
}
