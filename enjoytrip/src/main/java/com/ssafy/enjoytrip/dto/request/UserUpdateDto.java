package com.ssafy.enjoytrip.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserUpdateDto {

    private Long userId;

    @Email
    @NotBlank
    private String mail;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    @Size(min = 10, max = 11)
    private String phoneNumber;

}
