package com.ssafy.enjoytrip.dto;

import lombok.Data;

@Data
public class UserUpdateDto {

    private Long userId;
    private String mail;
    private String name;
    private String password;
    private String phoneNumber;

}
