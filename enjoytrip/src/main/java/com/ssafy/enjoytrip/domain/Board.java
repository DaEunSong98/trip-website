package com.ssafy.enjoytrip.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String content;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Board(Long boardId, String content, String title, User user) {
        this.boardId = boardId;
        this.content = content;
        this.title = title;
        this.user = user;
    }

    public void updateBoard(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
