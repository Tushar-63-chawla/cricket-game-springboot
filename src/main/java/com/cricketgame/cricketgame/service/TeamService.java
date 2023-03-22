package com.cricketgame.cricketgame.service;

import com.cricketgame.cricketgame.model.Player;

import java.util.List;

public interface TeamService {
    void verifyTeam(int n);

    List<Player> createPlayers();
}
