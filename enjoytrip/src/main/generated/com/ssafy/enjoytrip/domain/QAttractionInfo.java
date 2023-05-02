package com.ssafy.enjoytrip.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAttractionInfo is a Querydsl query type for AttractionInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttractionInfo extends EntityPathBase<AttractionInfo> {

    private static final long serialVersionUID = -1682624774L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAttractionInfo attractionInfo = new QAttractionInfo("attractionInfo");

    public final StringPath addr1 = createString("addr1");

    public final StringPath addr2 = createString("addr2");

    public final NumberPath<Integer> contentId = createNumber("contentId", Integer.class);

    public final NumberPath<Integer> contentTypeId = createNumber("contentTypeId", Integer.class);

    public final StringPath firstImage = createString("firstImage");

    public final StringPath firstImage2 = createString("firstImage2");

    public final QGugun gugun;

    public final NumberPath<java.math.BigDecimal> latitude = createNumber("latitude", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> longitude = createNumber("longitude", java.math.BigDecimal.class);

    public final StringPath mlevel = createString("mlevel");

    public final NumberPath<Integer> readcount = createNumber("readcount", Integer.class);

    public final QSido sido;

    public final StringPath tel = createString("tel");

    public final StringPath title = createString("title");

    public final StringPath zipcode = createString("zipcode");

    public QAttractionInfo(String variable) {
        this(AttractionInfo.class, forVariable(variable), INITS);
    }

    public QAttractionInfo(Path<? extends AttractionInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAttractionInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAttractionInfo(PathMetadata metadata, PathInits inits) {
        this(AttractionInfo.class, metadata, inits);
    }

    public QAttractionInfo(Class<? extends AttractionInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.gugun = inits.isInitialized("gugun") ? new QGugun(forProperty("gugun"), inits.get("gugun")) : null;
        this.sido = inits.isInitialized("sido") ? new QSido(forProperty("sido")) : null;
    }

}

