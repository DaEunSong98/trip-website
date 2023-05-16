package com.ssafy.enjoytrip.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BoardUpdateDto {

    private Long boardId;

    @NotBlank(message = "내용을 입력해주세요")
    private String content;

}
