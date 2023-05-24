package com.ssafy.enjoytrip.dto.response;

import com.ssafy.enjoytrip.domain.PlanAttraction;
import lombok.Data;

@Data
public class PlanAttractionResponseDto {

    private Long planAttractionId;

    private int contentTypeId;

    private String title;

    private String addr1;

    private String zipcode;

    private String tel;

    public PlanAttractionResponseDto(PlanAttraction planAttraction) {
        this.planAttractionId = planAttraction.getPlanAttractionId();
        this.contentTypeId = planAttraction.getAttractionInfo().getContentTypeId();
        this.title = planAttraction.getAttractionInfo().getTitle();
        this.addr1 = planAttraction.getAttractionInfo().getAddr1();
        this.zipcode = planAttraction.getAttractionInfo().getZipcode();
        this.tel = planAttraction.getAttractionInfo().getTel();
    }
}
