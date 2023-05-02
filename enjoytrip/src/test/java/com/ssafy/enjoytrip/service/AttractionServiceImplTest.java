package com.ssafy.enjoytrip.service;

import com.ssafy.enjoytrip.domain.AttractionInfo;
import com.ssafy.enjoytrip.dto.request.AttractionSearch;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AttractionServiceImplTest {

    @Autowired
    private AttractionService attractionService;

    @Test
    @DisplayName("여행지 조회 테스트")
    void test1() {
        AttractionSearch attractionSearch = AttractionSearch.builder().title("산").build();
        List<AttractionInfo> allAttraction = attractionService.getAllAttraction(attractionSearch);
        allAttraction.stream().forEach(o1 -> System.out.println(o1.getTitle()));
    }
}