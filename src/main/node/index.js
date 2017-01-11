import express from 'express';
import graphqlHTTP from 'express-graphql';
import schema from './schema';
import DataLoader from 'dataloader';
import ALBUMS from './albums.json';

const app = express();

function getAlbum(id) {
    console.log("Fetching album " + id);
    return ALBUMS.find(album => album.id === id);
}

app.use('/graphql', graphqlHTTP(req => {
        const cacheMap = new Map();
        var albumLoader = new DataLoader(keys => Promise.all(keys.map(getAlbum)), {cacheMap});

        return {
            context: {albumLoader},
            schema: schema,
            graphiql: true
        }
    }));

app.listen(
    5000,
    () => console.log('GraphQL Server running at http://localhost:5000')
);


