package com.ssafy.enjoytrip.dto.response;

import com.ssafy.enjoytrip.domain.TripTeam;
import lombok.Data;

@Data
public class TripTeamListResponse {

    private Long tripTeamId;

    private String teamName;

    public TripTeamListResponse(TripTeam tripTeam) {
        this.tripTeamId = tripTeam.getTripTeamId();
        this.teamName = tripTeam.getTeamName();
    }
}
