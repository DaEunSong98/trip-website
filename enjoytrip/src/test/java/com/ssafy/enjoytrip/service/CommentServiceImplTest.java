package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.domain.Comment;
import com.ssafy.enjoytrip.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommentServiceImplTest {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private CommentService commentService;

    private Long boardId = 0L;

    @BeforeEach
    void init() {
        Board board = Board.builder().title("테스트1").content("테스트1").build();
        Comment comment1 = Comment.builder().content("댓글 테스트1").board(board).build();
        Comment comment2 = Comment.builder().content("댓글 테스트2").board(board).build();
        boardRepository.save(board);
        commentService.addComment(comment1);
        commentService.addComment(comment2);
        boardId = board.getBoardId();
    }

    @Test
    void getAllComment() {
        List<Comment> allComment = commentService.getAllComment(boardId);
        Assertions.assertThat(allComment.size()).isEqualTo(2);
    }

    @Test
    void addComment() {
        Comment comment = Comment.builder().content("댓글 테스트1").build();
        commentService.addComment(comment);
        Assertions.assertThat(comment.getCommentId()).isNotNull();
    }
}