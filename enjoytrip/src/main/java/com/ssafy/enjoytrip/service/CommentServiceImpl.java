package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.Comment;
import com.ssafy.enjoytrip.exception.CommentException;
import com.ssafy.enjoytrip.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Comment> getAllComment(Long boardId) {
        return commentRepository.getAllCommentByBoardId(boardId);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    @Transactional(readOnly = true)
    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentException("잘못된 접근입니다."));
    }

    @Override
    public void editComment(Long commentId, String content) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentException("잘못된 접근입니다."));
        comment.editComment(content);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentException("잘못된 접근입니다."));
        commentRepository.delete(comment);
    }
}
