package com.cricketgame.cricketgame.controller;

import com.cricketgame.cricketgame.model.Player;
import com.cricketgame.cricketgame.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class TeamController {

    @Autowired
    TeamService s1;
    @PostMapping("/numberOfTeams/{n}")
    public List<Player> createTeam(@PathVariable int n){
        try {
            s1.verifyTeam(n);
            return s1.createPlayers();
        } catch(Exception e) {
            System.err.println(e);
        }
       return new ArrayList();
    }

}
