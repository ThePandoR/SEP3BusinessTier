package org.sep3.business.model.service;

import org.sep3.business.model.service.dto.RequestDTO;
import org.sep3.business.model.service.dto.SongRequestDTO;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {

    SongRequestDTO requestSong(RequestDTO request);
    Optional<SongRequestDTO> vote(Long id);
    void markPlayed(Long id);
    List<SongRequestDTO> getPlaylist();
    Optional<SongRequestDTO> getRequest(Long id);
    Optional<SongRequestDTO> playNext();
}
