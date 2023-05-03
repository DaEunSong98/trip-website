package com.ssafy.enjoytrip.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

/**
 * User <-> Team mapping table 전용 클래스
 */
@Getter
@Builder
@Entity
public class UserTripTeam extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTripTeamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_team_id")
    private TripTeam tripTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void addTripTeam(TripTeam tripTeam) {
        this.tripTeam = tripTeam;
    }
}
