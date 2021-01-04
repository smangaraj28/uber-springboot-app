package com.app.mycoolapp.rest;

import com.app.mycoolapp.dto.SignUpResponse;
import com.app.mycoolapp.entity.Driver;
import com.app.mycoolapp.entity.Passenger;
import com.app.mycoolapp.dto.ResponseModel;
import com.app.mycoolapp.dto.SignupModel;
import com.app.mycoolapp.mapper.EntityMapper;
import com.app.mycoolapp.service.DriverService;
import com.app.mycoolapp.service.PassengerService;
import com.app.mycoolapp.service.SignUpService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/signup")
public class SignupRestController {

    @Autowired
    public SignUpService signUpService;

    @PostMapping
    @ResponseBody
    public ResponseModel signup(@RequestBody SignupModel signupModel) {
        ResponseModel responseModel = new ResponseModel();
        SignUpResponse signUpResponse = signUpService.signup(signupModel);
        responseModel.setStatus(200);
        responseModel.setMessage(signupModel.getType() + " Signup Successful");
        responseModel.setDataObject(signUpResponse);
        return responseModel;
    }
}
