package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.*;
import com.ssafy.enjoytrip.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TripPlanServiceImpl implements TripPlanService{

    private final UserRepository userRepository;
    private final TripTeamRepository tripTeamRepository;
    private final AttractionInfoRepository attractionInfoRepository;
    private final TripPlanRepository tripPlanRepository;



    @Override
    public void makeTripPlan(Long userId, Long tripTeamId, String planName, String planContent) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자"));

        TripTeam tripTeam=tripTeamRepository.findById(tripTeamId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 팀"));

        //권한

        TripPlan tripPlan=TripPlan.builder().planContent(planContent).planName(planName).tripTeam(tripTeam).build();
        tripPlanRepository.save(tripPlan);
    }

    @Override
    public void addPlanAttractions(Long tripPlanId, List<Integer> attractionIdList) {


        TripPlan tripPlan=tripPlanRepository.findById(tripPlanId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 팀"));

        //권한

        for(Integer attractionId: attractionIdList){
            AttractionInfo attractionInfo=attractionInfoRepository.findById(attractionId)
                    .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 관광지"));
            PlanAttraction planAttraction=PlanAttraction.builder().attractionInfo(attractionInfo).tripPlan(tripPlan).build();
            tripPlan.addPlanAttraction(planAttraction);
        }
    }

    @Override
    public void deleteTripPlan(Long userId, Long tripPlanId) {
        tripPlanRepository.deleteById(tripPlanId);
    }

    @Override
    public TripPlan getTripPlan(Long tripPlanId) {
        return tripPlanRepository.findById(tripPlanId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 여향 계획"));
    }

    @Override
    public List<PlanAttraction> getPlanAttractions(Long tripPlanId) {

        return null;
    }


}
