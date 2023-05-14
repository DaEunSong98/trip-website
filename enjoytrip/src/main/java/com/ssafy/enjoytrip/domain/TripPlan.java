package com.ssafy.enjoytrip.domain;

import lombok.Builder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
public class TripPlan extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripPlanId;
    private String planContent;
    private String planName;

    @OneToMany(mappedBy = "attraction_id", cascade = CascadeType.ALL)
    private List<PlanAttraction> planAttractions = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_team_id")
    private TripTeam tripTeam;

    public void addPlanAttraction(PlanAttraction planAttraction){
        planAttractions.add(planAttraction);
        planAttraction.addTripPlan(this);
    }
}
