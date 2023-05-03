package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComment(Long boardId);

    void addComment(Comment comment);

    Comment getComment(Long commentId);

    void editComment(Long commentId, String content);

    void deleteComment(Long commentId);
}
