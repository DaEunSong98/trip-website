package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.TripTeam;

public interface TripTeamService {
    void makeTripTeam(Long userId, String teamName);

    TripTeam findTripTeam(Long tripTeamId);

    void inviteUser(Long userId, Long teamId);
}
