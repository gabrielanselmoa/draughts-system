package com.system.draughts.services;

import com.system.draughts.domain.player.Player;
import com.system.draughts.domain.player.PlayerDTO;
import com.system.draughts.domain.player.PlayerRequestDTO;
import com.system.draughts.repositories.PlayerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Transactional(readOnly = true)
    public List<PlayerDTO> findAll(){
        var list = playerRepository.findAll();
        return list.stream().map(x -> new PlayerDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PlayerDTO findById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isEmpty()){
            throw new EntityNotFoundException("Player not found!!");
        }
        return new PlayerDTO(player.get());
    }

    public List<PlayerDTO> getAllPlayersSortedByRating() {
        List<Player> players = playerRepository.findAllByOrderByRatingDesc();
        return players.stream().map(x -> new PlayerDTO(x)).collect(Collectors.toList());
    }

    public PlayerDTO createPlayer(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setScore(playerDTO.getScore());
        playerRepository.save(player);
        return new PlayerDTO(player);
    }

    public PlayerDTO update(Long id, PlayerRequestDTO dto){
        var player = playerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Player not found!"));
        player.setName(dto.getName());
        player.setScore(dto.getScore());

        playerRepository.save(player);

        return new PlayerDTO(player);
    }

    public void delete(Long id) {
        if (!playerRepository.existsById(id)) {
            throw new EntityNotFoundException("Player not found!");
        }
        playerRepository.deleteById(id);
    }
}

