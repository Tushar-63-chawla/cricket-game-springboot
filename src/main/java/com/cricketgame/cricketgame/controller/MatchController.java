package com.cricketgame.cricketgame.controller;

import com.cricketgame.cricketgame.service.MatchService;
import com.cricketgame.cricketgame.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {
    @Autowired
    TournamentService s1;

    @GetMapping("/runMatch")
    public String runMatch(){
        return s1.runMatchIni();
    }
}
