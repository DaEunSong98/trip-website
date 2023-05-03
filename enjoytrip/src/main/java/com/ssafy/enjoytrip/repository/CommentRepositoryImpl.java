package com.ssafy.enjoytrip.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.enjoytrip.domain.Comment;
import com.ssafy.enjoytrip.domain.QBoard;
import com.ssafy.enjoytrip.domain.QComment;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ssafy.enjoytrip.domain.QBoard.*;
import static com.ssafy.enjoytrip.domain.QComment.*;

public class CommentRepositoryImpl implements CommentRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public CommentRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Comment> getAllCommentByBoardId(Long boardId) {
        return queryFactory
                .selectFrom(comment)
                .innerJoin(comment.board, board).fetchJoin()
                .where(board.boardId.eq(boardId))
                .orderBy(comment.createdDate.desc())
                .fetch();
    }

}
