package com.ssafy.enjoytrip.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BoardUpdateDto {

    private Long boardId;

    @NotBlank
    private String content;

}
