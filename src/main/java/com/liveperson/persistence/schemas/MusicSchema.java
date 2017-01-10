package com.liveperson.persistence.schemas;

import graphql.annotations.GraphQLAnnotations;
import graphql.schema.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

/**
 * Music GraphQL schema
 *
 * @author nirl
 * @since {version}
 */
@Component
public class MusicSchema {

    private GraphQLSchema schema;

    @Autowired
    private AlbumDataFetcher albumDataFetcher;

    public MusicSchema() {
    }

    @PostConstruct
    private void initSchema() throws IllegalAccessException, NoSuchMethodException, InstantiationException {
        GraphQLObjectType albumObjectType = GraphQLAnnotations.getInstance().getObject(AlbumObject.class);
        GraphQLObjectType rootQueryType = newObject().name("rootQuery")
                // get album
                .field(newFieldDefinition()
                        .argument(new GraphQLArgument.Builder().name("artist").type(nonNull(GraphQLString)).build())
                        .argument(new GraphQLArgument.Builder().name("album").type(nonNull(GraphQLString)).build())
                        .name(albumObjectType.getName()).type(albumObjectType).dataFetcher(albumDataFetcher)
                        .build())
                .build();

        this.schema = GraphQLSchema.newSchema().query(rootQueryType).build();
    }

    private GraphQLNonNull nonNull(GraphQLType wrappedType) {
        return new GraphQLNonNull(wrappedType);
    }

    public GraphQLSchema getSchema() {
        return schema;
    }
}
