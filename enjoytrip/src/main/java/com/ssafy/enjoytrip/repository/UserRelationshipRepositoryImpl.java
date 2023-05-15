package com.ssafy.enjoytrip.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.enjoytrip.domain.QUserRelationship;
import com.ssafy.enjoytrip.domain.UserRelationship;
import com.ssafy.enjoytrip.domain.user_relation.Relation;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ssafy.enjoytrip.domain.QUserRelationship.*;

public class UserRelationshipRepositoryImpl implements UserRelationshipRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public UserRelationshipRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
