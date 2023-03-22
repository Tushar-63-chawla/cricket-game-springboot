package com.cricketgame.cricketgame.service.implementation;

import com.cricketgame.cricketgame.commonutils.Utils;
import com.cricketgame.cricketgame.dao.PlayerRepo;
import com.cricketgame.cricketgame.model.Player;
import com.cricketgame.cricketgame.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TeamServiceImplementation implements TeamService {
    @Autowired
    PlayerRepo repo;
    private int n;

    public int getN() {
        return n;
    }

    @Override
    public void verifyTeam(int n) {
        if(n % 4 != 0) {
            throw new Error("Please enter a valid Number of Teams!");
        }
        this.n = n;
    }

    @Override
    public List<Player> createPlayers() {
        String[] arr = {"a", "b", "c", "d", "e"};
        for(int i = 1; i <= this.n; ++i) {
            for(int j = 0; j < arr.length; ++j) {
                Player player = Utils.createPlayer(arr[j] + i, Integer.toString(i), ((j & 1) == 0) ? "Batsman" : "Bowler", 0);
                repo.save(player);
            }
        }
        return repo.findAll();
    }
}
