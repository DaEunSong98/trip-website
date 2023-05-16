package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.domain.BoardImage;
import com.ssafy.enjoytrip.domain.User;
import com.ssafy.enjoytrip.dto.request.BoardSearch;
import com.ssafy.enjoytrip.dto.request.BoardUpdateDto;
import com.ssafy.enjoytrip.exception.NotFoundException;
import com.ssafy.enjoytrip.repository.BoardRepository;
import com.ssafy.enjoytrip.repository.UserRepository;
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

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Board getBoardDetail(Long boardId) {
        return boardRepository.findBoardByBoardId(boardId)
                .orElseThrow(() -> new NotFoundException("잘못된 접근입니다."));
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
    public void addBoard(Board board, Long userId, List<BoardImage> boardImages) {
        User findUser = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("잘못된 접근입니다."));

        board.setUser(findUser);
        for (BoardImage boardImage : boardImages) {
            board.addImage(boardImage);
        }

        boardRepository.save(board);
    }

    @Override
    public void updateBoard(BoardUpdateDto boardUpdateDto) {
        Board findBoard = boardRepository.findById(boardUpdateDto.getBoardId())
                .orElseThrow(() -> new NotFoundException("잘못된 접근입니다."));
        findBoard.updateBoard(boardUpdateDto.getContent());
    }
}
