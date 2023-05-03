package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment(Long boardId);

    void addComment(Comment comment);
}
