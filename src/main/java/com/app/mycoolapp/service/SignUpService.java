package com.app.mycoolapp.service;

import com.app.mycoolapp.dto.SignUpResponse;
import com.app.mycoolapp.dto.SignupModel;

public interface SignUpService {
    SignUpResponse signup(SignupModel signupModel);
}
