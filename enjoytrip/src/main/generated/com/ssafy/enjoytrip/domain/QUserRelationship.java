package com.ssafy.enjoytrip.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserRelationship is a Querydsl query type for UserRelationship
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserRelationship extends EntityPathBase<UserRelationship> {

    private static final long serialVersionUID = 1046930088L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserRelationship userRelationship = new QUserRelationship("userRelationship");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final EnumPath<com.ssafy.enjoytrip.domain.user_relation.Relation> relation = createEnum("relation", com.ssafy.enjoytrip.domain.user_relation.Relation.class);

    public final QUser targetUser;

    public final QUser user;

    public final NumberPath<Long> userRelationshipId = createNumber("userRelationshipId", Long.class);

    public QUserRelationship(String variable) {
        this(UserRelationship.class, forVariable(variable), INITS);
    }

    public QUserRelationship(Path<? extends UserRelationship> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserRelationship(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserRelationship(PathMetadata metadata, PathInits inits) {
        this(UserRelationship.class, metadata, inits);
    }

    public QUserRelationship(Class<? extends UserRelationship> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.targetUser = inits.isInitialized("targetUser") ? new QUser(forProperty("targetUser")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

