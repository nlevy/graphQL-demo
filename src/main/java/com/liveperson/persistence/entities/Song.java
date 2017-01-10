package com.liveperson.persistence.entities;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Data object for song
 *
 * @author nirl
 * @since {version}
 */
public class Song implements Serializable {

    private String name;
    private Integer id;
    private Integer albumId;
    private Integer trackNumber;

    public Song() {
    }

    public Song(String name, Integer id, Integer albumId, Integer trackNumber) {
        this.name = name;
        this.id = id;
        this.albumId = albumId;
        this.trackNumber = trackNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (albumId != null ? !albumId.equals(song.albumId) : song.albumId != null) return false;
        if (id != null ? !id.equals(song.id) : song.id != null) return false;
        if (name != null ? !name.equals(song.name) : song.name != null) return false;
        if (trackNumber != null ? !trackNumber.equals(song.trackNumber) : song.trackNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (albumId != null ? albumId.hashCode() : 0);
        result = 31 * result + (trackNumber != null ? trackNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("id", id)
                .add("albumId", albumId)
                .add("trackNumber", trackNumber)
                .toString();
    }
}
