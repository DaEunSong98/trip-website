package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.dto.request.BoardSearch;
import com.ssafy.enjoytrip.dto.request.BoardUpdateDto;
import com.ssafy.enjoytrip.exception.BoardException;
import com.ssafy.enjoytrip.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional(readOnly = true)
    public Board getBoardDetail(Long boardId) {
        return boardRepository.findBoardByBoardId(boardId)
                .orElseThrow(() -> new BoardException("잘못된 접근입니다."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> getAllBoards(BoardSearch boardSearch) {
        return boardRepository.searchAllBoard(boardSearch);
    }

    @Override
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    public void addBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void updateBoard(BoardUpdateDto boardUpdateDto) {
        Board findBoard = boardRepository.findById(boardUpdateDto.getBoardId())
                .orElseThrow(() -> new BoardException("잘못된 접근입니다."));
        findBoard.updateBoard(boardUpdateDto.getContent());
    }
}
