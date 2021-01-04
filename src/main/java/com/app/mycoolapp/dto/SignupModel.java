package com.app.mycoolapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupModel {
    private String type;
    private String name;
    private String phoneNo;
    private String gender;
    private String cabId;
}
