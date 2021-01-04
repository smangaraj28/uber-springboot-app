package com.app.mycoolapp.dto;

import lombok.Data;

@Data
public class BookTripModel {
    private long passengerId;
    private String startLocId;
    private String endLocId;
}
