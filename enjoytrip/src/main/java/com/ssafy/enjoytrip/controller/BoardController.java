package com.ssafy.enjoytrip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.ssafy.enjoytrip.domain.BoardImage;
import com.ssafy.enjoytrip.image_util.FileStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.dto.request.BoardSearch;
import com.ssafy.enjoytrip.dto.request.BoardUpdateDto;
import com.ssafy.enjoytrip.service.BoardService;
import com.ssafy.enjoytrip.session.LoginSessionInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	private final FileStore fileStore;

	//게시글 세부 정보
	@GetMapping("/{boardId}")
	public ResponseEntity<Board> getBoardDetail(@PathVariable("boardId") long boardId) {
		Board board = boardService.getBoardDetail(boardId);
		return new ResponseEntity<>(board, HttpStatus.OK);
	}

	//게시글 목록
	@GetMapping
	public ResponseEntity<List<Board>> getBoardList(@Valid BoardSearch boardSearch) {
		List<Board> boardList = boardService.getAllBoards(boardSearch);
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	//게시글 등록
	@PostMapping("/write")
	public ResponseEntity<?> registerBoard(@RequestBody Board board, @RequestParam(value = "images", required = false) List<MultipartFile> images, HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession(); // TODO: 2023-05-03 여기 세션 정보 없으면 예외 던지게 설계하기 + JWT 추가할 때 다시 구현
		LoginSessionInfo loginMember = (LoginSessionInfo) session.getAttribute("LoginMember");
		List<BoardImage> boardImages = fileStore.storeImages(images);

		boardService.addBoard(board, loginMember.getUserId(), boardImages);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	//게시글 수정
	@PatchMapping("/{boardId}")
	protected ResponseEntity<?> modifyBoard(@PathVariable long boardId, @RequestBody @Valid BoardUpdateDto boardUpdateDto, HttpServletRequest request) {
		LoginSessionInfo user = (LoginSessionInfo)request.getAttribute("user");
		Board board = boardService.getBoardDetail(boardId);
		if (!board.getUser().getUserId().equals(user.getUserId())) {
			throw new IllegalArgumentException("잘못된 접근입니다.");
		}
		boardService.updateBoard(boardUpdateDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	//게시글 삭제
	@DeleteMapping("/{boardId}")
	public ResponseEntity<?> deleteBoard(@PathVariable long boardId) {
		boardService.deleteBoard(boardId);
		return ResponseEntity.ok().build();
	}

}
