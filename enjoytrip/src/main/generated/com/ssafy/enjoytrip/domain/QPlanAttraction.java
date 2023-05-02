package com.ssafy.enjoytrip.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPlanAttraction is a Querydsl query type for PlanAttraction
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPlanAttraction extends EntityPathBase<PlanAttraction> {

    private static final long serialVersionUID = -1864128075L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPlanAttraction planAttraction = new QPlanAttraction("planAttraction");

    public final QBaseTimeEntity _super = new QBaseTimeEntity(this);

    public final QAttractionInfo attractionInfo;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final NumberPath<Long> planAttractionId = createNumber("planAttractionId", Long.class);

    public final QTripPlan tripPlan;

    public QPlanAttraction(String variable) {
        this(PlanAttraction.class, forVariable(variable), INITS);
    }

    public QPlanAttraction(Path<? extends PlanAttraction> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPlanAttraction(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPlanAttraction(PathMetadata metadata, PathInits inits) {
        this(PlanAttraction.class, metadata, inits);
    }

    public QPlanAttraction(Class<? extends PlanAttraction> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.attractionInfo = inits.isInitialized("attractionInfo") ? new QAttractionInfo(forProperty("attractionInfo"), inits.get("attractionInfo")) : null;
        this.tripPlan = inits.isInitialized("tripPlan") ? new QTripPlan(forProperty("tripPlan"), inits.get("tripPlan")) : null;
    }

}

