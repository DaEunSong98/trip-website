package com.ssafy.enjoytrip.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
public class TripPlan extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripPlanId;
    private String planContent;
    private String planName;

    @OneToMany(mappedBy = "tripPlan", cascade = CascadeType.ALL)
    private List<PlanAttraction> planAttractions = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_team_id")
    private TripTeam tripTeam;

    public void addPlanAttraction(PlanAttraction planAttraction){
        planAttractions.add(planAttraction);
        planAttraction.addTripPlan(this);
    }

    public void addTripTeam(TripTeam tripTeam) {
        this.tripTeam = tripTeam;
    }
}
