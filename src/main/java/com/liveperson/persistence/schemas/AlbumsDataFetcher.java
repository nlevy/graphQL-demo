package com.liveperson.persistence.schemas;

import com.liveperson.persistence.MusicDao;
import com.liveperson.persistence.entities.Album;
import com.liveperson.persistence.transformers.AlbumTransformer;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * DataFetcher for fetching list of albums
 *
 * @author nirl
 * @since {version}
 */
@Component
public class AlbumsDataFetcher implements DataFetcher {

    @Autowired
    private MusicDao musicDao;

    @Autowired
    private AlbumTransformer transformer;

    public AlbumsDataFetcher() {

    }

    @Override
    public List<AlbumObject> get(DataFetchingEnvironment environment) {
        String artist = environment.getArgument("artist");
        Optional<MusicDao.OrderBy> orderBy = Optional.ofNullable(environment.getArgument("orderBy"));

        Collection<Album> albums = musicDao.getAlbums(artist, orderBy);
        return transformer.transform(albums);
    }
}
