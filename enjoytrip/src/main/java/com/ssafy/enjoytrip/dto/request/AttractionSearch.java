package com.ssafy.enjoytrip.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AttractionSearch {

    String title;

    Integer contentTypeId;

    Integer sidoCode;

    Integer gugunCode;

    @Builder.Default
    private Integer page = 1;

    @Builder.Default
    private Integer size = 20;

    public long getOffset() {
        return (long) (Math.max(1, page) - 1) * Math.min(size, 2000);
    }
}
