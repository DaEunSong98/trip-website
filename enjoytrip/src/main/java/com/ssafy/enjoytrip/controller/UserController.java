package com.ssafy.enjoytrip.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.domain.User;
import com.ssafy.enjoytrip.dto.request.UserLoginDto;
import com.ssafy.enjoytrip.dto.request.UserUpdateDto;
import com.ssafy.enjoytrip.service.UserService;
import com.ssafy.enjoytrip.session.LoginSessionInfo;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	//로그인 
	@PostMapping("/login")
	protected ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto, HttpServletRequest request){

		HttpSession session=request.getSession();
		LoginSessionInfo loginSessionInfo=userService.loginUser(userLoginDto.getLoginId(), userLoginDto.getPassword());
		session.setAttribute("login_member",loginSessionInfo );
		
		return new ResponseEntity<>( HttpStatus.OK); 
	}

	//회원 가입
	@PostMapping("/signup")
	protected ResponseEntity<?> join(@RequestBody User user){
		userService.join(user);
		return new ResponseEntity<>(HttpStatus.OK); 
		
	}
	
	//회원 정보 수정 
	@PatchMapping("/{userId}")
	protected ResponseEntity<?> updateUser(@PathVariable long userId, @RequestBody UserUpdateDto userUpdateDto){
		User user=userUpdateDto.toEntity();
		userService.updateUser(user);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	//회원 상세 정보 조회 
	@GetMapping("/{userId}")
	protected ResponseEntity<?> getUserDetail(@PathVariable long userId){
		
		User user=userService.findUserById(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK); 
	}
	
//	//회원 정보 삭제(?)
//	@DeleteMapping("/{user_id}")
//	protected ResponseEntity<?> deleteUser(@PathVariable long user_id){
//		userService.
//		return new ResponseEntity<>(HttpStatus.OK); 
//	}
	
	//로그 아웃 
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpServletRequest request){
		HttpSession session=request.getSession();
		session.setAttribute("login_member",null);
		session.invalidate();
		return new ResponseEntity<>(HttpStatus.OK); 

	}



}