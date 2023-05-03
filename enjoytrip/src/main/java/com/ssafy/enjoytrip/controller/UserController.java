package com.ssafy.enjoytrip.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ssafy.enjoytrip.session.LoginSessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.enjoytrip.domain.User;
import com.ssafy.enjoytrip.dto.request.UserLoginDto;
import com.ssafy.enjoytrip.dto.request.UserUpdateDto;
import com.ssafy.enjoytrip.service.UserService;
import com.ssafy.enjoytrip.session.LoginSessionInfo;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	//로그인
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto, HttpServletRequest request){

		HttpSession session = request.getSession();
		LoginSessionInfo loginSessionInfo = userService.loginUser(userLoginDto.getLoginId(), userLoginDto.getPassword());
		session.setAttribute(LoginSessionConst.LOGIN_SESSION, loginSessionInfo );

		return new ResponseEntity<>(HttpStatus.OK);
	}

	//회원 가입
	@PostMapping("/signup")
	public ResponseEntity<?> join(@RequestBody User user){
		userService.join(user);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	//회원 정보 수정
	@PatchMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable long userId, @RequestBody UserUpdateDto userUpdateDto){
		User user = userUpdateDto.toEntity();
		userService.updateUser(user);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//회원 상세 정보 조회
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserDetail(@PathVariable long userId){
		User user = userService.findUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	//회원 정보 삭제
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteUser(HttpServletRequest request){
		// TODO: 2023-05-03 로그인 JWT 토큰 기반으로 변경 시 리팩토링 하기
		HttpSession session = request.getSession();
		LoginSessionInfo loginSession = (LoginSessionInfo) session.getAttribute(LoginSessionConst.LOGIN_SESSION);
		userService.deleteUser(loginSession.getUserId());
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//로그 아웃
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK);
	}

}