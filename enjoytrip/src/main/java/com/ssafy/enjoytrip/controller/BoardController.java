package com.ssafy.enjoytrip.controller;

import java.util.List;

import com.ssafy.enjoytrip.session.LoginSessionInfo;
import lombok.RequiredArgsConstructor;
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
	protected ResponseEntity<?> getBoardDetail(@PathVariable("boardId") long boardId) throws Exception {
		Board board=boardService.getBoardDetail(boardId);
		return new ResponseEntity<Board>(board,HttpStatus.OK);
	}

	//게시글 목록
	@GetMapping
	protected ResponseEntity<?> getBoardList(BoardSearch boardSearch) throws Exception {
		System.out.println(boardSearch.getSize()+" "+boardSearch.getOffset());
		List<Board> boardList=boardService.getAllBoards(boardSearch);
		return new ResponseEntity<List<Board>>(boardList, HttpStatus.OK);

	}

	//게시글 등록
	@PostMapping("/write")
	protected ResponseEntity<?> registBoard(@RequestBody Board board, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		LoginSessionInfo loginMember = (LoginSessionInfo) session.getAttribute("LoginMember");
		try{
			boardService.addBoard(board, loginMember.getUserId());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}


	}

	//게시글 수정
	@PutMapping("/{board_id}")
	protected ResponseEntity<?> modifyBoard(@PathVariable long boardId, @RequestBody BoardUpdateDto boardUpdateDto) throws Exception {

		try{
			boardService.updateBoard(boardUpdateDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	//게시글 삭제
	@DeleteMapping("/{board_id}")
	protected ResponseEntity<?> deleteBoard(@PathVariable long boardId) throws Exception {


		try{
			boardService.deleteBoard(boardId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}


}
