package com.liveperson.persistence.entities;

import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

/**
 * Data object for Album
 *
 * @author nirl
 * @since {version}
 */
public class Album implements Serializable{

    private String name;
    private String artist;
    private Integer year;
    private Integer id;
    private List<Integer> songIds;

    public Album() {
    }

    public Album(String name, String artist, Integer year, Integer id, List<Integer> songIds) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.id = id;
        this.songIds = songIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getSongIds() {
        return songIds;
    }

    public void setSongIds(List<Integer> songIds) {
        this.songIds = songIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        if (artist != null ? !artist.equals(album.artist) : album.artist != null) return false;
        if (id != null ? !id.equals(album.id) : album.id != null) return false;
        if (name != null ? !name.equals(album.name) : album.name != null) return false;
        if (songIds != null ? !songIds.equals(album.songIds) : album.songIds != null) return false;
        if (year != null ? !year.equals(album.year) : album.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (songIds != null ? songIds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("artist", artist)
                .add("year", year)
                .add("id", id)
                .add("songIds", songIds)
                .toString();
    }
}
