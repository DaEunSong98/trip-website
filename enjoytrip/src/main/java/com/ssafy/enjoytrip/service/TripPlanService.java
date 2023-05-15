package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.PlanAttraction;
import com.ssafy.enjoytrip.domain.TripPlan;

import java.util.List;
import java.util.Optional;

public interface TripPlanService {

    void makeTripPlan(Long userId, Long tripTeamId, String planName, String planContent);

    void addPlanAttractions(Long userId, Long tripTeamId, Long tripPlanId, List<Integer> attractionIdList);

    void deleteTripPlan(Long userId, Long tripPlanId);

    TripPlan getTripPlan(Long tripPlanId);

    List<PlanAttraction> getPlanAttractions(Long tripPlanId);

}
