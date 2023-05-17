package com.ssafy.enjoytrip.dto.response;

import com.ssafy.enjoytrip.domain.Board;
import lombok.Data;

@Data
public class BoardResponseDto {

    private Long boardId;
    private String title;
    private String nickname;

    public BoardResponseDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.nickname = board.getUser().getNickname();
    }
}
