package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.domain.TripPlan;
import com.ssafy.enjoytrip.domain.TripTeam;
import com.ssafy.enjoytrip.domain.UserTripTeam;
import com.ssafy.enjoytrip.dto.request.TripPlanRequestDto;
import com.ssafy.enjoytrip.dto.request.TripTeamAddRequestDto;
import com.ssafy.enjoytrip.dto.request.UserInviteDto;
import com.ssafy.enjoytrip.dto.response.*;
import com.ssafy.enjoytrip.service.TripPlanService;
import com.ssafy.enjoytrip.service.TripTeamService;
import com.ssafy.enjoytrip.token.LoginRequired;
import com.ssafy.enjoytrip.token.LoginTokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.ssafy.enjoytrip.token.LoginTokenConst.USER_INFO;

@Slf4j
@RestController
@RequestMapping("/TripTeam")
@RequiredArgsConstructor
public class TripTeamController {

    private final TripTeamService tripTeamService;

    private final TripPlanService tripPlanService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public String addTripTeam(@RequestBody @Valid TripTeamAddRequestDto tripTeamAddRequestDto, HttpServletRequest request) {

        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);

        tripTeamService.makeTripTeam(user.getUserId(), tripTeamAddRequestDto.getTeamName());

        return "생성이 완료되었습니다";
    }

    @PostMapping("/invite")
    @ResponseStatus(HttpStatus.OK)
    public String inviteUser(@RequestBody @Valid UserInviteDto userInviteDto, HttpServletRequest request) {
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);

        log.info("userInviteDto.getUserId() = {}", userInviteDto.getUserId());
        log.info("userInviteDto.getTeamId() = {}", userInviteDto.getTeamId());

        tripTeamService.inviteUser(user.getUserId(), userInviteDto.getUserId(), userInviteDto.getTeamId());

        return "생성이 완료되었습니다";
    }

    @GetMapping("/{tripTeamId}")
    @ResponseStatus(HttpStatus.OK)
    public TripTeamResponseDto getTripTeamInfo(@PathVariable Long tripTeamId) {
        TripTeam tripTeam = tripTeamService.findTripTeam(tripTeamId);
        return new TripTeamResponseDto(tripTeam);
    }

    @LoginRequired
    @GetMapping("/{tripTeamId}/plans")
    @ResponseStatus(HttpStatus.OK)
    public List<TripPlanListResponseDto> getTripPlansOfTripTeam(@PathVariable Long tripTeamId) {
        return tripPlanService.getTripPlansByTripTeamId(tripTeamId)
                .stream().map(TripPlanListResponseDto::new).collect(Collectors.toList());
    }


    @LoginRequired
    @GetMapping("/{tripTeamId}/invite/{userTripTeamId}")
    @ResponseStatus(HttpStatus.OK)
    public UserTripTeamForm getUserTripTeamForm(@PathVariable Long tripTeamId, @PathVariable Long userTripTeamId) {
        UserTripTeam userTripTeam = tripTeamService.getUserTripTeam(userTripTeamId);
        return new UserTripTeamForm(userTripTeam);
    }

    @PostMapping("/{tripTeamId}/invite/{userTripTeamId}/accept")
    @ResponseStatus(HttpStatus.OK)
    public String acceptInvite(@PathVariable Long tripTeamId, @PathVariable Long userTripTeamId, HttpServletRequest request) {
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);
        tripTeamService.acceptInvite(userTripTeamId, user.getUserId(), tripTeamId);
        return "초대를 수락했습니다";
    }

    @PostMapping("/{tripTeamId}/invite/{userTripTeamId}/refuse")
    @ResponseStatus(HttpStatus.OK)
    public String refuseInvite(@PathVariable Long tripTeamId, @PathVariable Long userTripTeamId, HttpServletRequest request) {
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);
        tripTeamService.refuseInvite(userTripTeamId, user.getUserId(), tripTeamId);
        return "초대를 거절했습니다";
    }

    @DeleteMapping("/{tripTeamId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteTeam(@PathVariable Long tripTeamId, HttpServletRequest request) {
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);
        tripTeamService.deleteTripTeam(tripTeamId, user.getUserId());
        return "팀 해체가 완료되었습니다.";
    }

    @PostMapping("/{tripTeamId}/addTripPlan")
    @ResponseStatus(HttpStatus.OK)
    public String addTripPlan(@PathVariable Long tripTeamId, @RequestBody TripPlanRequestDto tripPlanRequestDto, HttpServletRequest request) {
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);
        log.info("tripPlanRequestDto.getStartDate() = {}", tripPlanRequestDto.getStartDate());
        tripPlanService.makeTripPlan(
                user.getUserId(), tripTeamId, tripPlanRequestDto.getPlanName(), tripPlanRequestDto.getPlanContent(), tripPlanRequestDto.getStartDate(), tripPlanRequestDto.getEndDate());
        return "계획 생성이 완료되었습니다.";
    }

    @PostMapping("/{tripTeamId}/{tripPlanId}/addAttraction")
    @ResponseStatus(HttpStatus.OK)
    public void addAttraction(
            @PathVariable Long tripTeamId,
            @PathVariable Long tripPlanId,
            @RequestBody List<AttractionListResponseDto> attractionInfo,
            HttpServletRequest request
    ) {
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);
        List<Integer> attractionIdList = attractionInfo.stream().map(AttractionListResponseDto::getContentId).collect(Collectors.toList());
        tripPlanService.addPlanAttractions(user.getUserId(), tripTeamId, tripPlanId, attractionIdList);
    }

    @LoginRequired
    @GetMapping("/{tripTeamId}/{tripPlanId}")
    @ResponseStatus(HttpStatus.OK)
    public TripPlanResponseDto getTripPlan(@PathVariable Long tripTeamId,
                                           @PathVariable Long tripPlanId,
                                           HttpServletRequest request) {
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);
        TripPlan tripPlan = tripPlanService.getTripPlan(tripPlanId, tripTeamId, user.getUserId());
        return new TripPlanResponseDto(tripPlan);
    }

    @DeleteMapping("/{tripTeamId}/{tripPlanId}/{planAttractionId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAttraction(@PathVariable Long planAttractionId, @PathVariable Long tripTeamId, HttpServletRequest request) {
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);
        tripPlanService.deletePlanAttraction(user.getUserId(), planAttractionId, tripTeamId);
    }

    @DeleteMapping("/{tripTeamId}/{tripPlanId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTripPlan(@PathVariable Long tripTeamId, @PathVariable Long tripPlanId, HttpServletRequest request) {
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);
        tripPlanService.deleteTripPlan(user.getUserId(), tripPlanId, tripTeamId);
    }

    @GetMapping("/{tripTeamId}/user/leader")
    @ResponseStatus(HttpStatus.OK)
    @LoginRequired
    public boolean validLeader(@PathVariable Long tripTeamId, HttpServletRequest request) {
        log.info("validLeader");
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);
        return tripTeamService.validUserIsLeader(user.getUserId(), tripTeamId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @LoginRequired
    public List<TripTeamListResponse> getAllTripTeam(HttpServletRequest request) {
        LoginTokenInfo user = (LoginTokenInfo) request.getAttribute(USER_INFO);
        return tripTeamService.getAllTripTeamByUserId(user.getUserId())
                .stream().map(TripTeamListResponse::new).collect(Collectors.toList());
    }
}
