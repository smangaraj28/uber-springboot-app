package com.app.mycoolapp.service;

import com.app.mycoolapp.dto.SignUpResponse;
import com.app.mycoolapp.dto.SignupModel;
import com.app.mycoolapp.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    public DriverService driverService;

    @Autowired
    public PassengerService passengerService;

    @Autowired
    public EntityMapper entityMapper;

    @Override
    public SignUpResponse signup(SignupModel signupModel) {
        if (signupModel.getType().equals("driver")) {
            return entityMapper.driverToSignupResponse(driverService.signup(signupModel));
        } else if (signupModel.getType().equals("passenger")) {
            return entityMapper.passengerToSignupResponse(passengerService.signup(signupModel));
        } else {
            throw new RuntimeException("This is not a valid type of User");
        }
    }
}
