package com.ssafy.enjoytrip.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserInviteDto {

    @NotBlank
    private Long userId;

    @NotBlank
    private Long teamId;
}
