package com.ssafy.enjoytrip.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TripTeam extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripTeamId;

    private String teamName;

    @OneToMany(mappedBy = "tripTeam", cascade = CascadeType.ALL)
    private List<UserTripTeam> userTripTeams = new ArrayList<>();

    @Builder
    public TripTeam(Long tripTeamId, String teamName) {
        this.tripTeamId = tripTeamId;
        this.teamName = teamName;
    }

    // 연관 관계 편의 메서드
    public void addUserTripTeam(UserTripTeam userTripTeam) {
        userTripTeams.add(userTripTeam);
        userTripTeam.addTripTeam(this);
    }
}
