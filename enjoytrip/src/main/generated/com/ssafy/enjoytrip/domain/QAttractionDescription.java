package com.ssafy.enjoytrip.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAttractionDescription is a Querydsl query type for AttractionDescription
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAttractionDescription extends EntityPathBase<AttractionDescription> {

    private static final long serialVersionUID = 412339248L;

    public static final QAttractionDescription attractionDescription = new QAttractionDescription("attractionDescription");

    public final NumberPath<Integer> contentId = createNumber("contentId", Integer.class);

    public final StringPath hompage = createString("hompage");

    public final StringPath overview = createString("overview");

    public final StringPath telName = createString("telName");

    public QAttractionDescription(String variable) {
        super(AttractionDescription.class, forVariable(variable));
    }

    public QAttractionDescription(Path<? extends AttractionDescription> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAttractionDescription(PathMetadata metadata) {
        super(AttractionDescription.class, metadata);
    }

}

