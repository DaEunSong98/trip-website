package com.ssafy.enjoytrip.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class TripPlanRequestDto {

    @NotBlank
    private String planName;

    @NotBlank
    private String planContent;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;
}
