package com.ssafy.enjoytrip.dto.request;

import lombok.Data;

@Data
public class TeamBoardAddRequestDto {

    private String content;

    private String title;

    public TeamBoardAddRequestDto(String content, String title) {
        this.content = content;
        this.title = title;
    }
}
