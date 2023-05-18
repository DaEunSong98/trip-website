package com.ssafy.enjoytrip.dto.response;

import com.ssafy.enjoytrip.domain.PlanAttraction;
import com.ssafy.enjoytrip.domain.TripPlan;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TripPlanResponseDto {

    private Long tripPlanId;

    private String planContent;

    private String planName;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<PlanAttraction> planAttractions;

    public TripPlanResponseDto(TripPlan tripPlan) {
        this.tripPlanId = tripPlan.getTripPlanId();
        this.planContent = tripPlan.getPlanContent();
        this.planName = tripPlan.getPlanName();
        this.startDate = tripPlan.getStartDate();
        this.endDate = tripPlan.getEndDate();
        this.planAttractions = tripPlan.getPlanAttractions();
    }
}
