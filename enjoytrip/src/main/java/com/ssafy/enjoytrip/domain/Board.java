package com.ssafy.enjoytrip.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;

    private String content;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
