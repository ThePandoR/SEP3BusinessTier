package org.sep3.business.model.domain;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

@Component
public class Playlist {


    private List<SongRequest> playlist;

    private Comparator<SongRequest> comparator;

    public Playlist(){
        comparator = Comparator.comparingInt(SongRequest::getVotes)
                .reversed();

        playlist = new LinkedList<>();
    }

    public void add(SongRequest request){

        playlist.add(request);
    }

    public void removeById(Long id){
        playlist.removeIf(r -> r.getId() == id);
    }

    public Stream<SongRequest> stream(){

        return playlist.stream().sorted(comparator);
    }

    public Optional<SongRequest> next(){

        return stream().findFirst();
    }

    @Override
    public String toString() {
        return playlist.toString();
    }
}
