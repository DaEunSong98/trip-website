package com.ssafy.enjoytrip.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAttractionDetail is a Querydsl query type for AttractionDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttractionDetail extends EntityPathBase<AttractionDetail> {

    private static final long serialVersionUID = 2049212317L;

    public static final QAttractionDetail attractionDetail = new QAttractionDetail("attractionDetail");

    public final StringPath bookTour = createString("bookTour");

    public final StringPath cat1 = createString("cat1");

    public final StringPath cat2 = createString("cat2");

    public final StringPath cat3 = createString("cat3");

    public final NumberPath<Integer> contentId = createNumber("contentId", Integer.class);

    public final StringPath createdTime = createString("createdTime");

    public final StringPath modifiedTime = createString("modifiedTime");

    public QAttractionDetail(String variable) {
        super(AttractionDetail.class, forVariable(variable));
    }

    public QAttractionDetail(Path<? extends AttractionDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttractionDetail(PathMetadata metadata) {
        super(AttractionDetail.class, metadata);
    }

}

