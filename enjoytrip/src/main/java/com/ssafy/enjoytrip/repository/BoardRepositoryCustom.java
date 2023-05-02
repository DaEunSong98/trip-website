package com.ssafy.enjoytrip.repository;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.dto.request.BoardSearch;

import java.util.List;
import java.util.Optional;

public interface BoardRepositoryCustom {

    List<Board> searchAllBoard(BoardSearch boardSearch);

    Optional<Board> findBoardByBoardId(Long boardId);
}
