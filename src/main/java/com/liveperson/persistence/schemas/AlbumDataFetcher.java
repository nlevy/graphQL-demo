package com.liveperson.persistence.schemas;

import com.liveperson.persistence.MusicDao;
import com.liveperson.persistence.entities.Album;
import com.liveperson.persistence.transformers.AlbumTransformer;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DataFetcher for fetching an album
 *
 * @author nirl
 * @since {version}
 */
@Component
public class AlbumDataFetcher implements DataFetcher {

    @Autowired
    private MusicDao musicDao;

    @Autowired
    private AlbumTransformer transformer;

    public AlbumDataFetcher() {
        System.out.println();
    }

    @Override
    public AlbumObject get(DataFetchingEnvironment environment) {
        String artist = environment.getArgument("artist");
        String album = environment.getArgument("album");

        Album albumEntity = musicDao.getAlbum(artist, album);
        return transformer.transform(albumEntity);
    }
}
