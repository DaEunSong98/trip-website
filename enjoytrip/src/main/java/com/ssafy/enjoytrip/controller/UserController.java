package com.ssafy.enjoytrip.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.ssafy.enjoytrip.domain.UserRelationship;
import com.ssafy.enjoytrip.domain.UserTripTeam;
import com.ssafy.enjoytrip.domain.user_relation.Relation;
import com.ssafy.enjoytrip.dto.request.UserJoinDto;
import com.ssafy.enjoytrip.dto.request.UserSearch;
import com.ssafy.enjoytrip.dto.response.RelationshipResponseDto;
import com.ssafy.enjoytrip.dto.response.UserResponseDto;
import com.ssafy.enjoytrip.dto.response.UserTripTeamForm;
import com.ssafy.enjoytrip.service.TripTeamService;
import com.ssafy.enjoytrip.service.UserRelationshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.enjoytrip.domain.User;
import com.ssafy.enjoytrip.dto.request.UserLoginDto;
import com.ssafy.enjoytrip.dto.request.UserUpdateDto;
import com.ssafy.enjoytrip.service.UserService;
import com.ssafy.enjoytrip.session.LoginSessionConst;
import com.ssafy.enjoytrip.session.LoginSessionInfo;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	private final TripTeamService tripTeamService;

	private final UserRelationshipService userRelationshipService;

	//로그인
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto, HttpServletRequest request) {

		HttpSession session = request.getSession();
		LoginSessionInfo loginSessionInfo = userService.loginUser(userLoginDto.getLoginId(), userLoginDto.getPassword());
		session.setAttribute(LoginSessionConst.LOGIN_SESSION, loginSessionInfo);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	//회원 가입
	@PostMapping("/signup")
	public ResponseEntity<?> join(@RequestBody @Valid UserJoinDto userJoinDto) {
		User user = User.builder()
				.name(userJoinDto.getName())
				.nickname(userJoinDto.getNickname())
				.loginId(userJoinDto.getLoginId())
				.mail(userJoinDto.getMail())
				.password(userJoinDto.getPassword())
				.phoneNumber(userJoinDto.getPhoneNumber())
				.build();
		userService.join(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//회원 정보 수정
	@PatchMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable long userId, @RequestBody @Valid UserUpdateDto userUpdateDto) {
		User user = userUpdateDto.toEntity();
		userService.updateUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//회원 상세 정보 조회
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserDetail(@PathVariable long userId) {
		User user = userService.findUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/list")
	@ResponseStatus(HttpStatus.OK)
	public List<UserResponseDto> getAllUser(@Valid UserSearch userSearch) {
		List<User> allUser = userService.findAllUser(userSearch);
		return allUser.stream().map(UserResponseDto::new).collect(Collectors.toList());
	}

	//회원 정보 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteUser(HttpServletRequest request) {
		// TODO: 2023-05-03 로그인 JWT 토큰 기반으로 변경 시 리팩토링 하기
		HttpSession session = request.getSession();
		LoginSessionInfo loginSession = (LoginSessionInfo) session.getAttribute(LoginSessionConst.LOGIN_SESSION);
		userService.deleteUser(loginSession.getUserId());
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//로그 아웃
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/invite")
	@ResponseStatus(HttpStatus.OK)
	public List<UserTripTeamForm> allInviteInfo(HttpServletRequest request) {
		LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");
		List<UserTripTeam> allUserTripTeam = tripTeamService.getAllUserTripTeam(user.getUserId());
		return allUserTripTeam.stream().map(UserTripTeamForm::new).collect(Collectors.toList());
	}

	@GetMapping("/relationship/{relation}")
	@ResponseStatus(HttpStatus.OK)
	public List<RelationshipResponseDto> getAllRelation(@PathVariable Relation relation, HttpServletRequest request) {
		LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");
		List<UserRelationship> findRelation = userRelationshipService.getAllUserByRelation(user.getUserId(), relation);
		return findRelation.stream().map(RelationshipResponseDto::new).collect(Collectors.toList());
	}

	@PostMapping("/relationship/{targetId}")
	@ResponseStatus(HttpStatus.OK)
	public String addRelationship(@PathVariable Long targetId, @RequestBody Relation relation, HttpServletRequest request) {
		LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");
		userRelationshipService.makeRelationship(user.getUserId(), targetId, relation);
		return "요청 완료";
	}

	@DeleteMapping("/relationship/{targetId}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteRelationship(@PathVariable Long targetId, HttpServletRequest request) {
		LoginSessionInfo user = (LoginSessionInfo) request.getAttribute("user");
		long count = userRelationshipService.deleteRelationship(user.getUserId(), targetId);
		if (count == 0) {
			throw new IllegalArgumentException("잘못된 요청입니다.");
		}
		return "요청 완료";
	}
}