package com.liveperson.persistence.schemas;

import com.liveperson.persistence.MusicDao;
import com.liveperson.persistence.MusicDaoImpl;
import com.liveperson.persistence.entities.Song;
import com.liveperson.persistence.transformers.SongTransformer;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.io.IOException;
import java.util.List;

/**
 * DataFetcher for fetching songs
 *
 * @author nirl
 * @since {version}
 */
public class SongsDataFetcher implements DataFetcher {

    private MusicDao musicDao;
    private SongTransformer songTransformer;

    public SongsDataFetcher() throws IOException {
        musicDao = new MusicDaoImpl();
        songTransformer = new SongTransformer();
    }

    @Override
    public List<SongObject> get(DataFetchingEnvironment environment) {
        if (environment.getSource() != null && environment.getSource() instanceof AlbumObject) {
            List<Song> songs = musicDao.getSongs(((AlbumObject) environment.getSource()).getSongIds());
            return songTransformer.transform(songs);
        } else {
            return null;
        }
    }
}
