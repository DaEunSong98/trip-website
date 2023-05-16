package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.service.UserRelationshipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/relationship")
@RequiredArgsConstructor
public class UserRelationshipController {

    private final UserRelationshipService userRelationshipService;

}
