package com.ssafy.enjoytrip.dto.response;

import com.ssafy.enjoytrip.domain.Comment;
import lombok.Data;

@Data
public class CommentResponseDto {

    private String content;

    private String nickname;

    public CommentResponseDto(Comment comment) {
        this.content = comment.getContent();
        this.nickname = comment.getUser().getNickname();
    }
}
