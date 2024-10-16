package com.system.draughts.controllers;

import com.system.draughts.domain.player.PlayerDTO;
import com.system.draughts.domain.player.PlayerRequestDTO;
import com.system.draughts.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> findById(@PathVariable Long id) {
        PlayerDTO player = playerService.findById(id);
        return ResponseEntity.ok(player);
    }

    @GetMapping(value = "/sort-rating")
    public ResponseEntity<List<PlayerDTO>> getAllPlayersSortedByRating() {
        return ResponseEntity.ok(playerService.getAllPlayersSortedByRating());
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO) {
        return ResponseEntity.ok(playerService.createPlayer(playerDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable Long id, @RequestBody PlayerRequestDTO playerReqDTO) {
        return ResponseEntity.ok(playerService.update(id, playerReqDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

