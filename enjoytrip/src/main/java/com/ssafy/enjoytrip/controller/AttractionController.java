package com.ssafy.enjoytrip.controller;
import java.util.List;
import java.util.stream.Collectors;

import com.ssafy.enjoytrip.dto.response.AttractionListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.enjoytrip.domain.AttractionInfo;
import com.ssafy.enjoytrip.dto.request.AttractionSearch;
import com.ssafy.enjoytrip.service.AttractionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/attraction")
@RequiredArgsConstructor
public class AttractionController{

	private final AttractionService attractionService;

	//목록 조회
	@GetMapping("/search")
	protected ResponseEntity<List<AttractionListResponseDto>> getAttractionList(@ModelAttribute AttractionSearch attractionSearch) {

		log.info("call AttractionController = {}, {}, {}", attractionSearch.getTitle(), attractionSearch.getContentTypeId(), attractionSearch.getPage());

		List<AttractionInfo> list = attractionService.getAllAttraction(attractionSearch);

		List<AttractionListResponseDto> responseList = list.stream()
				.map(o1 -> new AttractionListResponseDto(o1.getContentTypeId(), o1.getContentId(), o1.getTitle(), o1.getAddr1(), o1.getAddr2(), o1.getZipcode(), o1.getFirstImage(), o1.getFirstImage2(), o1.getSido().getSidoName(), o1.getGugun().getGugunName()))
				.collect(Collectors.toList());

		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}

}
