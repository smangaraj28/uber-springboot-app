package com.app.mycoolapp.dto;

public enum Status {
    ACTIVE("active"), INACTIVE("inactive"), COMPLETE("complete"), CANCEL("cancel");

    private String code;

    private Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
