package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.domain.BoardImage;
import com.ssafy.enjoytrip.dto.request.BoardSearch;
import com.ssafy.enjoytrip.dto.request.BoardUpdateDto;

import java.util.List;

public interface BoardService {
	
    Board getBoardDetail(Long boardId);

    List<Board> getAllBoards(BoardSearch boardSearch);

    void deleteBoard(Long id, Long userId);

    void addBoard(Board board, Long userId, List<BoardImage> boardImages);

    void updateBoard(BoardUpdateDto boardUpdateDto);
}
