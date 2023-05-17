package com.ssafy.enjoytrip.dto.response;

import com.ssafy.enjoytrip.domain.Comment;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponseDto {

    private String content;

    private String nickname;

    private LocalDateTime createdDate;

    public CommentResponseDto(Comment comment) {
        this.content = comment.getContent();
        this.nickname = comment.getUser().getNickname();
        this.createdDate = comment.getCreatedDate();
    }
}
