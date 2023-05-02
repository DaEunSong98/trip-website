package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.dto.request.BoardSearch;
import com.ssafy.enjoytrip.dto.request.BoardUpdateDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardService {
    Board getBoardDetail(Long boardId);

    List<Board> getAllBoards(BoardSearch boardSearch);

    void deleteBoard(Long id);

    void addBoard(Board board);

    void updateBoard(BoardUpdateDto boardUpdateDto);
}
