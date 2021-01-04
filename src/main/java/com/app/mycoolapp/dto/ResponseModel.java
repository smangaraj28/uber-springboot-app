package com.app.mycoolapp.dto;

import lombok.Data;

@Data
public class ResponseModel {
    private int status;
    private String message;
    private Object dataObject;
}