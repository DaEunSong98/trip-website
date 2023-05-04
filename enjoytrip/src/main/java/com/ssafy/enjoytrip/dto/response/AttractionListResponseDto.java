package com.ssafy.enjoytrip.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Attraction List Response 할 때 사용할 응답 객체
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttractionListResponseDto {

    private int contentId;
    private int contentTypeId;
    private String title;
    private String addr1;
    private String addr2;
    private String zipcode;
    private String firstImage;
    private String firstImage2;
    private String sidoName;
    private String gugunName;

}
