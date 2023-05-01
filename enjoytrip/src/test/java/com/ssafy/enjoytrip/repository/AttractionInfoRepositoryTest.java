package com.ssafy.enjoytrip.repository;

import com.ssafy.enjoytrip.domain.AttractionInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AttractionInfoRepositoryTest {

    @Autowired
    private AttractionInfoRepository attractionInfoRepository;

    @Test
    @DisplayName("여행지 조회 테스트")
    void test1() {
        List<AttractionInfo> findList = attractionInfoRepository.findAll();
        Assertions.assertThat(findList.size()).isEqualTo(36181);
    }
}