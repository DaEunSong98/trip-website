package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.*;
import com.ssafy.enjoytrip.domain.team_relation.TeamRole;
import com.ssafy.enjoytrip.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TripPlanServiceImpl implements TripPlanService{

    private final UserRepository userRepository;
    private final TripTeamRepository tripTeamRepository;
    private final AttractionInfoRepository attractionInfoRepository;
    private final TripPlanRepository tripPlanRepository;
    private final UserTripTeamRepository userTripTeamRepository;


    @Override
    public void makeTripPlan(Long userId, Long tripTeamId, String planName, String planContent) {

        UserTripTeam userTripTeam = getUserTripTeam(userId, tripTeamId);

        TripPlan tripPlan = TripPlan.builder().planContent(planContent).planName(planName).tripTeam(userTripTeam.getTripTeam()).build();
        tripPlanRepository.save(tripPlan);
    }

    @Override
    public void addPlanAttractions(Long userId, Long tripTeamId, Long tripPlanId, List<Integer> attractionIdList) {

        UserTripTeam userTripTeam = getUserTripTeam(userId, tripTeamId);

        TripPlan tripPlan = tripPlanRepository.findTripPlanByIdJoinTripTeam(tripPlanId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 팀"));

        if (tripPlan.getTripTeam() != userTripTeam.getTripTeam()) {
            throw new IllegalArgumentException("해당 팀의 계획이 아닙니다");
        }

        for(Integer attractionId: attractionIdList){
            AttractionInfo attractionInfo = attractionInfoRepository.findById(attractionId)
                    .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 관광지"));
            PlanAttraction planAttraction = PlanAttraction.builder().attractionInfo(attractionInfo).build();
            tripPlan.addPlanAttraction(planAttraction);
        }
    }

    @Override
    public void deleteTripPlan(Long userId, Long tripPlanId) {
        tripPlanRepository.deleteById(tripPlanId);
    }

    @Override
    public TripPlan getTripPlan(Long tripPlanId) {
        return tripPlanRepository.findTripPlanByIdJoinTripTeam(tripPlanId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 계획"));
    }

    @Override
    public List<PlanAttraction> getPlanAttractions(Long tripPlanId) {
        return tripPlanRepository.findTripPlanByIdJoinPlanAttraction(tripPlanId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 계획"))
                .getPlanAttractions();
    }

    private UserTripTeam getUserTripTeam(Long userId, Long tripTeamId) {
        UserTripTeam userTripTeam = userTripTeamRepository.getUserTripTeamByUserIdAndTeamId(userId, tripTeamId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 입력"));

        // 유저 권한 체크
        if (userTripTeam.getTeamRole() != TeamRole.LEADER) {
            throw new IllegalArgumentException("유효하지 않은 입력");
        }
        return userTripTeam;
    }

}
