package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.domain.User;
import com.ssafy.enjoytrip.dto.request.BoardSearch;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceImplTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private EntityManager em;

    private Long boardId;
    private Long userId;

    @BeforeEach
    void addBoard() {
        User user1 = User.builder().loginId("test1").build();
        User user2 = User.builder().loginId("test2").build();
        em.persist(user1);
        em.persist(user2);
        Board board1 = Board.builder().title("게시판1").content("내용1").user(user1).build();
        Board board2 = Board.builder().title("게시판2").content("내용2").user(user2).build();
        em.persist(board1);
        em.persist(board2);
        boardId = board1.getBoardId();
        userId = user1.getUserId();
    }

    @Test
    @Transactional
    void getBoardDetail() {
        Board board = boardService.getBoardDetail(boardId);
        Assertions.assertThat(board.getUser().getUserId()).isEqualTo(userId);
    }

    @Test
    void getAllBoards() {
        List<Board> allBoards = boardService.getAllBoards(BoardSearch.builder().build());
        System.out.println(allBoards.size());
    }
}