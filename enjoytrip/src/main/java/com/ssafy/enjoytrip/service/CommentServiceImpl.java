package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.Comment;
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
}
