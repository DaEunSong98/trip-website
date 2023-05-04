package com.ssafy.enjoytrip.controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.domain.Comment;
import com.ssafy.enjoytrip.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	//댓글 목록 
	@GetMapping("/{boardId}/comments")
	protected ResponseEntity<?> getComments(@PathVariable long boardId) throws Exception {

		List<Comment> commentList=commentService.getAllComment(boardId);
		return new ResponseEntity<List<Comment>>(commentList, HttpStatus.OK);

	}

	//댓글 등록
	@PostMapping("{boardId}/comments/write")
	protected ResponseEntity<?> registComment(@PathVariable long boardId,@RequestBody Comment comment) throws Exception {
		Long userId = 1L; // TODO: 2023-05-04 유저 id JWT 토큰에서 가져오기
		commentService.addComment(comment.getContent(), boardId, userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	//댓글 수정 
	@PatchMapping("{boardId}/comments/{commentId}")
	protected ResponseEntity<?> modifyComment(@PathVariable long boardId, @PathVariable long commentId, @RequestBody Comment comment) throws Exception {

		commentService.editComment(commentId, comment.getContent());
		return new ResponseEntity<List<Book>>(HttpStatus.OK);

	}

	//댓글 삭제 
	@DeleteMapping("{boardId}/comments/{commentId}")
	protected ResponseEntity<?> deleteComment(@PathVariable long boardId, @PathVariable long commentId) throws Exception {

		commentService.deleteComment(commentId);
		return new ResponseEntity<List<Book>>(HttpStatus.OK);
	}

}
