package com.ssafy.enjoytrip.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTripPlan is a Querydsl query type for TripPlan
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTripPlan extends EntityPathBase<TripPlan> {

    private static final long serialVersionUID = 131216115L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTripPlan tripPlan = new QTripPlan("tripPlan");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath planContent = createString("planContent");

    public final StringPath planName = createString("planName");

    public final NumberPath<Long> tripPlanId = createNumber("tripPlanId", Long.class);

    public final QTripTeam tripTeam;

    public QTripPlan(String variable) {
        this(TripPlan.class, forVariable(variable), INITS);
    }

    public QTripPlan(Path<? extends TripPlan> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTripPlan(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTripPlan(PathMetadata metadata, PathInits inits) {
        this(TripPlan.class, metadata, inits);
    }

    public QTripPlan(Class<? extends TripPlan> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tripTeam = inits.isInitialized("tripTeam") ? new QTripTeam(forProperty("tripTeam"), inits.get("tripTeam")) : null;
    }

}

