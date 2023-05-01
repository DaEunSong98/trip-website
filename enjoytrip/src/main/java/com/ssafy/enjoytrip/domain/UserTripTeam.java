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
public class UserTripTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userTripTeamId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_team_id")
    private TripTeam tripTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
