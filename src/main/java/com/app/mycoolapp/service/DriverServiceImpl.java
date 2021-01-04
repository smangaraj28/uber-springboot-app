package com.app.mycoolapp.service;

import com.app.mycoolapp.dao.DriverRepository;
import com.app.mycoolapp.dto.Status;
import com.app.mycoolapp.entity.Driver;
import com.app.mycoolapp.dto.SignupModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    public DriverRepository driverRepository;

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Driver findById(long theId) {
        return driverRepository.findById(theId).orElseThrow(RuntimeException::new);
    }

    @Override
    public Driver save(Driver theDriver) {
        return driverRepository.save(theDriver);
    }

    @Override
    public void deleteById(long theId) {
        driverRepository.deleteById(theId);
    }

    @Override
    public long getSingleAvailableDriver() {
        List<Driver> drivers = driverRepository.findFirst1ByStatusContainingIgnoreCase(Status.INACTIVE.getCode());
        return drivers.get(0).getId();
    }

    @Override
    public Driver updateDriver(Driver driver) {
        Driver theDriver = driverRepository.findById(driver.getId()).orElseThrow(RuntimeException::new);
        theDriver.setStatus(driver.getStatus());
        return driverRepository.save(theDriver);
    }

    @Override
    public List<Driver> findAvailableDrivers() {
        return driverRepository.findByStatusContainingIgnoreCase(Status.INACTIVE.getCode());
    }

    @Override
    public Driver signup(SignupModel signupModel) {
        Driver driver = new Driver();
        driver.setId(0);
        driver.setName(signupModel.getName());
        driver.setGender(signupModel.getGender());
        driver.setPhoneNo(signupModel.getPhoneNo());
        driver.setCabId(signupModel.getCabId());
        driver.setStatus(Status.INACTIVE.getCode());
        return this.save(driver);
    }
}
