package org.sep3.business.model.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.sep3.business.model.domain.Playlist;
import org.sep3.business.model.domain.SongRequest;
import org.sep3.business.model.service.dto.RequestDTO;
import org.sep3.business.model.service.dto.SongRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    @NonNull
    private Playlist playlist;
    private static long idcounter = 1;

    //Builder Desing Pattern
    @Override
    public synchronized SongRequestDTO requestSong(RequestDTO request) {
        SongRequest req = SongRequest.builder()
                .id(idcounter++)
                .title(request.getTitle())
                .votes(1)
                .build();

        playlist.add(req);

        return dto(req);
    }

    @Override
    public synchronized Optional<SongRequestDTO> vote(Long id) {

        Optional<SongRequest> request = playlist.stream()
                .filter(s -> s.getId().equals(id))
                .findAny();

        request.ifPresent(SongRequest::vote);

        return request.map(this::dto);
    }

    @Override
    public synchronized void markPlayed(Long id) {

        playlist.removeById(id);
    }

    @Override
    public synchronized List<SongRequestDTO> getPlaylist(){

        return playlist.stream()
                .map(this::dto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SongRequestDTO> getRequest(Long id) {
        return playlist.stream()
                .filter(r -> r.getId() == id)
                .map(this::dto)
                .findAny();
    }

    @Override
    public Optional<SongRequestDTO> playNext() {
        return playlist.next().map(this::dto);
    }

    private SongRequestDTO dto(SongRequest r) {
        return new SongRequestDTO(r.getId(), r.getTitle(), r.getVotes());
    }
}
