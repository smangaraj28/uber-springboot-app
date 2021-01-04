package com.app.mycoolapp.dto;

import lombok.Data;

@Data
public class DriverResponse {
    private long id;
    private String name;
    private String phoneNo;
    private String gender;
    private String status;
    private String cabId;
}