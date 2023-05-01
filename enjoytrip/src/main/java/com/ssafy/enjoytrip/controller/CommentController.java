package com.ssafy.enjoytrip.controller;

import java.awt.print.Book;
import java.util.List;

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

import com.ssafy.enjoytrip.dto.Board;
import com.ssafy.enjoytrip.dto.Comment;

@RestController
@RequestMapping("/articles")
public class CommentController {

	
		
		//댓글 목록 
		@GetMapping("/{board_id}/comments")
		protected ResponseEntity<?> getComments(@PathVariable long board_id) throws Exception {
			
			return new ResponseEntity<List<Book>>(HttpStatus.OK); 
		
		}

		//댓글 등록
		@PostMapping("{board_id}/comments/write")
		protected ResponseEntity<?> registComment(@PathVariable long board_id,@RequestBody Board board) throws Exception {
		
			return new ResponseEntity<List<Book>>(HttpStatus.OK); 
		}
		
		
		//댓글 수정 
		@PutMapping("{board_id}/comments/{comment_id}")
		protected ResponseEntity<?> modifyBook(@PathVariable long board_id, @PathVariable long comment_id, @RequestBody Comment comment) throws Exception {

			return new ResponseEntity<List<Book>>(HttpStatus.OK); 

		}
		
		//댓글 삭제 
		@DeleteMapping("{board_id}/comments/{comment_id}")
		protected ResponseEntity<?> deleteComment(@PathVariable long board_id, @PathVariable long comment_id) throws Exception {
			return new ResponseEntity<List<Book>>(HttpStatus.OK); 
		}
		
}
