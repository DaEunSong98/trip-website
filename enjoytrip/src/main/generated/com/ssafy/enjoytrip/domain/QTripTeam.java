package com.ssafy.enjoytrip.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTripTeam is a Querydsl query type for TripTeam
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTripTeam extends EntityPathBase<TripTeam> {

    private static final long serialVersionUID = 131328551L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTripTeam tripTeam = new QTripTeam("tripTeam");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final QUser master;

    public final StringPath teamName = createString("teamName");

    public final NumberPath<Long> tripTeamId = createNumber("tripTeamId", Long.class);

    public QTripTeam(String variable) {
        this(TripTeam.class, forVariable(variable), INITS);
    }

    public QTripTeam(Path<? extends TripTeam> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTripTeam(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTripTeam(PathMetadata metadata, PathInits inits) {
        this(TripTeam.class, metadata, inits);
    }

    public QTripTeam(Class<? extends TripTeam> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.master = inits.isInitialized("master") ? new QUser(forProperty("master")) : null;
    }

}

