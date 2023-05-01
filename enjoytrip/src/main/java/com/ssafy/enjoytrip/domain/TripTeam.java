package com.ssafy.enjoytrip.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Builder
@Entity
public class TripTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripTeamId;
    private String teamName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User master;
}
