package com.liveperson.persistence.transformers;

import com.liveperson.persistence.entities.Album;
import com.liveperson.persistence.schemas.AlbumObject;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Transformer for album entities
 * @author nirl
 * @since {version}
 */
@Component
public class AlbumTransformer {

    public AlbumTransformer() {
    }

    /**
     * Transforms an album from data entity to GraphQL object
     *
     * @param album the album
     * @return GraphQL representation of the album
     */
    public AlbumObject transform(Album album) {
        return new AlbumObject(album.getName(), album.getArtist(), album.getYear(), album.getId());
    }

    /**
     * Transforms a collection of albums from data entities to GraphQL objects
     *
     * @param albums the albums
     * @return GraphQL representation of the albums
     */
    public List<AlbumObject> transform(Collection<Album> albums) {
        return albums.stream().map(this::transform).collect(Collectors.toList());
    }

}
