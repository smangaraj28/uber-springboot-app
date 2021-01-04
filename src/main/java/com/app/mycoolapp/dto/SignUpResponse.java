package com.app.mycoolapp.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpResponse {
    private long id;
    private String name;
    private String phoneNo;
    private String gender;
    private String status;
}
