package com.ssafy.enjoytrip.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserTripTeam is a Querydsl query type for UserTripTeam
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserTripTeam extends EntityPathBase<UserTripTeam> {

    private static final long serialVersionUID = 2073539730L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserTripTeam userTripTeam = new QUserTripTeam("userTripTeam");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final QTripTeam tripTeam;

    public final QUser user;

    public final NumberPath<Long> userTripTeamId = createNumber("userTripTeamId", Long.class);

    public QUserTripTeam(String variable) {
        this(UserTripTeam.class, forVariable(variable), INITS);
    }

    public QUserTripTeam(Path<? extends UserTripTeam> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserTripTeam(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserTripTeam(PathMetadata metadata, PathInits inits) {
        this(UserTripTeam.class, metadata, inits);
    }

    public QUserTripTeam(Class<? extends UserTripTeam> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tripTeam = inits.isInitialized("tripTeam") ? new QTripTeam(forProperty("tripTeam"), inits.get("tripTeam")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

