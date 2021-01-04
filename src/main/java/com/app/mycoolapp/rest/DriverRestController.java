package com.app.mycoolapp.rest;

import com.app.mycoolapp.entity.Driver;
import com.app.mycoolapp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriverRestController {

    @Autowired
    public DriverService driverService;

    @GetMapping()
    public List<Driver> findAll() {
        return driverService.findAll();
    }

    @GetMapping("/available")
    public List<Driver> findAvailableDrivers() {
        return driverService.findAvailableDrivers();
    }
}
