package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.dto.request.BoardSearch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {
	
	//게시글 세부 정보 
	@GetMapping("/{board_id}")
	protected ResponseEntity<?> getBoardDetail(@PathVariable long board_id) throws Exception {
	
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	//게시글 목록
	@GetMapping
	protected ResponseEntity<?> getBoardList() throws Exception {
		
		return new ResponseEntity<>(HttpStatus.OK); 
	
	}

	//게시글 등록
	@PostMapping("/write")
	protected ResponseEntity<?> registBoard(@RequestBody Board board) throws Exception {
	
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	//게시글 수정 
	@PutMapping("/{board_id}")
	protected ResponseEntity<?> modifyBoard(@PathVariable long board_id, @RequestBody Board board) throws Exception {

		return new ResponseEntity<>(HttpStatus.OK); 

	}
	
	//게시글 삭제
	@DeleteMapping("/{board_id}")
	protected ResponseEntity<?> deleteBoard(@PathVariable long board_id) throws Exception {
		return new ResponseEntity<>(HttpStatus.OK); 
	}

	//게시글 검색 내용 조회 
	protected ResponseEntity<?> search(@RequestBody BoardSearch boardSearch){
		
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	
}
