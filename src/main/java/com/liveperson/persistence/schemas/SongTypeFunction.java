package com.liveperson.persistence.schemas;

import graphql.GraphQLException;
import graphql.annotations.GraphQLAnnotations;
import graphql.annotations.TypeFunction;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;

import java.lang.reflect.AnnotatedType;
import java.util.Collection;
import java.util.Collections;

/**
 * TypeFunction implementation for converting id's to songs
 *
 * @author nirl
 * @since {version}
 */
public class SongTypeFunction implements TypeFunction {

    @Override
    public Collection<Class<?>> getAcceptedTypes() {
        return Collections.singletonList(Integer.class);
    }

    @Override
    public graphql.schema.GraphQLType apply(Class<?> aClass, AnnotatedType annotatedType) {
        try {
            GraphQLObjectType song = GraphQLAnnotations.object(SongObject.class);
            return new GraphQLList(song);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            throw new GraphQLException(e.getMessage());
        }
    }
}