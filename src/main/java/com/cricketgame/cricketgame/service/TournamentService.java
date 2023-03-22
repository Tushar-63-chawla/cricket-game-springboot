package com.cricketgame.cricketgame.service;

import java.util.List;

public interface TournamentService {

    String runMatchSim(List<String> listOfTeams);

    String returnWinningTeam(String team_1, String team_2);

    String returnTournamentWinner();
    String runMatchIni();
}
