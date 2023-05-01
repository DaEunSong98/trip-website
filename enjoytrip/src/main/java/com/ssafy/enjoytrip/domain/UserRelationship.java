package com.ssafy.enjoytrip.domain;

import com.ssafy.enjoytrip.domain.user_relation.Relation;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Builder
@Entity
public class UserRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRelationshipId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_id")
    private User targetUser;

    @Enumerated(EnumType.STRING)
    private Relation relation; // FOLLOW, BLOCK
}
