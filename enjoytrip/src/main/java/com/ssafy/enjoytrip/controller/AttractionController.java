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

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/attraction")
@RequiredArgsConstructor
public class AttractionController{

	private final AttractionService attractionService;

	//목록 조회
	@GetMapping("/search")
	protected ResponseEntity<List<AttractionListResponseDto>> getAttractionList(@Valid AttractionSearch attractionSearch) {

		log.info("call AttractionController = {}, {}, {}", attractionSearch.getTitle(), attractionSearch.getContentTypeId(), attractionSearch.getPage());

		List<AttractionInfo> list = attractionService.getAllAttraction(attractionSearch);

		List<AttractionListResponseDto> responseList = list.stream()
				.map(AttractionListResponseDto::new)
				.collect(Collectors.toList());

		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}

}
