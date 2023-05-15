package com.ssafy.enjoytrip.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.enjoytrip.domain.UserTripTeam;

import javax.persistence.EntityManager;
import java.util.Optional;

import static com.ssafy.enjoytrip.domain.QTripTeam.*;
import static com.ssafy.enjoytrip.domain.QUser.*;
import static com.ssafy.enjoytrip.domain.QUserTripTeam.*;

public class UserTripTeamRepositoryImpl implements UserTripTeamRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public UserTripTeamRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<UserTripTeam> getUserTripTeamByUserIdAndTeamId(Long userId, Long teamId) {

        UserTripTeam findUserTripTeam = queryFactory.selectFrom(userTripTeam)
                .join(userTripTeam.tripTeam, tripTeam).fetchJoin()
                .join(userTripTeam.user, user).fetchJoin()
                .where(userTripTeam.user.userId.eq(userId).and(userTripTeam.tripTeam.tripTeamId.eq(teamId)))
                .fetchOne();

        return Optional.ofNullable(findUserTripTeam);
    }

    @Override
    public Optional<UserTripTeam> getUserTripTeamUsingJoin(Long userId, Long teamId, Long tripPlanId) {
        UserTripTeam findUserTripTeam = queryFactory.selectFrom(userTripTeam)
                .join(userTripTeam.tripTeam, tripTeam).fetchJoin()
                .join(userTripTeam.user, user).fetchJoin()
                .where(userTripTeam.user.userId.eq(userId).and(userTripTeam.tripTeam.tripTeamId.eq(teamId)))
                .fetchOne();

        return Optional.ofNullable(findUserTripTeam);
    }
}
