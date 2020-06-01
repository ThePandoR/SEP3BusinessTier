package org.sep3.business.controller;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.sep3.business.model.domain.SongRequest;
import org.sep3.business.model.service.PlaylistService;
import org.sep3.business.model.service.dto.RequestDTO;
import org.sep3.business.model.service.dto.SongRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/playlist")
@AllArgsConstructor
public class PlaylistController {

    private PlaylistService service;

    @PostMapping
    public ResponseEntity<SongRequestDTO> request(@RequestBody RequestDTO request){

        return new ResponseEntity<>(service.requestSong(request), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/vote")
    public ResponseEntity<SongRequestDTO> vote(@PathVariable Long id){

        return ResponseEntity.of(service.vote(id));
    }

    @PostMapping("/{id}/markplayed")
    public void markPlayed(@PathVariable Long id){

        service.markPlayed(id);
    }

    @GetMapping
    public List<SongRequestDTO> getPlaylist(){

        return service.getPlaylist();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongRequestDTO> getSong(@PathVariable Long id) {
        return ResponseEntity.of(service.getRequest(id));
    }

    @GetMapping("/next")
    public ResponseEntity<SongRequestDTO> playNext() {

        return ResponseEntity.of(service.playNext());
    }


}
