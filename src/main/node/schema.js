import SONGS from './songs.json';
import ALBUMS from './albums.json';

import {
    GraphQLObjectType,
    GraphQLSchema,
    GraphQLString,
    GraphQLInt,
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
        resolve: (root, args, context) => getAlbum(root.albumId)
    }
})
});


const QueryType = new GraphQLObjectType({
    name: 'Query',
    description: 'root query',
    fields: () => ({
    list: {
        type: new GraphQLList(SongType),
        description: 'all songs',
        resolve: (root, args, context) => getSongs()
    }
    })
});

function getSongs() {
    return SONGS;
}

function getAlbum(id) {
    console.log("Fetching album " + id);
    return ALBUMS.find(album => album.id === id);
}

export default new GraphQLSchema({
    query: QueryType,
});