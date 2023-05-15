package com.ssafy.enjoytrip.repository;

import com.ssafy.enjoytrip.domain.TripPlan;

import java.util.Optional;

public interface TripPlanRepositoryCustom {
    Optional<TripPlan> findTripPlanByIdJoinTripTeam(Long tripPlanId);

    Optional<TripPlan> findTripPlanByIdJoinPlanAttraction(Long tripPlanId);
}
