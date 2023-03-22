package com.cricketgame.cricketgame.dao;

import com.cricketgame.cricketgame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player, String> {
    List<Player> findByTeam(String team);

    Player findByName(String s);


}
