package com.liveperson.persistence;

import com.liveperson.persistence.entities.Album;
import com.liveperson.persistence.entities.Song;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Data Access Layer for music info
 * @author nirl
 * @since {version}
 */
public interface MusicDao {

    enum OrderBy {
        YEAR,
        NAME
    }

    /**
     * returns a single song
     *
     * @param id the id of the song
     * @return the requested song, or null if not existing
     */
    Song getSong(int id);

    /**
     * returns a list of songs
     *
     * @param id the id of the song
     * @return the requested song, or null if not existing
     */
    List<Song> getSongs(List<Integer> id);

    /**
     * returns all albums of the requested artist
     *
     * @param artist the artist
     * @param orderBy optional order criteria
     *
     * @return all of the artists albums
     */
    Collection<Album> getAlbums(String artist, Optional<OrderBy> orderBy);

    /**
     * returns a single album
     * @param artist the artist
     * @param album the album name
     *
     * @return the requested album, or null if not existing
     */
    Album getAlbum(String artist, String album);
}
