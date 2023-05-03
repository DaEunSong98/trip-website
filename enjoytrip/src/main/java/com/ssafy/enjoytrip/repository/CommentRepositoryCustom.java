package com.ssafy.enjoytrip.repository;

import com.ssafy.enjoytrip.domain.Comment;

import java.util.List;

public interface CommentRepositoryCustom {

    List<Comment> getAllCommentByBoardId(Long boardId);

}
