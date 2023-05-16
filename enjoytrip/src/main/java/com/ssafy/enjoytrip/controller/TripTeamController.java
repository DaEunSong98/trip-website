package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.domain.TripTeam;
import com.ssafy.enjoytrip.domain.UserTripTeam;
import com.ssafy.enjoytrip.dto.request.TripPlanRequestDto;
import com.ssafy.enjoytrip.dto.request.UserInviteDto;
import com.ssafy.enjoytrip.dto.response.TripTeamResponseDto;
import com.ssafy.enjoytrip.dto.response.UserTripTeamForm;
import com.ssafy.enjoytrip.repository.PlanAttractionRepository;
import com.ssafy.enjoytrip.service.TripPlanService;
import com.ssafy.enjoytrip.service.TripTeamService;
import com.ssafy.enjoytrip.session.LoginSessionInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/TripTeam")
@RequiredArgsConstructor
public class TripTeamController {

    private final TripTeamService tripTeamService;

    private final TripPlanService tripPlanService;

    private final PlanAttractionRepository planAttractionRepository;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String addTripTeam(@RequestBody String teamName, HttpServletRequest request) {

        // TODO: 2023-05-16 : 토큰 기반 유저 가져오기
        LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");

        if (!StringUtils.hasText(teamName)) {
            throw new IllegalArgumentException("이름을 입력해주세요");
        }

        tripTeamService.makeTripTeam(user.getUserId(), teamName);

        return "생성이 완료되었습니다";
    }

    @PostMapping("/invite")
    @ResponseStatus(HttpStatus.OK)
    public String inviteUser(@RequestBody @Valid UserInviteDto userInviteDto, HttpServletRequest request) {
        // TODO: 2023-05-16 : 토큰 기반 유저 가져오기
        LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");

        tripTeamService.inviteUser(user.getUserId(), userInviteDto.getUserId(), userInviteDto.getTeamId());

        return "생성이 완료되었습니다";
    }

    @GetMapping("/{tripTeamId}")
    @ResponseStatus(HttpStatus.OK)
    public TripTeamResponseDto getTripTeamInfo(@PathVariable Long tripTeamId) {
        TripTeam tripTeam = tripTeamService.findTripTeam(tripTeamId);
        return new TripTeamResponseDto(tripTeam);
    }

    @GetMapping("/{tripTeamId}/{userTripTeamId}")
    @ResponseStatus(HttpStatus.OK)
    public UserTripTeamForm getUserTripTeamForm(@PathVariable Long tripTeamId, @PathVariable Long userTripTeamId) {
        UserTripTeam userTripTeam = tripTeamService.getUserTripTeam(userTripTeamId);
        return new UserTripTeamForm(userTripTeam);
    }

    @PostMapping("/{tripTeamId}/{userTripTeamId}/accept")
    @ResponseStatus(HttpStatus.OK)
    public String acceptInvite(@PathVariable Long tripTeamId, @PathVariable Long userTripTeamId, HttpServletRequest request) {
        // TODO: 2023-05-16 : 토큰 기반 유저 가져오기
        LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");
        tripTeamService.acceptInvite(userTripTeamId, user.getUserId(), tripTeamId);
        return "초대를 수락했습니다";
    }

    @PostMapping("/{tripTeamId}/{userTripTeamId}/refuse")
    @ResponseStatus(HttpStatus.OK)
    public String refuseInvite(@PathVariable Long tripTeamId, @PathVariable Long userTripTeamId, HttpServletRequest request) {
        // TODO: 2023-05-16 : 토큰 기반 유저 가져오기
        LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");
        tripTeamService.refuseInvite(userTripTeamId, user.getUserId(), tripTeamId);
        return "초대를 거절했습니다";
    }

    @DeleteMapping("/{tripTeamId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTeam(@PathVariable Long tripTeamId, HttpServletRequest request) {
        LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");
        tripTeamService.deleteTripTeam(tripTeamId, user.getUserId());
        return "팀 해체가 완료되었습니다.";
    }

    @PostMapping("/{tripTeamId}/addTripPlan")
    @ResponseStatus(HttpStatus.OK)
    public String addTripPlan(@PathVariable Long tripTeamId, @RequestBody TripPlanRequestDto tripPlanRequestDto, HttpServletRequest request) {
        LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");
        tripPlanService.makeTripPlan(user.getUserId(), tripTeamId, tripPlanRequestDto.getPlanName(), tripPlanRequestDto.getPlanContent());
        return "계획 생성이 완료되었습니다.";
    }

    @PostMapping("/{tripTeamId}/{tripPlanId}/addAttraction")
    @ResponseStatus(HttpStatus.OK)
    public void addAttraction(
            @PathVariable Long tripTeamId,
            @PathVariable Long tripPlanId,
            @RequestBody List<Integer> attractionInfo,
            HttpServletRequest request
    ) {
        LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");
        tripPlanService.addPlanAttractions(user.getUserId(), tripTeamId, tripPlanId, attractionInfo);
    }

    @DeleteMapping("/{tripTeamId}/{tripPlanId}/{planAttractionId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAttraction(@PathVariable Long planAttractionId) {
        planAttractionRepository.deleteById(planAttractionId);
    }
}
