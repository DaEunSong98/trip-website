package com.ssafy.enjoytrip.domain;

import javax.persistence.*;

@Entity
public class TripPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripPlanId;
    private String planContent;
    private String planName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_team_id")
    private TripTeam tripTeam;
}
