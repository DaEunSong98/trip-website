package com.ssafy.enjoytrip.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.domain.User;



@RestController
@RequestMapping("/user")
public class UserController {

	//로그인
	@GetMapping("/login")
	protected ResponseEntity<?> login(@RequestParam("login_id") long login_id,@RequestParam("password") String password ){
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	//회원 가입 
	@PostMapping("/signup")
	protected ResponseEntity<?> join(@RequestBody User user){
		return new ResponseEntity<>(HttpStatus.OK); 
		
	}
	
	//회원 정보 수정 
	@PutMapping("/{user_id}")
	protected ResponseEntity<?> updateUser(@PathVariable long user_id, @RequestBody User user){
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	//회원 상세 정보 조회 
	@GetMapping("/{user_id}")
	protected ResponseEntity<?> getUserDetail(@PathVariable long user_id){
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	//회원 정보 삭제(?)
	@DeleteMapping("/{user_id}")
	protected ResponseEntity<?> deleteUser(@PathVariable long user_id){
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	//로그 아웃 
	@PostMapping("/logout")
	public ResponseEntity<?> logout(){
		return new ResponseEntity<>(HttpStatus.OK); 
	}

		
}