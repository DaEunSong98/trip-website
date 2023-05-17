package com.ssafy.enjoytrip.dto.response;

import com.ssafy.enjoytrip.domain.Board;
import com.ssafy.enjoytrip.domain.BoardImage;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardDetailResponseDto {
    private Long boardId;
    private String title;
    private String content;
    private String nickname;
    private List<BoardImage> imageList;
    private LocalDateTime createdDate;

    public BoardDetailResponseDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.nickname = board.getUser().getNickname();
        this.imageList = board.getBoardImages();
        this.createdDate = board.getCreatedDate();
    }
}
