package com.liveperson.persistence.schemas;

import graphql.annotations.GraphQLDescription;
import graphql.annotations.GraphQLField;
import graphql.annotations.GraphQLName;

/**
 * GraphQL object of an album
 *
 * @author nirl
 * @since {version}
 */
@GraphQLName("album")
public class AlbumObject {

    @GraphQLField
    @GraphQLDescription("Name of the album")
    private String name;

    @GraphQLField
    @GraphQLDescription("Name of the artist")
    private String artist;

    @GraphQLField
    @GraphQLDescription("Release year")
    private Integer year;

    @GraphQLField
    @GraphQLDescription("Album unique ID")
    private Integer id;

    public AlbumObject(String name, String artist, Integer year, Integer id) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumObject that = (AlbumObject) o;

        if (artist != null ? !artist.equals(that.artist) : that.artist != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
