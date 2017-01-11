package com.liveperson.persistence.schemas;

import graphql.annotations.GraphQLDescription;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;

/**
 * GraphQL object for a song
 *
 * @author nirl
 * @since {version}
 */
@GraphQLName("song")
public class SongObject {

    @GraphQLField
    @GraphQLDescription("Name of the song")
    private String name;

    @GraphQLField
    @GraphQLDescription("Album ID")
    private Integer albumId;

    @GraphQLField
    @GraphQLDescription("The track #")
    private Integer trackNumber;

    @GraphQLField
    @GraphQLDescription("Song unique ID")
    private Integer id;

    public SongObject(String name, Integer albumId, Integer trackNumber, Integer id) {
        this.name = name;
        this.albumId = albumId;
        this.trackNumber = trackNumber;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SongObject that = (SongObject) o;

        if (albumId != null ? !albumId.equals(that.albumId) : that.albumId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (trackNumber != null ? !trackNumber.equals(that.trackNumber) : that.trackNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (albumId != null ? albumId.hashCode() : 0);
        result = 31 * result + (trackNumber != null ? trackNumber.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
