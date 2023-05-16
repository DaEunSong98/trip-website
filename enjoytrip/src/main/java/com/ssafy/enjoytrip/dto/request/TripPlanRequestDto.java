package com.ssafy.enjoytrip.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TripPlanRequestDto {

    @NotBlank
    private String planName;
    @NotBlank
    private String planContent;
}
