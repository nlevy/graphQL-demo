import SONGS from './songs.json';

import {
    GraphQLObjectType,
    GraphQLSchema,
    GraphQLString,
    GraphQLInt,
    GraphQLList
    } from 'graphql';

const AlbumType = new GraphQLObjectType ({
        name: 'AlbumType',
            fields: () => ({
            id: {
                type: GraphQLInt
            },
            name: {
                type: GraphQLString
            },
            artist: {
                type: GraphQLString
            },
            year: {
                type: GraphQLInt
            }
        })
    });

const SongType = new GraphQLObjectType({
    name: 'SongType',
    fields: () => ({
    id: {
        type: GraphQLInt
    },
    name: {
        type: GraphQLString
    },
    trackNumber: {
        type: GraphQLInt
    },
    startDate: {
        type: GraphQLString
    },
    album:  {
        type: AlbumType,
        resolve: (root, args, context) => context.albumLoader.load(root.albumId)
    }
})
});


const QueryType = new GraphQLObjectType({
    name: 'Query',
    description: 'root query',
    fields: () => ({
    songs: {
        type: new GraphQLList(SongType),
        description: 'all songs',
        resolve: (root, args, context) => getSongs()
    }
    })
});

function getSongs() {
    return SONGS;
}

export default new GraphQLSchema({
    query: QueryType,
});