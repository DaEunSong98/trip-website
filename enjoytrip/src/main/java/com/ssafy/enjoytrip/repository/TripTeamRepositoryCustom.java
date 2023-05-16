package com.ssafy.enjoytrip.repository;

import com.ssafy.enjoytrip.domain.TripTeam;

import java.util.Optional;

public interface TripTeamRepositoryCustom {

    Optional<TripTeam> getTripTeamByIdUsingJoin(Long tripTeamId);

}
