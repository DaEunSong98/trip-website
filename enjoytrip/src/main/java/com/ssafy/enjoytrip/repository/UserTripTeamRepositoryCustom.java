package com.ssafy.enjoytrip.repository;

import com.ssafy.enjoytrip.domain.UserTripTeam;

import java.util.Optional;

public interface UserTripTeamRepositoryCustom {

    Optional<UserTripTeam> getUserTripTeamByUserIdAndTeamId(Long userId, Long teamId);

    Optional<UserTripTeam> getUserTripTeamUsingJoin(Long userId, Long teamId, Long tripPlanId);
}
