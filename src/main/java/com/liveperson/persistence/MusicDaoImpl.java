package com.liveperson.persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liveperson.persistence.entities.Album;
import com.liveperson.persistence.entities.Song;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Default implementation of {@link MusicDao}
 * @author nirl
 * @since {version}
 */
@Component
public class MusicDaoImpl implements  MusicDao {

    // id -> song
    private Map<Integer, Song> songs;

    // artist -> name -> album
    private Map<String, Map<String, Album>> albums;

    private Gson gson = new Gson();

    public MusicDaoImpl() throws IOException {
        initData(getClass().getResource("/data/songs.json").getPath(), getClass().getResource("/data/albums.json").getPath());
    }

    @Override
    public Song getSong(int id) {
        return songs.get(id);
    }

    @Override
    public Collection<Album> getAlbums(String artist, Optional<OrderBy> orderBy) {
        return albums.containsKey(artist)
                ? albums.get(artist).values()
                : null;
    }

    @Override
    public Album getAlbum(String artist, String album) {
        return albums.containsKey(artist)
                ? albums.get(artist).get(album)
                : null;
    }

    private void initData(String songsFile, String albumsFile) throws IOException {
        this.songs = getSongsList(songsFile).stream().collect(Collectors.toMap(Song::getId, Function.identity()));
        this.albums = getAlbumsList(albumsFile).stream().collect(Collectors.groupingBy(Album::getArtist, Collectors.toMap(Album::getName, Function.identity())));
    }

    private List<Album> getAlbumsList(String filesPath) throws IOException {
        String songsString = new String(Files.readAllBytes(Paths.get(filesPath)));
        return gson.fromJson(songsString, new TypeToken<List<Album>>() {}.getType());
    }

    private List<Song> getSongsList(String filesPath) throws IOException {
        String songsString = new String(Files.readAllBytes(Paths.get(filesPath)));
        return gson.fromJson(songsString, new TypeToken<List<Song>>() {}.getType());
    }

}
