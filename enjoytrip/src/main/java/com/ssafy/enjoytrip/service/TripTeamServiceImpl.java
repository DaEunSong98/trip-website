package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.TripTeam;
import com.ssafy.enjoytrip.domain.User;
import com.ssafy.enjoytrip.domain.UserTripTeam;
import com.ssafy.enjoytrip.repository.TripTeamRepository;
import com.ssafy.enjoytrip.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TripTeamServiceImpl implements TripTeamService {

    private final TripTeamRepository tripTeamRepository;

    private final UserRepository userRepository;

    @Override
    public void makeTripTeam(Long userId, String teamName) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자"));
        TripTeam tripTeam = TripTeam.builder().teamName(teamName).master(findUser).build();
        tripTeamRepository.save(tripTeam);
    }

    @Override
    public TripTeam findTripTeam(Long tripTeamId) {
        return tripTeamRepository.findById(tripTeamId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 팀"));
    }

    @Override
    public void addTeamMember(Long userId, Long teamId) {
        TripTeam tripTeam = tripTeamRepository.findById(teamId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 팀"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 사용자"));

        UserTripTeam userTripTeam = UserTripTeam.builder().tripTeam(tripTeam).user(user).build();

        tripTeam.addUserTripTeam(userTripTeam);
    }
}
