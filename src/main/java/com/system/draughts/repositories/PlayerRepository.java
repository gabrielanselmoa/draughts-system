package com.system.draughts.repositories;

import com.system.draughts.domain.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM tb_player ORDER BY tb_player.score DESC")
    List<Player> findAllByOrderByRatingDesc();
}
