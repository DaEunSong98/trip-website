package com.ssafy.enjoytrip.controller;

import java.util.List;

import com.ssafy.enjoytrip.exception.BoardException;
import com.ssafy.enjoytrip.session.LoginSessionInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.dto.request.BoardSearch;
import com.ssafy.enjoytrip.dto.request.BoardUpdateDto;
import com.ssafy.enjoytrip.service.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	//게시글 세부 정보
	@GetMapping("/{boardId}")
	public ResponseEntity<Board> getBoardDetail(@PathVariable("boardId") long boardId) {
		Board board = boardService.getBoardDetail(boardId);
		return new ResponseEntity<>(board, HttpStatus.OK);
	}

	//게시글 목록
	@GetMapping
	public ResponseEntity<List<Board>> getBoardList(BoardSearch boardSearch) {
		List<Board> boardList = boardService.getAllBoards(boardSearch);
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	//게시글 등록
	@PostMapping("/write")
	public ResponseEntity<?> registerBoard(@RequestBody Board board, HttpServletRequest request) {
		HttpSession session = request.getSession(); // TODO: 2023-05-03 여기 세션 정보 없으면 예외 던지게 설계하기 + JWT 추가할 때 다시 구현
		LoginSessionInfo loginMember = (LoginSessionInfo) session.getAttribute("LoginMember");
		boardService.addBoard(board, loginMember.getUserId());
		return new ResponseEntity<>(HttpStatus.OK);

	}

	//게시글 수정
	@PutMapping("/{board_id}")
	protected ResponseEntity<?> modifyBoard(@PathVariable long boardId, @RequestBody BoardUpdateDto boardUpdateDto) {
		boardService.updateBoard(boardUpdateDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//게시글 삭제
	@DeleteMapping("/{board_id}")
	public ResponseEntity<?> deleteBoard(@PathVariable long boardId) {
		boardService.deleteBoard(boardId);
		return ResponseEntity.ok().build();
	}

	// board exception handler
	@ExceptionHandler(BoardException.class)
	public ResponseEntity<String> boardExceptionHandle(BoardException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
