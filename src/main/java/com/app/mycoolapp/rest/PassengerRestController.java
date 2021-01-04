package com.app.mycoolapp.rest;

import com.app.mycoolapp.entity.Passenger;
import com.app.mycoolapp.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/passengers")
public class PassengerRestController {

    @Autowired
    public PassengerService passengerService;

    @GetMapping()
    public List<Passenger> findAll() {
        return passengerService.findAll();
    }

    @GetMapping("/available")
    @ResponseBody
    public List<Passenger> findAvailablePassengers() {
        return passengerService.findAvailablePassengers();
    }

}
