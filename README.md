# graphQL-demo

Demonstrating the basic capabilities of GraphQL

In this Demo, we will build an API for getting albums and songs data

In order to run this demo, you'll need
 - curl (or equivalent tool for running POST HTTP requests)
 - Java 8 (for stages 1-3)
 - node.js version 6 (stages 4-5)

### stage 1: Getting started, building the basic schema with api for single album (still without songs)

run `git checkout stage1`
start the application (Main class is `GraphQLDemoApplication`)

Run the following commands and get the output from the server:

`curl -d '{"query": "{ album (artist: \"David Bowie\" album: \"Low\" ) { name year }  }"}' -X POST --header "Content-Type:application/json" --header "Accepts:application/json" http://localhost:8080/graphql |json_pp`

`curl -d '{"query": "{ album (artist: \"David Bowie\" album: \"Heroes\" ) { name year artist }  }"}' -X POST --header "Content-Type:application/json" --header "Accepts:application/json" http://localhost:8080/graphql |json_pp`



### stage 2: adding second query with optional field and enum

run `git checkout stage2`
start the application (Main class is `GraphQLDemoApplication`)

Run the following commands and get the output from the server:

`curl -d '{"query": "{ albums (artist: \"Radiohead\" ) { name year artist }  }"}' -X POST --header "Content-Type:application/json" --header "Accepts:application/json" http://localhost:8080/graphql |json_pp`

`curl -d '{"query": "{ albums (artist: \"Radiohead\" orderBy: year ) { name year artist }  }"}' -X POST --header "Content-Type:application/json" --header "Accepts:application/json" http://localhost:8080/graphql |json_pp`


### stage 3: adding additional inner fetcher for songs

run `git checkout stage2`
start the application (Main class is `GraphQLDemoApplication`)

Run the following commands and get the output from the server:

`curl -d '{"query": "{ album (artist: \"David Bowie\" album: \"Lodger\" ) { name year songs {name trackNumber} }  }"}' -X POST --header "Content-Type:application/json" --header "Accepts:application/json" http://localhost:8080/graphql |json_pp`

Run the query from before, without songs - everything is backward compatible:

`curl -d '{"query": "{ album (artist: \"David Bowie\" album: \"Lodger\" ) { name year }  }"}' -X POST --header "Content-Type:application/json" --header "Accepts:application/json" http://localhost:8080/graphql |json_pp`


GraphQL has inner introspection feature to expose the data objects and schemas:

`curl -d '{"query" :  "{ __type (name: \"song\") { name fields {name description type {name}}}}"} ' -X POST --header "Content-Type:application/json" --header "Accepts:application/json" http://localhost:8080/graphql |json_pp`

`curl -d '{"query" :  "{ __schema { queryType { fields { name args { name type { kind }}}}}} "} ' -X POST --header "Content-Type:application/json" --header "Accepts:application/json" http://localhost:8080/graphql |json_pp`


### stage 4: node version, show graphiql

run `git checkout stage2`
start the application:
    cd <project-home>/graphQL-demo/src/main/node/
    npm install
    npm start

On your browser, go to [http://localhost:5000/graphql](http://localhost:5000/graphql)  

Use the following query:  

    {
      songs {
        name
        trackNumber
        album {
          name
          year
        }
      }
    }

look at console output - too many calls, since each song fetches the album data for itself

### stage 5: adding dataLoader to cache the album calls

run the same commands as stage 4, look at console output - one call per album



