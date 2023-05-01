package com.ssafy.enjoytrip.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/attraction")
public class AttractionController{
	
	//목록 조회
	@GetMapping("/search")
	protected ResponseEntity<?> getAttractionList() {
		
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	

	

}
