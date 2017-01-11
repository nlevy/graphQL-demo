package com.liveperson.persistence.transformers;

import com.liveperson.persistence.entities.Song;
import com.liveperson.persistence.schemas.SongObject;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Transformer for song entities
 *
 * @author nirl
 * @since {version}
 */
@Component
public class SongTransformer {

    public SongTransformer() {
    }

    /**
     * Transforms an song from data entity to GraphQL object
     *
     * @param song the song
     * @return GraphQL representation of the song
     */
    public SongObject transform(Song song) {
        return new SongObject(song.getName(), song.getAlbumId(), song.getTrackNumber(), song.getId());
    }

    /**
     * Transforms a collection of songs from data entities to GraphQL objects
     *
     * @param songs the songs
     * @return GraphQL representation of the songs
     */
    public List<SongObject> transform(Collection<Song> songs) {
        return songs.stream().map(this::transform).collect(Collectors.toList());
    }
}
