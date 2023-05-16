package com.ssafy.enjoytrip.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.enjoytrip.domain.TripPlan;

import javax.persistence.EntityManager;
import java.util.Optional;

import static com.ssafy.enjoytrip.domain.QPlanAttraction.*;
import static com.ssafy.enjoytrip.domain.QTripPlan.*;
import static com.ssafy.enjoytrip.domain.QTripTeam.*;

public class TripPlanRepositoryImpl implements TripPlanRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public TripPlanRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<TripPlan> findTripPlanByIdJoinTripTeam(Long tripPlanId) {
        TripPlan findTripPlan = queryFactory
                .selectFrom(tripPlan)
                .join(tripPlan.tripTeam, tripTeam).fetchJoin()
                .where(tripPlan.tripPlanId.eq(tripPlanId))
                .fetchOne();
        return Optional.ofNullable(findTripPlan);
    }

    @Override
    public Optional<TripPlan> findTripPlanByIdJoinPlanAttraction(Long tripPlanId) {
        TripPlan findTripPlan = queryFactory
                .selectFrom(tripPlan)
                .join(tripPlan.planAttractions, planAttraction).fetchJoin()
                .where(tripPlan.tripPlanId.eq(tripPlanId))
                .fetchOne();
        return Optional.ofNullable(findTripPlan);
    }

    @Override
    public void deleteTripPlanByTripTeamId(Long tripTeamId) {
        queryFactory.delete(tripPlan)
                .where(tripPlan.tripTeam.tripTeamId.eq(tripTeamId))
                .execute();
    }
}
