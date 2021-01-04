package com.app.mycoolapp.rest;

import com.app.mycoolapp.dto.SignUpResponse;
import com.app.mycoolapp.dto.TripResponse;
import com.app.mycoolapp.entity.Driver;
import com.app.mycoolapp.entity.Passenger;
import com.app.mycoolapp.entity.Trip;
import com.app.mycoolapp.dto.BookTripModel;
import com.app.mycoolapp.dto.ResponseModel;
import com.app.mycoolapp.service.DriverService;
import com.app.mycoolapp.service.PassengerService;
import com.app.mycoolapp.service.TripOperationService;
import com.app.mycoolapp.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/trip")
public class TripRestController {

    @Autowired
    public TripOperationService tripOperationService;

    @PostMapping("/book")
    public ResponseModel bookTrip(@RequestBody BookTripModel bookTripModel) {
        ResponseModel responseModel = new ResponseModel();
        TripResponse tripResponse = tripOperationService.booktrip(bookTripModel);
        responseModel.setMessage("Trip Booked Successfully");
        responseModel.setDataObject(tripResponse);
        responseModel.setStatus(200);
        return responseModel;
    }

    @PutMapping("/complete/{tripId}")
    public ResponseModel completeTrip(@PathVariable long tripId) {
        ResponseModel responseModel = new ResponseModel();
        TripResponse tripResponse = tripOperationService.completetrip(tripId);
        responseModel.setStatus(200);
        responseModel.setMessage("Successfully Cancelled the Trip" + tripId);
        responseModel.setDataObject(tripResponse);
        return responseModel;
    }

    @PutMapping("/cancel/{tripId}")
    public ResponseModel cancelTrip(@PathVariable long tripId) {
        ResponseModel responseModel = new ResponseModel();
        TripResponse tripResponse = tripOperationService.canceltrip(tripId);
        responseModel.setStatus(200);
        responseModel.setMessage("Successfully Cancelled the Trip" + tripId);
        responseModel.setDataObject(tripResponse);
        return responseModel;
    }

}
